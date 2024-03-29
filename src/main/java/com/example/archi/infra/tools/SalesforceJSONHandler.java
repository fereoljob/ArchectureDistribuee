package com.example.archi.infra.tools;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
@ConfigurationProperties(prefix = "salesforceuser")
@Getter
@Setter
public class SalesforceJSONHandler {
	
	 	private String CLIENT_ID;
	    private String CLIENT_SECRET;
	    private String SECURITY;
	    private String USERNAME;
	    private String PASSWORD;

	    /*public static SalesforceJSONHandler loadConfig(String filePath) throws IOException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode = objectMapper.readTree(new File(filePath));
	        ObjectNode configNode = (ObjectNode) rootNode;

	        SalesforceJSONHandler config = new SalesforceJSONHandler();
	        config.CLIENT_ID = configNode.get("CLIENT_ID").asText();
	        config.CLIENT_SECRET = configNode.get("CLIENT_SECRET").asText();
	        config.SECURITY_TOKEN = configNode.get("SECURITY").asText();
	        config.USERNAME = configNode.get("USERNAME").asText();
	        config.PASSWORD = configNode.get("PASSWORD").asText();


	        return config;
	    }

	    public String getCLIENT_ID() {
	        return CLIENT_ID;
	    }

	    public String getCLIENT_SECRET() {
	        return CLIENT_SECRET;
	    }

	    public String getUSERNAME() {
	        return USERNAME;
	    }

	    public String getPASSWORD() {
	        return PASSWORD;
	    }

	    public String getSECURITY_TOKEN() {
	        return SECURITY_TOKEN;
	    }*/

	  

}
