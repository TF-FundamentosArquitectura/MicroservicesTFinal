package com.bliss.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bliss.service.repository.ServiceRepository;
import com.bliss.service.model.BeautyService;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public BeautyService createService(BeautyService beautyService) {
        return serviceRepository.save(beautyService);
    }

    public BeautyService getService(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
