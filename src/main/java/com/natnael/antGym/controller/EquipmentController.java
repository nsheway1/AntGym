package com.natnael.antGym.controller;

import com.natnael.antGym.model.Equipment;
import com.natnael.antGym.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// exposes API endpoints: specifying the URLs

@RestController
public class EquipmentController {
    private final EquipmentService service;

    @Autowired
    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping("/equipment")
    public List<Equipment> getAllEquipments() {
        return service.getAllEquipments();
    }

    @GetMapping("/equipment/{id}")
    public Optional<Equipment> getEquipmentById(@PathVariable Long id) {
        return service.getEquipmentById(id);
    }

    @PostMapping("/equipment")
    public Equipment saveEquipment(@RequestBody Equipment item) {
        return service.addEquipment(item);
    }
}
