package com.bliss.user.usersmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaServer
public class UsersManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersManagementSystemApplication.class, args);
    }

}
