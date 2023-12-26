package com.example.archi.infra.tools.Converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.archi.domain.ModelTO;

@Component("salesforceConverter")
public class SalesforceCRMDataConverterIMPL implements CRMDataConverter
<Map<String, Object> >{
	
	public SalesforceCRMDataConverterIMPL() {
		
	}

	@Override
	public ModelTO convertDatas(Map<String, Object> dataType) {
		
		String strDate = (String)dataType.get("CreatedDate");
	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(strDate, formatter);
        
        double revenue = -1;
        if(dataType.get("revenue__c")!=null) {
        	revenue = (double)dataType.get("revenue__c");
        }
		
		ModelTO model = new ModelTO((String) dataType.get("FirstName"), (String) dataType.get("LastName"),
		revenue, (String) dataType.get("Phone"), (String) dataType.get("Street"), (String) dataType.get("PostalCode"),
		  (String) dataType.get("City"), (String) dataType.get("Country"), (String) dataType.get("CompanyName"),
		   (String)dataType.get("CreatedDate"), (String) dataType.get("State"));
		
		return model;
	}

	

}
