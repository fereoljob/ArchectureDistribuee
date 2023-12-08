package com.example.archi.archi.geoLocalisationClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.archi.archi.model.GeographicPointTO;


@Component
public class OpenStreetMapClient implements GeoLocalisationClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public GeographicPointTO extractLongAndLat(String address) {
    	
        String url = "https://nominatim.openstreetmap.org/search?q="+address+"&format=json";

        System.out.println(address);

        url = url.replace("%25", "");

        System.out.println(url);
        Map<String, Object>[] response = restTemplate.getForObject(url, Map[].class);


        if (response != null && response.length > 0) {
            Map<String, Object> location = response[0];
            double latitude = Double.parseDouble((String) location.get("lat"));
            double longitude = Double.parseDouble((String) location.get("lon"));
            return new GeographicPointTO(latitude, longitude);
        } 

        return null;
    }
}
