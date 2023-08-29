package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select() /*Enganche todas las rutas que tenemos en la App para documentarlas*/
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build(); /*Se construyen todas las llamadas anteriores a funciones (Programación Funcional)*/
    }

    private SecurityContext securityContext () {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
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
