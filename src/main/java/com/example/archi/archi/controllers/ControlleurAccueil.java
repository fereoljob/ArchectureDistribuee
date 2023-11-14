package com.example.archi.archi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControlleurAccueil {
    @GetMapping("/accueil")
    public String Accueil(){
        return "welcome";
    }
}
