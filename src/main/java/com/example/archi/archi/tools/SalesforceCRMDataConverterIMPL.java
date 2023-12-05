package com.example.archi.archi.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.archi.archi.model.standard.ModelTO;

@Component
public class SalesforceCRMDataConverterIMPL implements CRMDataConverter
<Map<String, Object> >{
	
	public SalesforceCRMDataConverterIMPL() {
		
	}

	@Override
	public ModelTO convertDatas(Map<String, Object> dataType) {
		// TODO Auto-generated method stub
		
		ModelTO model = new ModelTO();
		model.set_firstName((String) dataType.get("FirstName"));
		model.set_lastName((String) dataType.get("LastName"));
		model.set_phone((String) dataType.get("Phone"));
		model.set_street((String) dataType.get("Street"));
		model.set_postalCode((String) dataType.get("PostalCode"));
		model.set_city((String) dataType.get("City"));
		model.set_country((String) dataType.get("Country"));
		model.set_company((String) dataType.get("CompanyName"));
		model.set_state((String) dataType.get("State"));
		
		return model;
	}

	

}
