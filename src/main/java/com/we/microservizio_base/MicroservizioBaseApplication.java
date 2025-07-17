package com.we.microservizio_base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class MicroservizioBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservizioBaseApplication.class, args);
    }

}
