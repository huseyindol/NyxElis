package com.nyxelis.starter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.nyxelis"})
@EntityScan(basePackages = {"com.nyxelis"})
@ComponentScan(basePackages = {"com.nyxelis"})
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title = "Nyxelis CMS API", version = "1.0", description = "API documentation for " +
        "Nyxelis CMS"))
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

}
