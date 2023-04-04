package br.com.hotel1800.controller;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class QuartoController {

    @Autowired
    private QuartoDAO quartoDAO;

    @GetMapping("/quartos")
    public String listaQuartos(Model model) {
        List<Quarto> listaQuartos = quartoDAO.readAll();
        model.addAttribute("listaQuartos", listaQuartos);
        return "lista-quartos";
    }

    @GetMapping("/formQuarto")
    public String exibirFormularioQuarto(Model model) {
        model.addAttribute("quarto", new Quarto());
        return "form-quarto";
    }

    @PostMapping("/cadastrarQuarto")
    public String cadastrarQuarto(@ModelAttribute("quarto") Quarto quarto) throws SQLException {
        quartoDAO.create(quarto);
        return "redirect:/quartos";
    }

/*    @GetMapping("/modificarQuarto/{id}")
    public String mostrarFormularioModificarQuarto(@PathVariable Integer id, Model model) {
        Quarto quarto = quartoDAO.read(id);
        model.addAttribute("quarto", quarto);
        return "modificar-quarto";
    }*/

    @PostMapping("/atualizarQuarto")
    public String atualizarQuarto(@ModelAttribute Quarto quarto) {
        quartoDAO.update(quarto);
        return "redirect:/quartos";
    }

/*    @PostMapping("/deletarQuarto")
    public String deletarQuarto(@RequestParam("id") Integer id) {
        quartoDAO.delete(id);
        return "redirect:/quartos";
    }*/

}
