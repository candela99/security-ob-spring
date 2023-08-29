package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Acá vamos a crear un Bean (SwaggerConfig) para que SpringBoot sea capaz de
 * detectarlo e inicialiar Swagger.
 * Usamos Swagger para documentar la API REST, de forma dinamica:
 * si se produce un cambio en la API, estos cambios se verán reflejados en la documentación
 * http://localhost:8080/swagger-ui/
 * */
@Configuration
public class SwaggerConfig {
    /*
     * Docket está pensado para ser la interfaz principal
     * */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails()) /*Versión de la API, empresa, etc.*/
                .select() /*Enganche todas las rutas que tenemos en la App para documentarlas*/
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build(); /*Se construyen todas las llamadas anteriores a funciones (Programación Funcional)*/
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot API REST",
                "API REST docs",
                "1.0",
                "http://www.google.com",
                new Contact("Candela", "http://www.google.com", "candela@example.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}
