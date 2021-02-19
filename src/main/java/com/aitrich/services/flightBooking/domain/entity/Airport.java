package com.aitrich.services.flightBooking.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Airport {
	
	@Id
	private String iataCode;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String name;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String countryIsoCode;
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(String iataCode, String name, String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	@Override
	public String toString() {
		return "Airport [iataCode=" + iataCode + ", name=" + name + ", countryIsoCode=" + countryIsoCode + "]";
	}
	
	
	
	
	
	
	


}
