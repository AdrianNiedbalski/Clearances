package org.example.clearances.controller;

import org.example.clearances.repository.CustomsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class DashboardController {

    private final CustomsRepository customsRepository;

    public DashboardController(CustomsRepository customsRepository) {
        this.customsRepository = customsRepository;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Object[]> result = customsRepository.countClearancesPerMonth();

        List<String> labels = new ArrayList<>();
        List<Long> data = new ArrayList<>();

        for (Object[] row : result) {
            labels.add(row[0].toString());
            data.add((Long) row[1]);
        }

        model.addAttribute("labels", labels);
        model.addAttribute("data", data);

        return "dashboard";
    }
}
