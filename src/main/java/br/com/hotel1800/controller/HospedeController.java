package br.com.hotel1800.controller;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.modelo.Hospede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HospedeController {

    @Autowired
    private HospedeDAO hospedeDAO;

    @GetMapping("/hospedes")
    public String listarHospedes(Model model) {
        List<Hospede> hospedes = hospedeDAO.readAll();
        model.addAttribute("hospedes", hospedes);
        return "hospede/lista-hospedes";
    }

    @GetMapping("/formHospede")
    public String exibirFormularioHospede(Model model) {
        model.addAttribute("hospede", new Hospede());
        return "hospede/form-hospede";
    }

    @PostMapping("/cadastrarHospede")
    public String cadastrarHospede(Hospede hospede) {
        hospedeDAO.create(hospede);
        return "redirect:/hospedes";
    }

    @GetMapping("/mostrarHospede/{cpf}")
    public String buscarHospede(@PathVariable String cpf, Model model) {
        Hospede hospede = hospedeDAO.read(cpf);
        model.addAttribute("hospede", hospede);
        return "hospede/detalhes-hospede";
    }

    @GetMapping("/modificarHospede/{cpf}")
    public String mostrarFormularioModificarHospede(@PathVariable String cpf, Model model) {
        Hospede hospede = hospedeDAO.read(cpf);
        model.addAttribute("hospede", hospede);
        return "hospede/modificar-hospede";
    }

    @PostMapping("/atualizarHospede")
    public String atualizarHospede(Hospede hospede) {
        hospedeDAO.update(hospede);
        return "redirect:/hospedes";
    }

    @PostMapping("/deletarHospede")
    public String deletarHospede(String cpf) {
        hospedeDAO.delete(cpf);
        return "redirect:/hospedes";
    }

}
