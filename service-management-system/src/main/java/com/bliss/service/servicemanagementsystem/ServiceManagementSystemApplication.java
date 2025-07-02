package com.bliss.service.servicemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaServer
public class ServiceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceManagementSystemApplication.class, args);
    }

}
