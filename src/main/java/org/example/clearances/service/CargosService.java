package org.example.clearances.service;

import org.example.clearances.dto.CargosRequest;
import org.example.clearances.model.Cargos;
import org.example.clearances.repository.CargosRepository;
import org.example.clearances.repository.TransportTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CargosService {

    private final CargosRepository cargosRepository;
    private final TransportTypeRepository transportTypeRepository;

    public CargosService(CargosRepository cargosRepository, TransportTypeRepository transportTypeRepository) {
        this.cargosRepository = cargosRepository;
        this.transportTypeRepository = transportTypeRepository;
    }

    @Transactional(readOnly = true)
    public List<Cargos> getAllCargos() {
        return cargosRepository.findAll();
    }

    @Transactional
    public Cargos addCargo(CargosRequest request) {
        Cargos cargo = new Cargos();
        cargo.setName(request.getName());
        cargo.setWeight(BigDecimal.valueOf(request.getWeight()));
        cargo.setPrice(BigDecimal.valueOf(request.getPrice()));
        cargo.setInvoiceNumber(request.getInvoiceNumber());
        cargo.setTransportType(
                transportTypeRepository.findById(request.getTransportTypeId())
                        .orElseThrow(() -> new RuntimeException("Nie znaleziono typu transportu"))
        );
        return cargosRepository.save(cargo);
    }
}
