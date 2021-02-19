package com.aitrich.services.flightBooking.flight.requestDto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBooking.domain.entity.Flight;
import com.aitrich.services.flightBooking.flight.requestDto.FlightDto;
@Component
public class CreateRequestToFlightEntityConverter implements Converter<FlightDto, Flight>{

	@Override
	public Flight convert(FlightDto source) {
		
		
		Flight flight = new Flight();
		flight.setArrival(source.getArrival());
		flight.setArrivalDate(source.getArrivalDate());
		flight.setDeparture(source.getDeparture());
		flight.setDepartureDate(source.getDepartureDate());
		return flight;
	}

}
