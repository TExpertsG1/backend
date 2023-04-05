package br.com.hotel1800.controller;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


        @Autowired
        private FuncionarioDAO funcionarioDAO;
    @GetMapping
    public String form() {
        return "login/form-login";
    }

    @PostMapping("/login")
    public String login(String cpf, String senha, RedirectAttributes redirectAttributes, HttpSession session) {

       Funcionario funcionario = this.funcionarioDAO.existe(cpf,senha);
        System.out.println(funcionario);

        if(funcionario == null) {
           redirectAttributes.addFlashAttribute("usuarioInvalido","Usuário Inválido");
            return "redirect:/";
        }
        session.setAttribute("logado", funcionario);

        return "redirect:/sistema";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        /*session.removeAttribute("logado");*/
        session.invalidate();
        return "redirect:/";
    }
}