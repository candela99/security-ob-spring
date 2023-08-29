package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String holaMundo(){
        return "Holaaaaaa";
    }

    @GetMapping("/holauser")
    public String holaUser(){
        return "Hola admin";
    }

}
