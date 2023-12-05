package com.example.archi.archi.CRMClient;

import java.util.Date;
import java.util.List;

import com.example.archi.archi.model.standard.ModelTO;

public  interface Client {
	  	
	public List<ModelTO> getAllUsers() throws Exception;
	public List<ModelTO> findLeadsByDate(String startDate, String endDate);
	public List<ModelTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state);

}
