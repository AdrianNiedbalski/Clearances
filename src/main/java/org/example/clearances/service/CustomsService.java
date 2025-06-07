package org.example.clearances.service;
import org.example.clearances.model.Agent;
import org.example.clearances.model.Person;
import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.*;
import org.example.clearances.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomsService {

    private final CustomsRepository customsRepository;
    private final PersonRepository personRepository;
    private final AgentRepository agentRepository;
    private final CustomsTypeRepository customsTypeRepository;
    private final TransportLocationRepository transportLocationRepository;
    private final CargosRepository cargosRepository;
    private final CustomsOfficeRepository customsOfficeRepository;

    public CustomsService(
            CustomsRepository customsRepository,
            PersonRepository personRepository,
            AgentRepository agentRepository,
            CustomsTypeRepository customsTypeRepository,
            TransportLocationRepository transportLocationRepository,
            CargosRepository cargosRepository,
            CustomsOfficeRepository customsOfficeRepository
    ) {
        this.customsRepository = customsRepository;
        this.personRepository = personRepository;
        this.agentRepository = agentRepository;
        this.customsTypeRepository = customsTypeRepository;
        this.transportLocationRepository = transportLocationRepository;
        this.cargosRepository = cargosRepository;
        this.customsOfficeRepository = customsOfficeRepository;
    }

    @Transactional(readOnly = true)
    public List<Customs> getAllCustoms() {
        return customsRepository.findAll();
    }

    @Transactional
    public Customs addCustoms(CustomsRequest request) {
        Customs customs = new Customs();
        customs.setExporter(findPerson(request.getExporterId()));
        customs.setImporter(findPerson(request.getImporterId()));
        customs.setAgent(findAgent(request.getAgentId()));
        customs.setCustomsType(customsTypeRepository.findById(request.getCustomsTypeId())
                .orElseThrow(() -> new RuntimeException("Typ odprawy nie znaleziony")));
        customs.setTransportLocation(transportLocationRepository.findById(request.getTransportLocationId())
                .orElseThrow(() -> new RuntimeException("Lokalizacja nie znaleziona")));
        customs.setCargos(cargosRepository.findById(request.getCargosId())
                .orElseThrow(() -> new RuntimeException("Ładunek nie znaleziony")));
        customs.setCustomsOffice(customsOfficeRepository.findById(request.getCustomsOfficeId())
                .orElseThrow(() -> new RuntimeException("Urząd celny nie znaleziony")));
        customs.setStatus(request.getStatus());
        return customsRepository.save(customs);
    }

    @Transactional
    public Customs updateStatus(Long id, CustomsStatus status) {
        return customsRepository.findById(id)
                .map(c -> {
                    c.setStatus(status);
                    return customsRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Nie znaleziono odprawy o ID " + id));
    }

    @Transactional
    public Optional<Customs> updateCustomsDetails(Long id, CustomsRequest request) {
        return customsRepository.findById(id)
                .map(customs -> {
                    customs.setExporter(findPerson(request.getExporterId()));
                    customs.setImporter(findPerson(request.getImporterId()));
                    customs.setAgent(findAgent(request.getAgentId()));
                    customs.setCustomsType(customsTypeRepository.findById(request.getCustomsTypeId())
                            .orElseThrow(() -> new RuntimeException("Typ odprawy nie znaleziony")));
                    customs.setTransportLocation(transportLocationRepository.findById(request.getTransportLocationId())
                            .orElseThrow(() -> new RuntimeException("Lokalizacja nie znaleziona")));
                    customs.setCargos(cargosRepository.findById(request.getCargosId())
                            .orElseThrow(() -> new RuntimeException("Ładunek nie znaleziony")));
                    customs.setCustomsOffice(customsOfficeRepository.findById(request.getCustomsOfficeId())
                            .orElseThrow(() -> new RuntimeException("Urząd celny nie znaleziony")));
                    customs.setStatus(request.getStatus());
                    return customsRepository.saveAndFlush(customs);
                });
    }

    private Person findPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Osoba nie znaleziona: ID " + id));
    }

    private Agent findAgent(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent nie znaleziony: ID " + id));
    }
}
