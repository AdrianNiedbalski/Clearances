package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.CustomsType;
import org.example.clearances.model.TransportType;
import org.example.clearances.repository.ClientRepository;
import org.example.clearances.repository.CargoRepository;
import org.example.clearances.repository.CustomsOfficeRepository;
import org.example.clearances.repository.EmployeeRepository;
import org.example.clearances.service.CustomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/customs")
public class CustomsAddController {

    private final CustomsService customsService;
    private final ClientRepository clientRepo;
    private final EmployeeRepository employeeRepo;
    private final CargoRepository cargoRepo;
    private final CustomsOfficeRepository officeRepo;

    public CustomsAddController(
            CustomsService customsService,
            ClientRepository clientRepo,
            EmployeeRepository employeeRepo,
            CargoRepository cargoRepo,
            CustomsOfficeRepository officeRepo
    ) {
        this.customsService = customsService;
        this.clientRepo     = clientRepo;
        this.employeeRepo   = employeeRepo;
        this.cargoRepo      = cargoRepo;
        this.officeRepo     = officeRepo;
    }

    @GetMapping("/add-form")
    public String showAddForm(Model model) {
        CustomsRequest req = new CustomsRequest();
        req.setStatus("DO_PRZYGOTOWANIA");
        model.addAttribute("customsRequest", req);
        model.addAttribute("clients",    clientRepo.findAll());
        model.addAttribute("employees",  employeeRepo.findAll());
        model.addAttribute("cargosList", cargoRepo.findAll());
        model.addAttribute("offices",    officeRepo.findAll());
        model.addAttribute("types",      Arrays.asList(CustomsType.values()));
        model.addAttribute("locations",  Arrays.asList(TransportType.values()));
        return "customs_add";
    }

    @PostMapping("/save")
    public String saveCustoms(@ModelAttribute CustomsRequest request) {
        request.setStatus("DO_PRZYGOTOWANIA");
        customsService.addCustoms(request);
        return "redirect:/home";
    }
}