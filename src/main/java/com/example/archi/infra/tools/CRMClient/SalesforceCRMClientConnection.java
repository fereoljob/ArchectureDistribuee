 
package com.example.archi.infra.tools.CRMClient;


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.archi.domain.ModelTO;
import com.example.archi.infra.tools.SalesforceJSONHandler;
import com.example.archi.infra.tools.converter.CRMDataConverter;
import com.example.archi.service.CRMClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SalesforceCRMClientConnection implements CRMClient {
	

	private static final String LOGIN_URL = "services/oauth2/token";
	private static final String QUERY_URL = "services/data/v59.0/";
	private static final String DOMAIN_NAME = "https://myun1quema11idk-dev-ed.develop.my.salesforce.com/";
	private static final String GRANT_TYPE = "password";
	private SalesforceJSONHandler config;
	private String tokenAccess;


    private final HttpClient httpClient = HttpClient.newHttpClient();
    private static boolean CONNECTION_ATTEMPTED = false;
	private CRMDataConverter<Map<String, Object>> converter;
	
	 public SalesforceCRMClientConnection(SalesforceJSONHandler config,@Qualifier("salesforceConverter") CRMDataConverter<Map<String,Object>> converter) throws Exception {
		 this.tokenAccess = null;
		 this.converter = converter;
		 this.config = config;
		 this.login();
	 }
	 

	    public Map<String, Object> login() throws Exception {
	        String data = "grant_type=" + GRANT_TYPE
	                + "&client_id=" + this.config.getCLIENT_ID()
	                + "&client_secret=" + this.config.getCLIENT_SECRET()
	                + "&username=" + this.config.getUSERNAME()
	                + "&password=" + this.config.getPASSWORD();
	        
	        
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(DOMAIN_NAME + LOGIN_URL))
	                .POST(HttpRequest.BodyPublishers.ofString(data))
	                .header("Accept", "application/json")
	                .header("Content-Type", "application/x-www-form-urlencoded")
	                .build();
	        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
	        if (response.statusCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
	        }

	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> responseMap = mapper.readValue(response.body(), HashMap.class);
	        
	        this.tokenAccess = (String) responseMap.get("access_token");

	       
	        return responseMap;
	    }

	 
	 
	 
	 @Override
	 public List<ModelTO> getAllUsers() {
	      
	        String query = "SELECT+FirstName,LastName,Email,Phone,CreatedDate,Street,City,State,PostalCode,Country,Company,AnnualRevenue+FROM+Lead";
	        Map<String, Object> responseMap = executeQuery(query);

	        List<Map<String, Object>> records = (List<Map<String, Object>>) responseMap.get("records");
	        List<ModelTO> result = new ArrayList<ModelTO>();    
	        if (records != null && !records.isEmpty()) {
		        for (Map<String, Object> user : records) {
		        	result.add(converter.convertDatas(user));
		        }
		    } 
	        	
	        return result;
	    }
	 

		@Override
		public List<ModelTO> findLeadsByDate(String startDate, String endDate)  {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		    // Format the startDate and endDate for Salesforce query
		    String startDateStr = "";
		    String endDateStr ="" ;
			try {
				startDateStr = dateFormat.format(dateFormat.parse(startDate + "T00:00:00Z"));
			
				endDateStr = dateFormat.format(dateFormat.parse(endDate + "T23:59:59Z"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String query = "SELECT FirstName,LastName,Email,Phone,CreatedDate,Street,City,State,PostalCode,Country,Company,AnnualRevenue " +
		                   "FROM Lead " +
		                   "WHERE (CreatedDate >= " + startDateStr + " AND CreatedDate <= " + endDateStr+")";
		    try {
				 query = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     Map<String, Object> responseMap = executeQuery(query);


		     List<Map<String, Object>> records = (List<Map<String, Object>>) responseMap.get("records");
		     List<ModelTO> result = new ArrayList<ModelTO>();    
		     if (records != null && !records.isEmpty()) {
		         for (Map<String, Object> user : records) {
		             result.add(converter.convertDatas(user));
		         }
		     }

		     return result;
		}

		@Override
		public List<ModelTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
			// TODO Auto-generated method stub
			
			String formattedLowRevenue = String.format("%.2f", lowAnnualRevenue);
			formattedLowRevenue = formattedLowRevenue.replace(",", ".");

			String formattedHighRevenue = String.format("%.2f", highAnnualRevenue);
			formattedHighRevenue = formattedHighRevenue.replace(",", ".");
		    String query = "SELECT FirstName,LastName,Email,Phone,CreatedDate,Street,City,State,PostalCode,Country,Company,AnnualRevenue " +
		                   "FROM Lead " +
		                   "WHERE (AnnualRevenue >= " + formattedLowRevenue + " AND AnnualRevenue <= " + formattedHighRevenue+")";
		   if(!state.equals("") && !state.equals(null)) {
			   query += " AND State = '"+state+"'";
		   }
		   try {
				 query = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Map<String, Object> responseMap = executeQuery(query);


		     List<Map<String, Object>> records = (List<Map<String, Object>>) responseMap.get("records");
		     List<ModelTO> result = new ArrayList<ModelTO>();
		     if (records != null && !records.isEmpty()) {
		         for (Map<String, Object> user : records) {
		             result.add(converter.convertDatas(user));
		         }
		     }

		     return result;
		}
		 
	 

		public Map<String, Object> executeQuery(String query) {
		
			if (this.tokenAccess == null || this.tokenAccess.isEmpty()) {
				try {
					login();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	
			HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(DOMAIN_NAME + QUERY_URL + "query?q=" + query))
		                .GET()
		                .header("Authorization", "Bearer " + this.tokenAccess)
		                .header("Accept", "application/json")
		                .build();
	
			HttpResponse<String> response = null;
			try {
				response = httpClient.send(request, BodyHandlers.ofString());
				if (response.statusCode() == 401) {  
		            System.out.println("Token expiré");
					login();
					if(!CONNECTION_ATTEMPTED) {
						CONNECTION_ATTEMPTED = true;
						executeQuery( query);
					}

		        } else if (response.statusCode() != 200) {
		            throw new RuntimeException("Échec de la requête : HTTP error code : " + response.statusCode());
		        }
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			CONNECTION_ATTEMPTED = false;
			ObjectMapper mapper = new ObjectMapper();
			try {

				return mapper.readValue(response.body(), HashMap.class);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		
			return null;
	        
		 
		}
		
	

	 
}
