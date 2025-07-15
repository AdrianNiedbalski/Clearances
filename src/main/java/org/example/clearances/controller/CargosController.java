package org.example.clearances.controller;

import org.example.clearances.dto.CargoRequest;
import org.example.clearances.service.CargoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargosController {

    private final CargoService cargoService;
    // Lista dozwolonych transportów – musi się zgadzać z danymi w kolumnie transport_type
    private static final List<String> TRANSPORT_TYPES = List.of(
            "SAMOCHOD",
            "KOLEJ",
            "STATEK",
            "SAMOLOT"
    );

    public CargosController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public String listCargos(Model model) {
        model.addAttribute("cargosList", cargoService.getAllCargos());
        return "cargos_list";
    }

    @GetMapping("/add-form")
    public String showAddCargoForm(Model model) {
        model.addAttribute("cargosRequest", new CargoRequest());
        model.addAttribute("transportTypes", TRANSPORT_TYPES);
        return "cargos_add";
    }

    @PostMapping("/add")
    public String addCargo(@ModelAttribute("cargosRequest") CargoRequest request) {
        // Upewnij się, że DTO ma pole `private String transportType;`
        cargoService.addCargo(request);
        return "redirect:/cargos";
    }
}