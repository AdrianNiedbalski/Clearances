package org.example.clearances.service;

import org.example.clearances.repository.CustomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomsReportService {

    private final CustomsRepository customsRepository;

    public CustomsReportService(CustomsRepository customsRepository) {
        this.customsRepository = customsRepository;
    }

    public Map<String, Long> getAgentClearanceStatsForMonth(int month, int year) {
        return customsRepository.countClearancesByAgentForMonth(month, year).stream()
                .collect(Collectors.toMap(
                        row -> (String) row[0],
                        row -> (Long) row[1]
                ));
    }
}
