package com.aitrich.services.flightBooking.booking.response.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;



import com.aitrich.services.flightBooking.booking.responseDto.FlightBookingResponseDto;
import com.aitrich.services.flightBooking.domain.entity.FlightBooking;
import com.aitrich.services.flightBooking.flight.requestDto.FlightDto;
import com.aitrich.services.flightBooking.passenger.requestDto.PassengerDto;


@Component
public class ToFlightBookingResponseDtoConverter implements Converter<FlightBooking, FlightBookingResponseDto>{

	@Override
	public FlightBookingResponseDto convert(FlightBooking source) {
		List<FlightDto> flights = new ArrayList<>();

		if (!CollectionUtils.isEmpty(source.getFlights())) {
			source.getFlights().stream().forEach(flight -> {
				flights.add(new FlightDto(flight.getDeparture(), flight.getArrival(),
						flight.getDepartureDate(), flight.getArrivalDate()));
			});
		}

		return new FlightBookingResponseDto(source.getId(), new PassengerDto(source.getPassenger().getFirstName(),
				source.getPassenger().getLastName(), source.getPassenger().getEmail()), flights);
	
	}

}
