package br.com.hotel1800.controller;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private ReservaDAO reservaDAO;

    @Autowired
    private QuartoDAO quartoDAO;

    @Autowired
    private HospedeDAO hospedeDAO;

    @GetMapping("/reservas")
    public String listaReservas(Model model) {
        List<Reserva> reservas = reservaDAO.readAll();
        model.addAttribute("reservas", reservas);
        return "reserva/lista-reservas";
    }

    @GetMapping("/formReserva")
    public String exibirFormularioReserva(Model model) {
        List<String> hospedes = hospedeDAO.readHospedeCPFS();
        List<Object[]> quartos = quartoDAO.readIdNomeQuartos();

        model.addAttribute("reserva", new Reserva());
        model.addAttribute("hospedes", hospedes);
        model.addAttribute("quartos", quartos);

        return "reserva/form-reserva";
    }

    @PostMapping("/cadastrarReserva")
    public String cadastrarReserva(Reserva reserva) {
        reservaDAO.create(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/modificarReserva/{idreserva}")
    public String mostrarFormularioModificarReserva(@PathVariable Integer idreserva, Model model) {
        Reserva reserva = reservaDAO.read(idreserva);

        List<String> hospedes = hospedeDAO.readHospedeCPFS();
        List<Object[]> quartos = quartoDAO.readIdNomeQuartos();

        model.addAttribute("reserva", reserva);
        model.addAttribute("hospedes", hospedes);
        model.addAttribute("quartos", quartos);

        return "reserva/modificar-reserva";
    }

    @PostMapping("/atualizarReserva")
    public String atualizarReserva(Reserva reserva) {
        reservaDAO.update(reserva);
        return "redirect:/reservas";
    }

    @PostMapping("/deletarReserva")
    public String deletarReserva(Integer id) {
        reservaDAO.delete(id);
        return "redirect:/reservas";
    }
}
