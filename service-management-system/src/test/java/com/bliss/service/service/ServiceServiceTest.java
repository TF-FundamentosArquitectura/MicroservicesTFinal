package com.bliss.service.service;

import com.bliss.service.servicemanagementsystem.ServiceManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.service.model.BeautyService;
import com.bliss.service.repository.ServiceRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServiceManagementSystemApplication.class)  // Agrega la clase principal aquí
public class ServiceServiceTest {

    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private ServiceService serviceService;

    @Test
    public void testCreateService() {
        // Arrange
        BeautyService beautyService = new BeautyService();
        beautyService.setName("Haircut");
        beautyService.setDescription("A basic haircut");
        beautyService.setPrice(20.0);

        // Mock the repository to return the service when save() is called
        Mockito.when(serviceRepository.save(Mockito.any(BeautyService.class))).thenReturn(beautyService);

        // Act
        BeautyService createdService = serviceService.createService(beautyService);

        // Assert
        assertNotNull(createdService);
        assertEquals("Haircut", createdService.getName());
        assertEquals(20.0, createdService.getPrice());
    }
}
