package com.example.archi.infra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.archi.infra.tools.CRMClient.SalesforceConnection;


@Controller
public class ControlleurAccueil {
    @GetMapping("/accueil")
    public String Accueil() throws Exception{
    	SalesforceConnection SC = new SalesforceConnection();
    	SC.login();
    	//SalesforceJSONHandler sjh = SalesforceJSONHandler.loadConfig("jsonFiles/SalesforceUser.json");
    	System.out.println("End");
        return "welcome";
        
    }
}