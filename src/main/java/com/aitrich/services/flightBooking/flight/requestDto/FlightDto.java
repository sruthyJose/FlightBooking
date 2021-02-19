package com.aitrich.services.flightBooking.flight.requestDto;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
	
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	@NotEmpty
	private String departure;
	

	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String arrival;
	

	@Future
	private LocalDateTime departureDate;
	@Future
	private LocalDateTime arrivalDate;

}
