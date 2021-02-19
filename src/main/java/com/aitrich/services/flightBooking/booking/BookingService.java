package com.aitrich.services.flightBooking.booking;

import java.util.List;

import com.aitrich.services.flightBooking.booking.requestDto.BookingDto;
import com.aitrich.services.flightBooking.booking.requestDto.FlightBookingSummaryModel;
import com.aitrich.services.flightBooking.domain.entity.FlightBooking;

public interface BookingService {
	
	Boolean insert(FlightBooking booking);
	FlightBooking getById(String id);
	List<FlightBooking> findAll();
	void delete(String id);
	FlightBooking checkPassengerAndFlightExist(BookingDto booking);
	

}
