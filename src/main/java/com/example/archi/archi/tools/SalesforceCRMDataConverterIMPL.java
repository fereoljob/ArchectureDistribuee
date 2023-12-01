package com.example.archi.archi.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.archi.archi.model.standard.ModelTO;

public class SalesforceCRMDataConverterIMPL implements CRMDataConverter
<List<Map<String, Object>> >{
	
	public SalesforceCRMDataConverterIMPL() {
		
	}

	@Override
	public List<ModelTO> convertDatas(List<Map<String, Object>> dataType) {
		// TODO Auto-generated method stub
		List<ModelTO> modelList= new ArrayList<ModelTO>();
		if (dataType != null && !dataType.isEmpty()) {
	        for (Map<String, Object> user : dataType) {
	        	ModelTO model = new ModelTO();
	        
	            model.set_firstName((String) user.get("FirstName"));
	            model.set_lastName((String) user.get("LastName"));
	            model.set_phone((String) user.get("Phone"));
	            model.set_street((String) user.get("Street"));
	            model.set_postalCode((String) user.get("PostalCode"));
	            model.set_city((String) user.get("City"));
	            model.set_country((String) user.get("Country"));
	            model.set_company((String) user.get("CompanyName"));
	            model.set_state((String) user.get("State"));

	            modelList.add(model);
	        }
	    } 
		return modelList;
	}

	

}
