package com.aitrich.services.flightBooking.passenger.requestDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;




@Data
@AllArgsConstructor
public class PassengerDto {
	
	public PassengerDto() {
		// TODO Auto-generated constructor stub
	}
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String firstName;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String lastName;
	@Email
	@NotEmpty
	private String email;
	/*
	 * public PassengerModel() { super(); // TODO Auto-generated constructor stub }
	 * public PassengerModel(String firstName, String lastName, String email) {
	 * super(); this.firstName = firstName; this.lastName = lastName; this.email =
	 * email; } public String getFirstName() { return firstName; } public void
	 * setFirstName(String firstName) { this.firstName = firstName; } public String
	 * getLastName() { return lastName; } public void setLastName(String lastName) {
	 * this.lastName = lastName; } public String getEmail() { return email; } public
	 * void setEmail(String email) { this.email = email; }
	 * 
	 * @Override public String toString() { return "PassengerModel [firstName=" +
	 * firstName + ", lastName=" + lastName + ", email=" + email + "]"; }
	 */
	

}
