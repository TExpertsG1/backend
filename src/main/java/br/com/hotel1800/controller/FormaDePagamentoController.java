package br.com.hotel1800.controller;

import br.com.hotel1800.dao.FormaDePagamentoDAO;
import br.com.hotel1800.modelo.FormaDePagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FormaDePagamentoController {

    @Autowired
    private FormaDePagamentoDAO FormaDePagamentoDAO;

    @GetMapping("/formaDePagamento")
    public String formaDePagamento(Model model) {
        List<FormaDePagamento> listaFormaDePagamaneto = FormaDePagamentoDAO.readAll();
        model.addAttribute("listaFormaDePagamento", listaFormaDePagamaneto);
        return "lista-pagamento";
    }

}
