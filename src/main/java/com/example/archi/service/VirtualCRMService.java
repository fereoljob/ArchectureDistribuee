package com.example.archi.service;

import java.util.List;

import org.apache.thrift.TException;

public interface VirtualCRMService {

    List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue,String state);

    List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException;

}