package org.example.clearances.controller;

import org.example.clearances.dto.CustomsRequest;
import org.example.clearances.service.CustomsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customs")
public class CustomsController {

    private final CustomsService svc;

    public CustomsController(CustomsService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<CustomsRequest> getAll() {
        return svc.getAllCustoms();
    }

    @PostMapping
    public CustomsRequest create(@RequestBody CustomsRequest req) {
        return svc.addCustoms(req);
    }

    @PatchMapping("/{id}/status")
    public CustomsRequest updateStatus(
            @PathVariable Integer id,
            @RequestParam String status
    ) {
        return svc.updateStatus(id, status);
    }

    @PutMapping("/{id}")
    public CustomsRequest update(
            @PathVariable Integer id,
            @RequestBody CustomsRequest req
    ) {
        return svc.updateCustomsDetails(id, req);
    }
}
