package com.example.archi.archi.geoLocalisationClient;

import com.example.archi.archi.model.GeographicPointTO;


public interface GeoLocalisationClient {
	public GeographicPointTO extractLongAndLat(String address);
}
