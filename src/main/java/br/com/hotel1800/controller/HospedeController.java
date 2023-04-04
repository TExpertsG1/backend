package br.com.hotel1800.controller;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.modelo.Hospede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HospedeController {

    @Autowired
    private HospedeDAO hospedeDAO;

    @GetMapping("/hospedes")
    public String listarHospedes(Model model) {
        List<Hospede> hospedes = hospedeDAO.readAll();
        model.addAttribute("hospedes", hospedes);
        return "lista-hospedes";
    }

    @GetMapping("/formHospede")
    public String exibirFormularioHospede(Model model) {
        model.addAttribute("hospede", new Hospede());
        return "form-hospede";
    }

    @PostMapping("/cadastrarHospede")
    public String cadastrarHospede(@ModelAttribute("hospede") Hospede hospede) {
        System.out.println(hospede.getData_nascimento());
        hospedeDAO.create(hospede);
        return "redirect:/hospedes";
    }

    @GetMapping("/mostrarHospede/{cpf}")
    public String buscarHospede(@PathVariable String cpf, Model model) {
        Hospede hospede = hospedeDAO.read(cpf);
        model.addAttribute("hospede", hospede);
        return "detalhes-hospede";
    }

    @GetMapping("/modificarHospede/{cpf}")
    public String mostrarFormularioModificarHospede(@PathVariable String cpf, Model model) {
        Hospede hospede = hospedeDAO.read(cpf);
        model.addAttribute("hospede", hospede);
        return "modificar-hospede";
    }

    @PostMapping("/atualizarHospede")
    public String atualizarHospede(@ModelAttribute Hospede hospede) {
        hospedeDAO.update(hospede);
        return "redirect:/hospedes";
    }

    @PostMapping("/deletarHospede")
    public String deletarHospede(@RequestParam String cpf) {
        hospedeDAO.delete(cpf);
        return "redirect:/hospedes";
    }

}
