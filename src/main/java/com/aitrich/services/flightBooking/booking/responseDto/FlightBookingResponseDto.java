package com.aitrich.services.flightBooking.booking.responseDto;

import java.util.List;

import com.aitrich.services.flightBooking.flight.requestDto.FlightDto;
import com.aitrich.services.flightBooking.passenger.requestDto.PassengerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingResponseDto {
	
	private String id;
	private PassengerDto passenger;
	private List<FlightDto> flights;
	/*
	 * public FlightBookingResponseDto() { super(); // TODO Auto-generated
	 * constructor stub } public FlightBookingResponseDto(String id, PassengerModel
	 * passenger, List<FlightModel> flights) { super(); this.id = id; this.passenger
	 * = passenger; this.flights = flights; } public String getId() { return id; }
	 * public void setId(String id) { this.id = id; } public PassengerModel
	 * getPassenger() { return passenger; } public void setPassenger(PassengerModel
	 * passenger) { this.passenger = passenger; } public List<FlightModel>
	 * getFlights() { return flights; } public void setFlights(List<FlightModel>
	 * flights) { this.flights = flights; }
	 * 
	 * @Override public String toString() { return "FlightBookingModel [id=" + id +
	 * ", passenger=" + passenger + ", flights=" + flights + "]"; }
	 * 
	 * 
	 */

}
