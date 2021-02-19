package com.aitrich.services.flightBooking.passenger.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.passenger.requestDto.PassengerDto;
@Component
public class ToPassengerDtoConverter implements Converter<Passenger, PassengerDto>{

	@Override
	public PassengerDto convert(Passenger source) 
	{
		
		PassengerDto pass = new PassengerDto();
		pass.setEmail(source.getEmail());
		pass.setFirstName(source.getFirstName());
		pass.setLastName(source.getLastName());
		
		return pass;
	}

}
