package com.bliss.appointment.appointmentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // Not strictly needed
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// @EnableDiscoveryClient // Typically auto-configured
public class AppointmentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementSystemApplication.class, args);
    }
}