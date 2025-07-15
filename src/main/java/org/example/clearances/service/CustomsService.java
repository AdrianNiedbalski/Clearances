package org.example.clearances.service;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.Cargo;
import org.example.clearances.model.Customs;
import org.example.clearances.model.CustomsType;
import org.example.clearances.model.TransportType;
import org.example.clearances.repository.CargoRepository;
import org.example.clearances.repository.ClientRepository;
import org.example.clearances.repository.CustomsOfficeRepository;
import org.example.clearances.repository.CustomsRepository;
import org.example.clearances.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomsService {

    private final CustomsRepository customsRepo;
    private final ClientRepository clientRepo;
    private final EmployeeRepository employeeRepo;
    private final CargoRepository cargoRepo;
    private final CustomsOfficeRepository officeRepo;

    public CustomsService(CustomsRepository customsRepo,
                          ClientRepository clientRepo,
                          EmployeeRepository employeeRepo,
                          CargoRepository cargoRepo,
                          CustomsOfficeRepository officeRepo) {
        this.customsRepo  = customsRepo;
        this.clientRepo   = clientRepo;
        this.employeeRepo = employeeRepo;
        this.cargoRepo    = cargoRepo;
        this.officeRepo   = officeRepo;
    }

    @Transactional(readOnly = true)
    public java.util.List<CustomsRequest> getAllCustoms() {
        return customsRepo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CustomsRequest addCustoms(CustomsRequest req) {
        Customs c = new Customs();
        // wymuszony status
        c.setStatus("DO_PRZYGOTOWANIA");
        c.setExporter(clientRepo.findById(req.getExporterId()).orElseThrow());
        c.setImporter(clientRepo.findById(req.getImporterId()).orElseThrow());
        c.setEmployee(employeeRepo.findById(req.getEmployeeId()).orElseThrow());
        c.setCustomsType(CustomsType.valueOf(req.getCustomsType()).name());
        c.setTransportLocation(TransportType.valueOf(req.getTransportLocation()).name());
        Set<Cargo> cargos = cargoRepo.findAllById(req.getCargoIds()).stream().collect(Collectors.toSet());
        c.setCargos(cargos);
        c.setCustomsOffice(officeRepo.findById(req.getCustomsOfficeId()).orElseThrow());
        Customs saved = customsRepo.save(c);
        return toDto(saved);
    }

    @Transactional
    public CustomsRequest updateStatus(Integer id, String newStatus) {
        Customs c = customsRepo.findById(id).orElseThrow();
        c.setStatus(newStatus);
        if ("ZREALIZOWANE".equals(newStatus)) {
            c.setCompletedAt(LocalDateTime.now());
        }
        return toDto(customsRepo.save(c));
    }

    @Transactional
    public CustomsRequest updateCustomsDetails(Integer id, CustomsRequest req) {
        Customs c = customsRepo.findById(id).orElseThrow();
        c.setExporter(clientRepo.findById(req.getExporterId()).orElseThrow());
        c.setImporter(clientRepo.findById(req.getImporterId()).orElseThrow());
        c.setEmployee(employeeRepo.findById(req.getEmployeeId()).orElseThrow());
        c.setCustomsType(CustomsType.valueOf(req.getCustomsType()).name());
        c.setTransportLocation(TransportType.valueOf(req.getTransportLocation()).name());
        c.setCargos(cargoRepo.findAllById(req.getCargoIds()).stream().collect(Collectors.toSet()));
        c.setCustomsOffice(officeRepo.findById(req.getCustomsOfficeId()).orElseThrow());
        c.setStatus(req.getStatus());
        if ("ZREALIZOWANE".equals(req.getStatus()) && c.getCompletedAt() == null) {
            c.setCompletedAt(LocalDateTime.now());
        }
        return toDto(customsRepo.save(c));
    }

    private CustomsRequest toDto(Customs c) {
        CustomsRequest dto = new CustomsRequest();
        dto.setId(c.getId());
        dto.setCustomsType(c.getCustomsType());
        dto.setExporterId(c.getExporter().getId());
        dto.setExporterName(c.getExporter().getName());
        dto.setImporterId(c.getImporter().getId());
        dto.setImporterName(c.getImporter().getName());
        dto.setEmployeeId(c.getEmployee().getId());
        dto.setEmployeeName(c.getEmployee().getLogin());
        dto.setTransportLocation(c.getTransportLocation());
        dto.setCargoIds(c.getCargos().stream().map(Cargo::getId).collect(Collectors.toList()));
        dto.setCustomsOfficeId(c.getCustomsOffice().getId());
        dto.setStatus(c.getStatus());
        dto.setCreatedAt(c.getCreatedAt());
        dto.setCompletedAt(c.getCompletedAt());
        return dto;
    }
}
