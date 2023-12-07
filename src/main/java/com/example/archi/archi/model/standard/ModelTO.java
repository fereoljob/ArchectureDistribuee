package com.example.archi.archi.model.standard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModelTO {
	private String firstName;
    private String lastName;
    private double annualRevenue;
    private String phone;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private String company;
    private String creationDate;
    private String state;
    

	@Override
	public String toString() {
	    return "ModelTO{" +
	            "_firstName='" + firstName + '\'' +
	            ", _lastName='" + lastName + '\'' +
	            ", _annualRevenue=" + annualRevenue +
	            ", _phone='" + phone + '\'' +
	            ", _street='" + street + '\'' +
	            ", _postalCode='" + postalCode + '\'' +
	            ", _city='" + city + '\'' +
	            ", _country='" + country + '\'' +
	            ", _company='" + company + '\'' +
	            ", _state='" + state + '\'' +
	             ", creationDate='" + creationDate + '\'' +
	            '}';
	
	}
}
