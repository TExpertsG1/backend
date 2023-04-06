package br.com.hotel1800.controller;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class QuartoController {

    @Autowired
    private QuartoDAO quartoDAO;

    @GetMapping("/quartos")
    public String listaQuartos(Model model) {
        List<Quarto> listaQuartos = quartoDAO.readAll();
        model.addAttribute("listaQuartos", listaQuartos);
        return "quarto/lista-quartos";
    }

    @GetMapping("/formQuarto")
    public String exibirFormularioQuarto(Model model) {
        model.addAttribute("quarto", new Quarto());
        return "quarto/form-quarto";
    }

    @PostMapping("/cadastrarQuarto")
    public String cadastrarQuarto(Quarto quarto) {
        quartoDAO.create(quarto);
        return "redirect:/quartos";
    }

    @GetMapping("/modificarQuarto/{idquarto}")
    public String mostrarFormularioModificarQuarto(@PathVariable Integer idquarto, Model model) {
        Quarto quarto = quartoDAO.read(idquarto);
        model.addAttribute("quarto", quarto);
        return "quarto/modificar-quarto";
    }

    @PostMapping("/atualizarQuarto")
    public String atualizarQuarto(Quarto quarto) {
        quartoDAO.update(quarto);
        return "redirect:/quartos";
    }

    @PostMapping("/deletarQuarto")
    public String deletarQuarto(Integer idquarto) {
        quartoDAO.delete(idquarto);
        return "redirect:/quartos";
    }
}
