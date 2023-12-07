package com.example.archi.archi.CRMClient;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.archi.archi.model.ModelTO;

public  interface Client {
	  	
	public List<ModelTO> getAllUsers() throws Exception;
	public List<ModelTO> findLeadsByDate(String startDate, String endDate);
	public List<ModelTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state);

}
