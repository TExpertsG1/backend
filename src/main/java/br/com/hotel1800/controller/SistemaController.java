package br.com.hotel1800.controller;

import br.com.hotel1800.dao.*;
import br.com.hotel1800.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SistemaController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Autowired
    private HospedeDAO hospedeDAO;

    @Autowired
    private ReservaDAO reservaDAO;

    @Autowired
    private QuartoDAO quartoDAO;

    @Autowired
    private CargoDAO cargoDAO;

    @GetMapping("/sistema")
    public String sistema(HttpSession session, Model model) {
        if (session.getAttribute("logado") == null) {
            return "redirect:/login";
        }

        List<Funcionario> funcionarios = funcionarioDAO.readAll();
        List<Hospede> hospedes = hospedeDAO.readAll();
        List<Reserva> reservas = reservaDAO.readAll();
        List<Quarto> quartos = quartoDAO.readAll();
        List<Cargo> cargos = cargoDAO.readAll();

        int listaFuncionarios = funcionarios.size();
        int listaHospedes = hospedes.size();
        int listaReservas = reservas.size();
        int listaQuartos = quartos.size();
        int listaCargos = cargos.size();

        model.addAttribute("listaFuncionarios", listaFuncionarios);
        model.addAttribute("listaHospedes", listaHospedes);
        model.addAttribute("listaReservas", listaReservas);
        model.addAttribute("listaQuartos", listaQuartos);
        model.addAttribute("listaCargos", listaCargos);

        return "sistema/sistema";
    }
}