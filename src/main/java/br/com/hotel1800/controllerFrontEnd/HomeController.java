package br.com.hotel1800.controllerFrontEnd;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
/*@RequestMapping("/carrinho")*/
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
        reservaDAO.create(reserva);
        String cpf = reserva.getHospede_cpf();
        return "redirect:/reservasIndex/" + cpf;
    }

    @GetMapping("/reservasIndex/{cpf}")
    public String listaReservasIndex(@PathVariable String cpf, Model model) {
        List<Reserva> reservasIndex = reservaDAO.readAllCpf(cpf);
        System.out.println(cpf);
        model.addAttribute("reservasIndex", reservasIndex);
        return "frontend/reservaconfirmada";
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
