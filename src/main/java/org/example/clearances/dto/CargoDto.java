package org.example.clearances.dto;

import java.util.List;

public record CargoDto(
        Integer id,
        String  name,
        Integer weight,
        Integer price,
        String  invoiceNumber,
        String  transportType      // enum name
) {}