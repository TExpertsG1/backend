package br.com.hotel1800.controllerFrontEnd;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ReservaDAO reservaDAO;
    @Autowired
    private QuartoDAO quartoDAO;

    @GetMapping("/index")
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
    public String consultar(Model model, String cpf, String email) {
        return "redirect:/consultarReservas/" + cpf + "/" + email;
    }

    @GetMapping("/consultarReservas/{cpf}/{email}")
    public String consultarReservas(@PathVariable String cpf, @PathVariable String email, Model model) {
        List<Reserva> listaReservas = reservaDAO.readAllCpfEmail(cpf, email);
        model.addAttribute("listaReservas", listaReservas);
        return "frontend/consultar-reservas";
    }

    @PostMapping("/deletarReservaIndex")
    public String deletarReservaIndex(Integer id, RedirectAttributes redirectAttributes) {
        Reserva reserva = reservaDAO.read(id);
        String cpf = reserva.getHospede_cpf();
        reservaDAO.delete(id);
        redirectAttributes.addAttribute("cpf", cpf);
        return "redirect:/reservasIndex/" + cpf;
    }

}