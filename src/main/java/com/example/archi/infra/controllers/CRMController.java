package com.example.archi.infra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.archi.service.VirtualCRMService;
import com.example.archi.service.VirtualLeadDTO;


@RestController
@RequestMapping("/virtualcrm")
public class CRMController {
    @Autowired
    private VirtualCRMService vcrm;
    @GetMapping(value="/findLeads")
    public List<VirtualLeadDTO> findLeads(@RequestParam double lowAnnualRevenue,@RequestParam double highAnnualRevenue,@RequestParam String state){
        return vcrm.findLeads(lowAnnualRevenue, highAnnualRevenue, state);
    }
    @GetMapping(value="/findLeadsByDate")
    public List<VirtualLeadDTO> findLeadByDate(@RequestParam String startDate,@RequestParam String endDate){
        return vcrm.findLeadsByDate(startDate, endDate);
    }
       
}