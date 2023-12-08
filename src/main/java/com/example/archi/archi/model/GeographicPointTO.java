package com.example.archi.archi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeographicPointTO {
	
	private double latitude;
	private double longitude;

	
	@Override
	public String toString() {
	    return "GeographicPoint{ Latitude : " + latitude+ " | Longitude : " + longitude + "}";

	}
}

	
