package com.bliss.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bliss.service.model.BeautyService;
import com.bliss.service.service.ServiceService;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/create")
    public BeautyService createService(@RequestBody BeautyService beautyService) {
        return serviceService.createService(beautyService);
    }

    @GetMapping("/{id}")
    public BeautyService getService(@PathVariable Long id) {
        return serviceService.getService(id);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
