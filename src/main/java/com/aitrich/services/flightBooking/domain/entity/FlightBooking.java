package com.aitrich.services.flightBooking.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity
public class FlightBooking {
	

	@Id
	@GeneratedValue(generator = "booking-id-gen")
	@GenericGenerator(name = "booking-id-gen", parameters = @Parameter(name = "prefix", value = "FB"), strategy = "com.aitrich.services.flightBooking.domain.util.StringSequenceIdGenerator")
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Passenger passenger;
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable(name = "booking_flights", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private Set<Flight> flights;


	public FlightBooking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FlightBooking(String id, Passenger passenger, Set<Flight> flights) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.flights = flights;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public Set<Flight> getFlights() {
		return flights;
	}


	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}


	@Override
	public String toString() {
		return "FlightBooking [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}
	
	
	
	
}
