package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.Customs;
import org.example.clearances.model.CustomsStatus;
import org.example.clearances.repository.*;
import org.example.clearances.service.CustomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customs")
public class CustomsDetailsController {

    private final CustomsService customsService;
    private final CustomsRepository customsRepository;
    private final PersonRepository personRepository;
    private final CustomsTypeRepository customsTypeRepository;
    private final TransportLocationRepository transportLocationRepository;
    private final CargosRepository cargosRepository;
    private final CustomsOfficeRepository customsOfficeRepository;

    public CustomsDetailsController(
            CustomsService customsService,
            CustomsRepository customsRepository,
            PersonRepository personRepository,
            CustomsTypeRepository customsTypeRepository,
            TransportLocationRepository transportLocationRepository,
            CargosRepository cargosRepository,
            CustomsOfficeRepository customsOfficeRepository
    ) {
        this.customsService = customsService;
        this.customsRepository = customsRepository;
        this.personRepository = personRepository;
        this.customsTypeRepository = customsTypeRepository;
        this.transportLocationRepository = transportLocationRepository;
        this.cargosRepository = cargosRepository;
        this.customsOfficeRepository = customsOfficeRepository;
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Customs customs = customsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono odprawy"));

        model.addAttribute("customs", customs);
        model.addAttribute("people", personRepository.findAll());
        model.addAttribute("types", customsTypeRepository.findAll());
        model.addAttribute("locations", transportLocationRepository.findAll());
        model.addAttribute("cargosList", cargosRepository.findAll());
        model.addAttribute("offices", customsOfficeRepository.findAll());
        model.addAttribute("statuses", CustomsStatus.values());

        return "customs_details";
    }

    @PostMapping("/update/{id}")
    public String updateCustoms(@PathVariable Long id, @ModelAttribute CustomsRequest request) {
        customsService.updateCustomsDetails(id, request);
        return "redirect:/home?updated=true";
    }
}
