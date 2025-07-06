package com.bliss.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // Not strictly needed with auto-configuration

@EnableAdminServer
@SpringBootApplication
// @EnableDiscoveryClient // This is generally auto-configured if Eureka client JAR is present
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

}
