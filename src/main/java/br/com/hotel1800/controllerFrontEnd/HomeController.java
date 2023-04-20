package br.com.hotel1800.controllerFrontEnd;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Quarto;
import br.com.hotel1800.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ReservaDAO reservaDAO;
    @Autowired
    private QuartoDAO quartoDAO;

    @GetMapping
    public String index(Model model) {
        List<Object[]> quartos = quartoDAO.readIdNomeQuartos();
        model.addAttribute("quartos", quartos);
        return "frontend/index";
    }

    @PostMapping("/add")
    public String add(Model model, Reserva reserva) {
        System.out.println(reserva);
        reservaDAO.create(reserva);
        String cpf = reserva.getHospede_cpf();
        String email = reserva.getEmail();
        return "redirect:/consultarReservas/" + cpf + "/" + email;
    }

    @PostMapping("/consultar")
    public String consultar(Model model, String hospede_cpf, String email) {
        return "redirect:/consultarReservas/" + hospede_cpf + "/" + email;
    }


    @GetMapping("/consultarReservas/{cpf}/{email}")
    public String consultarReservas(@PathVariable String cpf, @PathVariable String email, Model model) {
        List<Reserva> listaReservas = reservaDAO.readAllCpfEmail(cpf, email);
        List<Double> listaPreco = new ArrayList<Double>();
        List<String> listaQuartos = new ArrayList<String>();

        for (Reserva reserva : listaReservas) {
            Quarto quarto = quartoDAO.read(reserva.getIdquarto());
            List<Double> valoresDaReserva = ReservaDAO.calcularValorTotal(reserva.getIdquarto(), reserva.getData_check_in(), reserva.getData_check_out(), quarto.getDiaria());
            double valorTotalDaReserva = valoresDaReserva.get(0);
            listaPreco.add(valorTotalDaReserva);
            listaQuartos.add(quarto.getNome_quarto());
        }

        model.addAttribute("listaReservas", listaReservas);
        model.addAttribute("listaQuartos", listaQuartos);
        model.addAttribute("listaPreco", listaPreco);
        return "frontend/consultar-reservas";
    }

    @PostMapping("/deletarReservaIndex")
    public String deletarReservaIndex(Integer id) {
        Reserva reserva = reservaDAO.read(id);
        String cpf = reserva.getHospede_cpf();
        String email = reserva.getEmail();
        reservaDAO.delete(id);
        return "redirect:/consultarReservas/" + cpf + "/" + email;
    }

}