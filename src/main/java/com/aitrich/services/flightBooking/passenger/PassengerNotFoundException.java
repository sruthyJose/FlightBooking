package com.aitrich.services.flightBooking.passenger;

import com.aitrich.services.flightBooking.ExpectionHandler.ResourceNotFoundException;

public class PassengerNotFoundException  extends ResourceNotFoundException{

	
	private static final long serialVersionUID = 7879879797341L;

	public PassengerNotFoundException(String passengerId) {
		super("Passenger", "passenger-id", passengerId);
		
	}

}
