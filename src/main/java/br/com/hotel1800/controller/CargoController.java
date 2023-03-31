package br.com.hotel1800.controller;

import br.com.hotel1800.dao.CargoDAO;
import br.com.hotel1800.modelo.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//@RequestMapping("hotel1800")
@org.springframework.stereotype.Controller
public class CargoController {

    @Autowired
    private CargoDAO cargoDAO;

    @GetMapping("/cargos")
    public String listaCargos(Model model) {
        List<Cargo> listaCargos = cargoDAO.readAll();
        model.addAttribute("listaCargos", listaCargos);
        return "lista-cargos";
    }

    @PostMapping("/deletarCargo")
    public String deletarCargo(@RequestParam("idcargos") Integer id) {
        cargoDAO.delete(id);
        return "redirect:/cargos";
    }

    @GetMapping("/modificarCargo/{idcargos}")
    public String modificarCargo(@PathVariable Integer idcargos, Model model) {
        Cargo cargo = cargoDAO.read(idcargos);
        model.addAttribute("cargo", cargo);
        return "form-cargo";
    }

}
