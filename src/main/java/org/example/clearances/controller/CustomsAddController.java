package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.CustomsStatus;
import org.example.clearances.repository.*;
import org.example.clearances.service.CustomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customs")
public class CustomsAddController {

    private final CustomsService customsService;
    private final PersonRepository personRepository;
    private final AgentRepository agentRepository;
    private final CustomsTypeRepository customsTypeRepository;
    private final TransportLocationRepository transportLocationRepository;
    private final CargosRepository cargosRepository;
    private final CustomsOfficeRepository customsOfficeRepository;

    public CustomsAddController(
            CustomsService customsService,
            PersonRepository personRepository,
            AgentRepository agentRepository,
            CustomsTypeRepository customsTypeRepository,
            TransportLocationRepository transportLocationRepository,
            CargosRepository cargosRepository,
            CustomsOfficeRepository customsOfficeRepository
    ) {
        this.customsService = customsService;
        this.personRepository = personRepository;
        this.agentRepository = agentRepository;
        this.customsTypeRepository = customsTypeRepository;
        this.transportLocationRepository = transportLocationRepository;
        this.cargosRepository = cargosRepository;
        this.customsOfficeRepository = customsOfficeRepository;
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model) {
        model.addAttribute("customsRequest", new CustomsRequest());
        model.addAttribute("people", personRepository.findAll());
        model.addAttribute("agents", agentRepository.findAll()); // <-- nowa linia
        model.addAttribute("types", customsTypeRepository.findAll());
        model.addAttribute("locations", transportLocationRepository.findAll());
        model.addAttribute("cargosList", cargosRepository.findAll());
        model.addAttribute("offices", customsOfficeRepository.findAll());
        model.addAttribute("statuses", CustomsStatus.values());
        return "customs_add";
    }

    @PostMapping("/add")
    public String addCustoms(@ModelAttribute CustomsRequest request) {
        customsService.addCustoms(request);
        return "redirect:/home";
    }
}
