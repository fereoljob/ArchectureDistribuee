package com.example.archi.archi.CRMClient;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.archi.archi.tools.SalesforceJSONHandler;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SalesforceConnection implements Client< Map<String, Object>> {
	

	private static final String LOGIN_URL = "services/oauth2/token";
	private static final String QUERY_URL = "services/data/v59.0/";
	private static final String DOMAIN_NAME = "https://myun1quema11idk-dev-ed.develop.my.salesforce.com/";
	private static final String GRANT_TYPE = "password";
	private SalesforceJSONHandler _config;
	private String _tokenAccess;
	
	 public SalesforceConnection() throws Exception {
		 this._config = SalesforceJSONHandler.loadConfig("jsonFiles/SalesforceUser.json");
		 this._tokenAccess = null;
		 this.login();
	 }
	 
	 public Map<String, Object> login() throws Exception {
		 URL url = new URL(DOMAIN_NAME+LOGIN_URL);
		 System.out.println(url);
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setDoOutput(true);
		 conn.setRequestMethod("POST");
		 conn.setRequestProperty("Accept", "application/json");
		 conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		 String data = "grant_type="+ GRANT_TYPE
                 + "&client_id="+this._config.getCLIENT_ID()
                 + "&client_secret="+this._config.getCLIENT_SECRET()
                 + "&username="+this._config.getUSERNAME()
                 + "&password="+this._config.getPASSWORD();

		 System.out.println(data);
	     try (OutputStream os = conn.getOutputStream()) {
	         byte[] input = data.getBytes(StandardCharsets.UTF_8);
	         os.write(input, 0, input.length);           
	     }

	        int responseCode = conn.getResponseCode();

	        if (responseCode != HttpURLConnection.HTTP_OK) {

	        	System.out.println("Error Response: "+ getResponse(conn, responseCode));
	            conn.disconnect();
	            
	            this._tokenAccess = null;
	            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        StringBuilder response = new StringBuilder();
	        String output;
	        while ((output = br.readLine()) != null) {
	            response.append(output);
	        }
	        conn.disconnect();

	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> responseMap = mapper.readValue(response.toString(), HashMap.class);
	        
	        
	        if(this._tokenAccess == null || this._tokenAccess.equals("")) {
	        	this._tokenAccess =(String) responseMap.get("access_token");

	        }
	        return responseMap;
	    }
	 
	 @Override
	 public Map<String, Object> getAllUsers() throws Exception {
	        if (this._tokenAccess == null || this._tokenAccess.isEmpty()) {
	            throw new IllegalStateException("Salesforce connection hasn't been set");
	        }
	        String query = "SELECT+Id,FirstName,LastName,Email,Phone,Username,CreatedDate,Street,City,State,PostalCode,Country,CompanyName+FROM+User";



	        URL url = new URL(DOMAIN_NAME + QUERY_URL+ "query?q=" + query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Bearer " + this._tokenAccess);
	        conn.setRequestProperty("Accept", "application/json");

	        int responseCode = conn.getResponseCode();
	        System.out.println(url);
	        if (responseCode != HttpURLConnection.HTTP_OK) {
	        	System.out.println("Error code : "+responseCode );
	        	System.out.println("Error Response: "+ getResponse(conn, responseCode));
	            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String output;
	        while ((output = br.readLine()) != null) {
	            response.append(output);
	        }
	        
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> responseMap = mapper.readValue(response.toString(), HashMap.class);
	        conn.disconnect();
	        	
	        return responseMap;
	    }
	 
	 
	 public String getResponse(HttpURLConnection conn, int responseCode) throws IOException {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         StringBuilder response = new StringBuilder();
         String errorOutput;
         while ((errorOutput = reader.readLine()) != null) {
             response.append(errorOutput);
         }
         return response.toString();
	 }
	 
	


	

	 
}
