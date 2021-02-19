package com.aitrich.services.flightBooking.booking.requestDto.converter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBooking.booking.requestDto.BookingDto;
import com.aitrich.services.flightBooking.domain.entity.FlightBooking;

@Component
public class CreateRequestToBookingEntityConverter implements Converter<BookingDto, FlightBooking>{

	@Override
	public FlightBooking convert(BookingDto source) {
		
		/*
		 * FlightBooking flight = new FlightBooking();
		 * flight.setPassenger(source.getPassenger());
		 * flight.setFlights(source.getFlights());
		 */
		
		return null;
	}
	

}
