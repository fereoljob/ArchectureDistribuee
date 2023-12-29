package com.example.archi.infra.tools.Converter;

import java.time.LocalDateTime;
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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		
		ModelTO model = new ModelTO((String) dataType.get("FirstName"), (String) dataType.get("LastName"),
		(dataType.get("revenue__c")==null)?0:(double)dataType.get("revenue__c"),
		 (String) dataType.get("Phone"), (String) dataType.get("Street"), (String) dataType.get("PostalCode"),
		  (String) dataType.get("City"), (String) dataType.get("Country"), (String) dataType.get("CompanyName"),
		   LocalDateTime.parse((String)dataType.get("CreatedDate"),formatter), (String) dataType.get("State"));
		
		return model;
	}

	

}
