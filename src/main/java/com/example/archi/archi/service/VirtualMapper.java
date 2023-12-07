package com.example.archi.archi.service;

import com.example.archi.archi.model.ModelTO;
import com.example.archi.archi.model.VirtualLeadDTO;


public class VirtualMapper {

	
    
    public static VirtualLeadDTO  fromModelToVirtual(ModelTO model) {
    		
		    VirtualLeadDTO vLdto = new VirtualLeadDTO(model.getFirstName(), model.getLastName(), model.getAnnualRevenue(),
             model.getPhone(), model.getStreet(), model.getPostalCode(),model.getCity(), model.getCountry(),
              model.getCompany(), model.getCreationDate(), model.getState());
		return vLdto;
    	
    }
  
    
    
    

    
}

