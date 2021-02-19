package com.aitrich.services.flightBooking.passenger.requestDto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.passenger.requestDto.PassengerDto;
@Component
public class CreateRequestToPassengerEntityConverter  implements Converter<PassengerDto, Passenger>{

	@Override
	public Passenger convert(PassengerDto source) {

		Passenger passenger = new Passenger();
		passenger.setEmail(source.getEmail());
		passenger.setFirstName(source.getFirstName());
		passenger.setLastName(source.getLastName());
		return passenger;
	}

}
