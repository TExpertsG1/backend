package br.com.hotel1800.controller;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioDAO.readAll();
        model.addAttribute("funcionarios", funcionarios);
        return "lista-funcionarios";
    }

    @GetMapping("/formFuncionario")
    public String exibirFormularioFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "form-funcionario";
    }

    @PostMapping("/cadastrarFuncionario")
    public String cadastrarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioDAO.create(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/mostrarFuncionario/{cpf}")
    public String buscarFuncionario(@PathVariable String cpf, Model model) {
        Funcionario funcionario = funcionarioDAO.read(cpf);
        model.addAttribute("funcionario", funcionario);
        return "detalhes-funcionario";
    }

    @GetMapping("/modificarFuncionario/{cpf}")
    public String mostrarFormularioModificarFuncionario(@PathVariable String cpf, Model model) {
        Funcionario funcionario = funcionarioDAO.read(cpf);
        model.addAttribute("funcionario", funcionario);
        return "modificar-funcionario";
    }

    @PostMapping("/atualizarFuncionario")
    public String atualizarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
        return "redirect:/funcionarios";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam String cpf) {
        funcionarioDAO.delete(cpf);
        return "redirect:/funcionarios";
    }

}