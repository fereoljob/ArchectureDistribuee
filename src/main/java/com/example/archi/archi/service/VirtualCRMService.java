package com.example.archi.archi.service;

import java.util.List;

import org.apache.thrift.TException;

import com.example.archi.archi.model.apache.VirtualLeadDTO;

public interface VirtualCRMService {

    List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue);

    List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException;

}