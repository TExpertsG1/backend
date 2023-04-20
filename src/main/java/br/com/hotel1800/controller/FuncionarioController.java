package br.com.hotel1800.controller;

import br.com.hotel1800.dao.CargoDAO;
import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Cargo;
import br.com.hotel1800.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Autowired
    private CargoDAO cargoDAO;

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioDAO.readAll();
        Map<Integer, String> cargoMap = cargoDAO.getCargoMap();

        System.out.println(cargoMap);
        System.out.println(cargoMap.get(13));

        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("cargoMap", cargoMap);

        return "funcionario/lista-funcionarios";
    }

    @GetMapping("/formFuncionario")
    public String exibirFormularioFuncionario(Model model) {
        Map<Integer, String> cargoMap = cargoDAO.getCargoMap();
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("cargoMap", cargoMap);
        return "funcionario/form-funcionario";
    }

    @PostMapping("/cadastrarFuncionario")
    public String cadastrarFuncionario(Funcionario funcionario) {


        funcionarioDAO.create(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/mostrarFuncionario/{cpf}")
    public String buscarFuncionario(@PathVariable String cpf, Model model) {
        Map<Integer, String> cargoMap = cargoDAO.getCargoMap();
        Funcionario funcionario = funcionarioDAO.read(cpf);
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("cargoMap", cargoMap);
        return "funcionario/detalhes-funcionario";
    }

    @GetMapping("/modificarFuncionario/{cpf}")
    public String mostrarFormularioModificarFuncionario(@PathVariable String cpf, Model model) {
        Funcionario funcionario = funcionarioDAO.read(cpf);
        Map<Integer, String> cargoMap = cargoDAO.getCargoMap();
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("cargoMap", cargoMap);
        return "funcionario/modificar-funcionario";
    }

    @PostMapping("/atualizarFuncionario")
    public String atualizarFuncionario(Funcionario funcionario)  {
        System.out.println(funcionario);
        funcionarioDAO.update(funcionario);
        return "redirect:/funcionarios";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(String cpf) {
        funcionarioDAO.delete(cpf);
        return "redirect:/funcionarios";
    }

}