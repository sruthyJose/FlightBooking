package com.aitrich.services.flightBooking.booking.requestDto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;



@Data
public class BookingDto {
	
	@NotEmpty
	@Pattern(regexp="^PS-[0-9]*$",message = "Invalid Input")
	private String passengerId;
	
	@NotEmpty
	@Pattern(regexp="^FL-[0-9]*$",message = "Invalid Input")
	private String flightsId;

	/*
	 * public BookingModel(@NotEmpty String passengerId, @NotEmpty String flightsId)
	 * { super(); this.passengerId = passengerId; this.flightsId = flightsId; }
	 * 
	 * public BookingModel() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * public String getPassengerId() { return passengerId; }
	 * 
	 * public void setPassengerId(String passengerId) { this.passengerId =
	 * passengerId; }
	 * 
	 * public String getFlightsId() { return flightsId; }
	 * 
	 * public void setFlightsId(String flightsId) { this.flightsId = flightsId; }
	 * 
	 * @Override public String toString() { return "BookingModel [passengerId=" +
	 * passengerId + ", flightsId=" + flightsId + "]"; }
	 * 
	 * 
	 * 
	 */
	
	

}
