package br.com.hotel1800.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SistemaController {
    @GetMapping("/sistema")
    public String sistema(HttpSession session) {
        if(session.getAttribute("logado") == null){
            return "redirect:/";
        }
            return "sistema/sistema";
        }

    @GetMapping("/sistema2")
    public String sistema2() {
        return "lista-sistema";
    }

    }

