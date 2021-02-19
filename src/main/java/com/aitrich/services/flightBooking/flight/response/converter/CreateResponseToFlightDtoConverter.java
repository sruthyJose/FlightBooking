package com.aitrich.services.flightBooking.flight.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBooking.domain.entity.Flight;
import com.aitrich.services.flightBooking.flight.requestDto.FlightDto;
@Component
public class CreateResponseToFlightDtoConverter implements Converter<Flight, FlightDto>{

	@Override
	public FlightDto convert(Flight source) {
		
		FlightDto flightModel = new FlightDto();
		
		flightModel.setArrival(source.getArrival());
		flightModel.setArrivalDate(source.getArrivalDate());
		flightModel.setDeparture(source.getDeparture());
		flightModel.setDepartureDate(source.getDepartureDate());
		return flightModel;
	}

}
