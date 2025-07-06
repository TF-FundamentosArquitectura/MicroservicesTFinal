package com.bliss.service.servicemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// @EnableDiscoveryClient // Typically auto-configured
public class ServiceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceManagementSystemApplication.class, args);
    }

}
