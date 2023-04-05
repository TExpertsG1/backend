package br.com.hotel1800.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*@RequestMapping("/sistema")*/
public class SistemaController {
    @GetMapping("/sistema")
    public String sistema() {
        return "lista-sistema";
    }
}
