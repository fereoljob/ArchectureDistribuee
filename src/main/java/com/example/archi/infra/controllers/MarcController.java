package com.example.archi.infra.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.archi.service.VirtualCRMService;
import com.example.archi.service.VirtualLeadDTO;


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
        return "Virtual Servers are Ready";
    }
    
    public String sendCommand(@RequestBody String command) {
        if ("Hello Rest!".equals(command)) {
            return "Hello CMD!";
        } else {
            return "Invalid command";
        }
    }
    
    @PostMapping(value = "/commandGate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<VirtualLeadDTO> processData(@RequestBody Map<String, Object> dataMap) {
    	
    	String commandName = (String) dataMap.get("name");
    	switch(commandName) {
    		case "findLeads":
    			 return vcrm.findLeads((double) dataMap.get("lowAnnualRevenue"),
    					(double) dataMap.get("highAnnualRevenue"),
    					(String) dataMap.get("state")) ;
    		case "findLeadsByDate":
    			return vcrm.findLeadsByDate((String) dataMap.get("startDate"),
    					(String) dataMap.get("endDate"));
    		default:
    			break;
    	}
    	return null;
    
        
    }
}