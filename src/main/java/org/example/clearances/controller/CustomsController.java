package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.model.Customs;
import org.example.clearances.model.CustomsStatus;
import org.example.clearances.service.CustomsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customs")
public class CustomsController {

    private final CustomsService customsService;

    public CustomsController(CustomsService customsService) {
        this.customsService = customsService;
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @PostMapping("/save")
    public String saveCustoms(@ModelAttribute CustomsRequest request) {
        customsService.addCustoms(request);
        return "redirect:/home";
    }

    @GetMapping("/data")
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseEntity<List<Customs>> getAllCustoms() {
        List<Customs> customsList = customsService.getAllCustoms();
        return customsList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(customsList);
    }

    @PutMapping("/{id}/status")
    @ResponseBody
    public ResponseEntity<Customs> updateCustomsStatus(@PathVariable Long id, @RequestParam CustomsStatus status) {
        Customs updated = customsService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}
