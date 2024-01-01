package com.example.archi.service;

import com.example.archi.infra.tools.geoLocalisationClient.GeographicPointTO;

public interface GeoLocalisationClient {
	public GeographicPointTO extractLongAndLat(String address);
}
