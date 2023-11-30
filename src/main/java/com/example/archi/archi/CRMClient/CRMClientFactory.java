package com.example.archi.archi.CRMClient;

import java.util.Map;

import com.example.archi.archi.tools.ClientType;

public class CRMClientFactory {
	
	public Client createClient(ClientType type) throws Exception {
			switch(type) {
				case INTERNAL:
					return null; 
				case SALESFORCE:
					return new SalesforceConnection();
				default:
					break;
						
			}
			return null;
	}

}
