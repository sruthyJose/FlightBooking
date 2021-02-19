package com.aitrich.services.flightBooking.domain.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity


public class Flight {
	
	@Id
	@GenericGenerator(name = "flight_id_generator",
					parameters = @Parameter(name="prefix", value = "FL"),
					strategy = "com.aitrich.services.flightBooking.domain.util.StringSequenceIdGenerator")
	@GeneratedValue(generator = "flight_id_generator")
	private String id;
	
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String departure;
	
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String arrival;
	@Future
	private LocalDateTime departureDate;
	
	@Future
	private LocalDateTime arrivalDate;
	
	@ManyToMany(mappedBy = "flights", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Set<FlightBooking> bookings;
	
	public Flight() {
		super();
		
	}

	public Flight( String departure, String arrival, LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}
	public Flight(String id, String departure, String arrival, LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Set<FlightBooking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<FlightBooking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", bookings=" + bookings + "]";
	}

	
	
	
	
	
	

}
