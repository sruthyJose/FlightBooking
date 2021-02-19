package com.aitrich.services.flightBooking.flight;

import com.aitrich.services.flightBooking.ExpectionHandler.ResourceNotFoundException;

public class FlightNotFoundException extends ResourceNotFoundException{

	
	private static final long serialVersionUID = 34356767871L;

	public FlightNotFoundException(String id) {
		super("Flight","flight-id",id);
		
	}

}
