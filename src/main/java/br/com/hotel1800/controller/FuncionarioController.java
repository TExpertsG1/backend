package br.com.hotel1800.controller;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioDAO.readAll();
        model.addAttribute("funcionarios", funcionarios);
        return "lista-funcionario";
    }

    @GetMapping("/formFuncionario")
    public String exibirFormularioFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "form-funcionario";
    }

    @PostMapping("/cadastroFuncionario")
    public String cadastrarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioDAO.create(funcionario);
        return "redirect:/funcionarios";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam String cpf) {
        funcionarioDAO.delete(cpf);
        return "redirect:/funcionarios";
    }

}