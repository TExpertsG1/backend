package br.com.hotel1800.controller;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @GetMapping("/login")
    public String form() {
        return "login/form-login";
    }

    @PostMapping("/login")
    public String login(String cpf, String senha, RedirectAttributes redirectAttributes, HttpSession session) {
        Funcionario funcionario = this.funcionarioDAO.existe(cpf, senha);

        if (funcionario == null) {
            redirectAttributes.addFlashAttribute("usuarioInvalido", "Usuário Inválido");
            return "redirect:/login";
        }

        session.setAttribute("logado", funcionario);

        return "redirect:/sistema";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
