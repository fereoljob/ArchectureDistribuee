package com.example.archi.archi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlleurAccueil {
    @RequestMapping("/")
    public String Accueil(){
        return "Accueil";
    }
}
