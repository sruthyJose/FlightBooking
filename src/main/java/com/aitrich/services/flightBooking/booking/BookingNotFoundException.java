package com.aitrich.services.flightBooking.booking;

import com.aitrich.services.flightBooking.ExpectionHandler.ResourceNotFoundException;

public class BookingNotFoundException extends ResourceNotFoundException{


	private static final long serialVersionUID = 325555555551L;

	public BookingNotFoundException(String id) {
		super("Booking", "Booking-id", id);
		
	}

}
