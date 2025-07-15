package org.example.clearances.service;

import org.example.clearances.dto.CargoRequest;
import org.example.clearances.model.Cargo;
import org.example.clearances.repository.CargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional(readOnly = true)
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Transactional
    public Cargo addCargo(CargoRequest request) {
        Cargo cargo = new Cargo();
        cargo.setName(request.getName());
        cargo.setWeight(request.getWeight().intValue());   // jeśli DTO ma Double → intValue()
        cargo.setPrice(request.getPrice().intValue());
        cargo.setInvoiceNumber(request.getInvoiceNumber());
        cargo.setTransportType(request.getTransportType());  // bez .name()
        return cargoRepository.save(cargo);
    }
}
