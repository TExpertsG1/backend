package br.com.hotel1800.controller;

import br.com.hotel1800.dao.HotelDAO;
import br.com.hotel1800.modelo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelDAO hotelDAO;

    @GetMapping("/hoteis")
    public String listaHoteis(Model model) {
        List<Hotel> hoteis = hotelDAO.readAll();
        System.out.println(hoteis);
        model.addAttribute("hoteis", hoteis);
        return "hotel/lista-hoteis";
    }

    @GetMapping("/formHotel")
    public String exibirFormularioHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotel/form-hotel";
    }

    @PostMapping("/cadastrarHotel")
    public String cadastrarHotel(Hotel hotel) {
        hotelDAO.create(hotel);
        return "redirect:/hoteis";
    }

    @GetMapping("/modificarHotel/{cnpj}")
    public String mostrarFormularioModificarHotel(@PathVariable String cnpj, Model model) {
        Hotel hotel = hotelDAO.read(cnpj);

        System.out.println(hotel);

        model.addAttribute("hotel", hotel);
        return "hotel/modificar-hotel";
    }

    @PostMapping("/atualizarHotel")
    public String atualizarHotel(Hotel hotel) {
        hotelDAO.update(hotel);
        return "redirect:/hoteis";
    }

    @PostMapping("/deletarHotel")
    public String deletarHotel(String cnpj) {
        hotelDAO.delete(cnpj);
        return "redirect:/hoteis";
    }

}