package com.example.archi.service;

import java.util.List;

import com.example.archi.domain.ModelTO;

public  interface CRMClient {
	  	
	public List<ModelTO> getAllUsers() throws Exception;
	public List<ModelTO> findLeadsByDate(String startDate, String endDate);
	public List<ModelTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state);

}
