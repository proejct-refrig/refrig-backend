package com.example.refrig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@OpenAPIDefinition(servers = [Server(url = "/refrig", description = "Default Server URL")])
//@EnableJpaAuditing
public class RefrigBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefrigBackendApplication.class, args);
    }

}
