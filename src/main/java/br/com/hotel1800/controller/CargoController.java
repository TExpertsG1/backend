package br.com.hotel1800.controller;

import br.com.hotel1800.dao.CargoDAO;
import br.com.hotel1800.modelo.Cargo;
import br.com.hotel1800.modelo.Hospede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

    @GetMapping("/formCargo")
    public String exibirFormularioHospede(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "form-cargo";
    }

    @PostMapping("/cadastrarCargo")
    public String cadastrarCargo(@ModelAttribute("cargo") Cargo cargo) throws SQLException {
        cargoDAO.create(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/modificarCargo/{idcargo}")
    public String mostrarFormularioModificarCargo(@PathVariable Integer idcargo, Model model) {
        Cargo cargo = cargoDAO.read(idcargo);
        model.addAttribute("cargo", cargo);
        return "modificar-cargo";
    }

    @PostMapping("/atualizarCargo")
    public String atualizarCargo(@ModelAttribute Cargo Cargo) {
        cargoDAO.update(Cargo);
        return "redirect:/cargos";
    }

    @PostMapping("/deletarCargo")
    public String deletarCargo(@RequestParam("idcargos") Integer id) {
        cargoDAO.delete(id);
        return "redirect:/cargos";
    }

}
