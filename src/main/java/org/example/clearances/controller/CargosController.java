package org.example.clearances.controller;

import org.example.clearances.dto.CargosRequest;
import org.example.clearances.model.Cargos;
import org.example.clearances.repository.TransportTypeRepository;
import org.example.clearances.service.CargosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargosController {

    private final CargosService cargosService;
    private final TransportTypeRepository transportTypeRepository;

    public CargosController(CargosService cargosService, TransportTypeRepository transportTypeRepository) {
        this.cargosService = cargosService;
        this.transportTypeRepository = transportTypeRepository;
    }

    @GetMapping
    public String listCargos(Model model) {
        model.addAttribute("cargosList", cargosService.getAllCargos());
        return "cargos_list";
    }

    @GetMapping("/add-form")
    public String showAddCargoForm(Model model) {
        model.addAttribute("cargosRequest", new CargosRequest());
        model.addAttribute("transportTypes", transportTypeRepository.findAll());
        return "cargos_add";
    }

    @PostMapping("/add")
    public String addCargo(@ModelAttribute CargosRequest request) {
        cargosService.addCargo(request);
        return "redirect:/cargos";
    }
}