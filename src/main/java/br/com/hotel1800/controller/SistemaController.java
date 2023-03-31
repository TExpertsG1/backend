package br.com.hotel1800.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SistemaController {
    @GetMapping("/sistema")
    public String sistema() {
        return "lista-sistema";
    }
}
