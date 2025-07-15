package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.Client;
import org.example.clearances.model.Customs;
import org.example.clearances.model.CustomsStatus;
import org.example.clearances.model.CustomsType;
import org.example.clearances.model.TransportLocation;
import org.example.clearances.service.CustomsService;
import org.example.clearances.repository.CargoRepository;
import org.example.clearances.repository.ClientRepository;
import org.example.clearances.repository.CustomsOfficeRepository;
import org.example.clearances.repository.CustomsRepository;
import org.example.clearances.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/customs")
public class CustomsDetailsController {

    private final CustomsService           customsService;
    private final CustomsRepository        customsRepository;
    private final ClientRepository         clientRepo;
    private final EmployeeRepository       employeeRepo;
    private final CargoRepository          cargoRepo;
    private final CustomsOfficeRepository  officeRepo;

    public CustomsDetailsController(
            CustomsService customsService,
            CustomsRepository customsRepository,
            ClientRepository clientRepo,
            EmployeeRepository employeeRepo,
            CargoRepository cargoRepo,
            CustomsOfficeRepository officeRepo
    ) {
        this.customsService    = customsService;
        this.customsRepository = customsRepository;
        this.clientRepo        = clientRepo;
        this.employeeRepo      = employeeRepo;
        this.cargoRepo         = cargoRepo;
        this.officeRepo        = officeRepo;
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Integer id, Model model) {
        Customs customs = customsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono odprawy id=" + id));

        List<Client> clients = clientRepo.findAll().stream()
                .sorted(Comparator.comparing(Client::getName))
                .toList();

        model.addAttribute("customs",            customs);
        model.addAttribute("statuses",           CustomsStatus.values());
        model.addAttribute("types",              CustomsType.values());
        model.addAttribute("clients",            clients);
        model.addAttribute("employees",          employeeRepo.findAll());
        model.addAttribute("cargos",             cargoRepo.findAll());
        model.addAttribute("offices",            officeRepo.findAll());
        model.addAttribute("transportLocations", TransportLocation.values());

        return "customs_details";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @RequestParam("customsType")       String customsType,
            @RequestParam("exporterId")        Integer exporterId,
            @RequestParam("importerId")        Integer importerId,
            @RequestParam("employeeId")        Integer employeeId,
            @RequestParam("status")            String status,
            @RequestParam("cargoId")           Integer cargoId,
            @RequestParam("customsOfficeId")   Integer officeId,
            @RequestParam("transportLocation") String transportLocation
    ) {
        CustomsRequest dto = new CustomsRequest();
        dto.setCustomsType(customsType);
        dto.setExporterId(exporterId);
        dto.setImporterId(importerId);
        dto.setEmployeeId(employeeId);
        dto.setStatus(status);
        dto.setCargoIds(List.of(cargoId));
        dto.setCustomsOfficeId(officeId);
        dto.setTransportLocation(transportLocation);

        //customsService.updateCustomsDetails(id, dto);
        return "redirect:/home?updated=true";
    }
}
