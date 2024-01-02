package com.example.archi.infra.tools.geoLocalisationClient;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.archi.service.GeoLocalisationClient;


@Component
public class OpenStreetMapClient implements GeoLocalisationClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public GeographicPointTO extractLongAndLat(String address) {
    	
        String url = "https://nominatim.openstreetmap.org/search?q="+address+"&format=json";

        url = url.replace("%25", "");
        if(!checkEmptyAddress(address)) {
        	 Map<String, Object>[] response = restTemplate.getForObject(url, Map[].class);


             if (response != null && response.length > 0 ) {
                 Map<String, Object> location = response[0];
                 double latitude = Double.parseDouble((String) location.get("lat"));
                 double longitude = Double.parseDouble((String) location.get("lon"));
                 return new GeographicPointTO(latitude, longitude);
             } 
        }
       

        return null;
    }
    
    
    private boolean checkEmptyAddress(String address) {
    	String chaine = address; 
        if (chaine.trim().isEmpty()) {
            return true;
        } 
        else {
            return false;
        }
    }
    
}
