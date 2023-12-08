package com.example.archi.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.archi.service.VirtualCRMService;


@RestController
@RequestMapping("/myTest")
public class MarcController {
    @Autowired
    private VirtualCRMService vcrm;
    @GetMapping
    public String accueil() throws Exception {
        System.out.println("Begin");
        vcrm.findLeads(0, 2000,"alabasta").forEach(elem -> {System.out.println(elem);} );
        System.out.println("End");
        return "welcome";
    }
}