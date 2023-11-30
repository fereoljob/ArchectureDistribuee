package com.example.archi.archi.service;

import java.util.List;
import java.util.Map;

import com.example.archi.archi.CRMClient.CRMClientFactory;
import com.example.archi.archi.CRMClient.Client;
import com.example.archi.archi.model.apache.VirtualLeadDTO;
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
    		Client<Map<String, Object>> salesforceClient = 
    			this._clientFactory.createClient(ClientType.SALESFORCE);
		    Map<String, Object> usersData = salesforceClient.getAllUsers();
		    List<Map<String, Object>> records = (List<Map<String, Object>>) usersData.get("records");

		    if (records != null && !records.isEmpty()) {
		        for (Map<String, Object> user : records) {
		            String id = (String) user.get("Id");
		            String firstName = (String) user.get("FirstName");
		            String lastName = (String) user.get("LastName");
		            String email = (String) user.get("Email");
		            String phone = (String) user.get("Phone");
		            String username = (String) user.get("Username");
		            String createdDate = (String) user.get("CreatedDate");
		            String street = (String) user.get("Street");
		            String city = (String) user.get("City");
		            String state = (String) user.get("State");
		            String postalCode = (String) user.get("PostalCode");
		            String country = (String) user.get("Country");
		            String companyName = (String) user.get("CompanyName");
		            // Exclude specified fields from display
		            System.out.println("User ID : " + id);
		            System.out.println("First Name : " + firstName);
		            System.out.println("Last Name : " + lastName);
		            System.out.println("Email : " + email);
		            System.out.println("Phone : " + phone);
		            System.out.println("UserName : " + username);
		            System.out.println("CreationDate : " + createdDate);
		            System.out.println("Street : " + street);
		            System.out.println("City : " + city);
		            System.out.println("State : " + state);
		            System.out.println("PostalCode : " + postalCode);
		            System.out.println("Country : " + country);
		            System.out.println("CompanyName : " + companyName);

		            // Add other fields you want to display here

		            System.out.println("---------------------");
		        }
		    } else {
		        System.out.println("No User records found.");
		    }
		
		return null;
    	
    }
  
    
    
    

    
}

