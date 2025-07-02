package com.bliss.appointment.service;

import com.bliss.appointment.appointmentmanagementsystem.AppointmentManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.appointment.model.Appointment;
import com.bliss.appointment.repository.AppointmentRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AppointmentManagementSystemApplication.class)  // Especifica la clase principal
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment();
        appointment.setCustomerName("John Doe");
        appointment.setService("Haircut");
        appointment.setAppointmentTime(LocalDateTime.now());
        appointment.setStatus("Scheduled");

        Mockito.when(appointmentRepository.save(Mockito.any(Appointment.class))).thenReturn(appointment);

        Appointment createdAppointment = appointmentService.createAppointment(appointment);

        assertNotNull(createdAppointment);
        assertEquals("John Doe", createdAppointment.getCustomerName());
        assertEquals("Scheduled", createdAppointment.getStatus());
    }

    @Test
    public void testCancelAppointment() {
        Appointment appointment = new Appointment();
        appointment.setCustomerName("John Doe");
        appointment.setService("Haircut");
        appointment.setAppointmentTime(LocalDateTime.now());
        appointment.setStatus("Scheduled");

        Mockito.when(appointmentRepository.findById(1L)).thenReturn(java.util.Optional.of(appointment));

        appointmentService.cancelAppointment(1L);

        assertEquals("Cancelled", appointment.getStatus());
    }
}
