package org.example.clearances.controller;

import org.example.clearances.service.CustomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CustomsService customsService;

    public HomeController(CustomsService customsService) {
        this.customsService = customsService;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("customsList", customsService.getAllCustoms());
        return "home";
    }
}
