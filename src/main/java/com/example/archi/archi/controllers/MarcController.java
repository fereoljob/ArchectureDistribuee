package com.example.archi.archi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.archi.archi.service.VirtualCRMService;
import com.example.archi.archi.service.VirtualCRMServiceIMPL;


@RestController
@RequestMapping("/myTest")
public class MarcController {

    @GetMapping
    public String accueil() throws Exception {
        System.out.println("Begin");
        VirtualCRMService VCRM = new VirtualCRMServiceIMPL();
        VCRM.findLeads(0, 0);
        System.out.println("End");
        return "welcome";
    }
}