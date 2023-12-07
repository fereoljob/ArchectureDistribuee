package com.example.archi.archi.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.archi.archi.model.standard.ModelTO;

@Component("salesforceConverter")
public class SalesforceCRMDataConverterIMPL implements CRMDataConverter
<Map<String, Object> >{
	
	public SalesforceCRMDataConverterIMPL() {
		
	}

	@Override
	public ModelTO convertDatas(Map<String, Object> dataType) {
		ModelTO model = new ModelTO((String) dataType.get("FirstName"), (String) dataType.get("LastName"),
		 (double)dataType.get(""), (String) dataType.get("Phone"), (String) dataType.get("Street"), (String) dataType.get("PostalCode"),
		  (String) dataType.get("City"), (String) dataType.get("Country"), (String) dataType.get("CompanyName"),
		   (String)dataType.get("CreatedDate"), (String) dataType.get("State"));
		
		return model;
	}

	

}
