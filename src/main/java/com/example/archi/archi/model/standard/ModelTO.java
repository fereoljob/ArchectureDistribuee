package com.example.archi.archi.model.standard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ModelTO {
	private final  String DEFAULT_FIELD = "Non Renseigné";
	private String _firstName = DEFAULT_FIELD;
    private String _lastName = DEFAULT_FIELD;
    private double _annualRevenue = -1;
    private String _phone = DEFAULT_FIELD;
    private String _street = DEFAULT_FIELD;
    private String _postalCode = DEFAULT_FIELD;
    private String _city = DEFAULT_FIELD;
    private String _country = DEFAULT_FIELD;
    private String _company = DEFAULT_FIELD;
    private String _creationDate = DEFAULT_FIELD;
    private String _state = DEFAULT_FIELD;
    
    public ModelTO() {
	
	}
    
	
	
	
	public String get_creationDate() {
		return _creationDate;
	}




	public void set_creationDate(String _creationDate) {
		this._creationDate = _creationDate;
	}




	public String get_firstName() {
		return _firstName;
	}

	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}

	public double get_annualRevenue() {
		return _annualRevenue;
	}

	public void set_annualRevenue(double _annualRevenue) {
		this._annualRevenue = _annualRevenue;
	}

	public String get_phone() {
		return _phone;
	}

	public void set_phone(String _phone) {
		this._phone = _phone;
	}

	public String get_street() {
		return _street;
	}

	public void set_street(String _street) {
		this._street = _street;
	}

	public String get_postalCode() {
		return _postalCode;
	}

	public void set_postalCode(String _postalCode) {
		this._postalCode = _postalCode;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String _city) {
		this._city = _city;
	}

	public String get_country() {
		return _country;
	}

	public void set_country(String _country) {
		this._country = _country;
	}

	public String get_company() {
		return _company;
	}

	public void set_company(String _company) {
		this._company = _company;
	}

	public String get_state() {
		return _state;
	}

	public void set_state(String _state) {
		this._state = _state;
	}

	@Override
	public String toString() {
	    return "ModelTO{" +
	            "_firstName='" + _firstName + '\'' +
	            ", _lastName='" + _lastName + '\'' +
	            ", _annualRevenue=" + _annualRevenue +
	            ", _phone='" + _phone + '\'' +
	            ", _street='" + _street + '\'' +
	            ", _postalCode='" + _postalCode + '\'' +
	            ", _city='" + _city + '\'' +
	            ", _country='" + _country + '\'' +
	            ", _company='" + _company + '\'' +
	            ", _state='" + _state + '\'' +
	             ", creationDate='" + _creationDate + '\'' +
	            '}';
	
	}
}
