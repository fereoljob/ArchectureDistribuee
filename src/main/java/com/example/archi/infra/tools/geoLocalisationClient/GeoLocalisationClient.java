package com.example.archi.infra.tools.geoLocalisationClient;

public interface GeoLocalisationClient {
	public GeographicPointTO extractLongAndLat(String address);
}
