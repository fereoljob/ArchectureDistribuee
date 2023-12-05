package com.example.archi.archi.service;

import java.util.List;
import java.util.Map;

import com.example.archi.archi.CRMClient.CRMClientFactory;
import com.example.archi.archi.CRMClient.Client;
import com.example.archi.archi.model.apache.VirtualLeadDTO;
import com.example.archi.archi.model.standard.ModelTO;
import com.example.archi.archi.tools.ClientType;


public class VirtualMapper {

	private static VirtualMapper _instance;
	private CRMClientFactory _clientFactory;
	
    public VirtualMapper() {
    	this._clientFactory = new CRMClientFactory();
    }

    public static VirtualMapper getInstance() {
        if (_instance == null) {
            synchronized (VirtualMapper.class) {
                if (_instance == null) {
                    _instance = new VirtualMapper();
                }
            }
        }
        return _instance;
    }
    
    public List<VirtualLeadDTO> convertFromSalesforce() throws Exception{
    		Client salesforceClient = this._clientFactory.createClient(ClientType.SALESFORCE);
    		for(ModelTO model :salesforceClient.findLeadsByDate("2023-11-14","2023-11-27")) {
    			System.out.println(model.toString());
    		}
		    
		    

		    
		
		return null;
    	
    }
  
    
    
    

    
}

