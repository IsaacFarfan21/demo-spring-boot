package com.utec.demo.spring_boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saludo")
public class SaludoController {
    @GetMapping
    public String saludo(){

        return "hola desde spring boot!!!! ";
    }

}
