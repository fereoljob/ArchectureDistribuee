package com.example.archi.service;

import com.example.archi.domain.ModelTO;
import com.example.archi.infra.tools.geoLocalisationClient.GeographicPointTO;


public class VirtualMapper {

	
    
    public static VirtualLeadDTO  fromModelToVirtual(ModelTO model) {
    		
		    VirtualLeadDTO vLdto = new VirtualLeadDTO(model.getFirstName(), model.getLastName(), model.getAnnualRevenue(),
             model.getPhone(), model.getStreet(), model.getPostalCode(),model.getCity(), model.getCountry(),
              model.getCompany(), model.getCreationDate(), model.getState(),null);
		return vLdto;
    	
    }
  
   
	
}
    

