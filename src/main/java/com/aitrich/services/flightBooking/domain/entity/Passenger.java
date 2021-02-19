package com.aitrich.services.flightBooking.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Passenger {
	
	@Id
	@GeneratedValue(generator = "passangerIdGenerator")
	@GenericGenerator(name = "passangerIdGenerator",parameters = @Parameter(name = "prefix",value ="PS"), strategy = "com.aitrich.services.flightBooking.domain.util.StringSequenceIdGenerator")
	private String id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "passenger", cascade = CascadeType.ALL)
	private Set<FlightBooking > flightBooking;
	
	
	@Override
	public String toString() {
		return "Passanger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", flightBooking=" + flightBooking + "]";
	}


	public Set<FlightBooking> getFlightBooking() {
		return flightBooking;
	}


	public void setFlightBooking(Set<FlightBooking> flightBooking) {
		this.flightBooking = flightBooking;
	}


	public Passenger(String id, String firstName, String lastName, String email, Set<FlightBooking> flightBooking) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.flightBooking = flightBooking;
	}
	
	public Passenger(String id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	
	

}
