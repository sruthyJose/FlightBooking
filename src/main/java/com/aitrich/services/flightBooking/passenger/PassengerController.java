package com.aitrich.services.flightBooking.passenger;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.passenger.requestDto.PassengerDto;
import com.aitrich.services.flightBooking.passenger.requestDto.converter.CreateRequestToPassengerEntityConverter;
import com.aitrich.services.flightBooking.passenger.response.converter.ToPassengerDtoConverter;


@RestController
@RequestMapping("passenger")
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	CreateRequestToPassengerEntityConverter toPassengerEntityConverter;
	
	@Autowired
	ToPassengerDtoConverter toPassengerDtoConverter;
	
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody PassengerDto passenger)
	{
		Passenger passenger1 = toPassengerEntityConverter.convert(passenger);
		Passenger passenger2= passengerService.insert(passenger1);
		if(passenger2==null)
		{
			return new ResponseEntity<Object>("Insertion failed",HttpStatus.BAD_REQUEST);
		
			
		}
		else
		{
			return new ResponseEntity<Object>(toPassengerDtoConverter.convert(passenger2),HttpStatus.CREATED);
		}
			
			
	}
	
	@GetMapping
	public ResponseEntity<Object>  findAll()
	{
		List<Passenger> passengers = passengerService.getAllPassengers();
		List<PassengerDto> passengerModel = new ArrayList<PassengerDto>();
		if(!passengers.isEmpty())
		{
			for(Passenger p : passengers)
			{
				//PassengerModel passengerModel1 = passengerModelConverter.convert(p);
				passengerModel.add( toPassengerDtoConverter.convert(p) );
			}
			return new ResponseEntity<Object>(passengerModel,HttpStatus.OK);

		}
			
		else
			return new ResponseEntity<Object>("No passengers found",HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@Valid @RequestParam String id)
	{
		Passenger passenger = passengerService.getPassengerById(id);
		
		return new ResponseEntity<Object>(toPassengerDtoConverter.convert(passenger),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@Valid @RequestBody String id)
	{
		passengerService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	
	@GetMapping("/{email}")
	public ResponseEntity<Object> findByEmail(@Valid @RequestParam String email)
	{
		  Passenger pass= passengerService.getByEmail(email);
		  return new ResponseEntity<Object>(toPassengerDtoConverter.convert(pass),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@Valid @RequestBody PassengerDto passenger, String id)
	{
		Passenger pass = passengerService.getPassengerById(id);
		pass.setEmail(passenger.getEmail());
		pass.setFirstName(passenger.getFirstName());
		pass.setLastName(passenger.getLastName());
		pass.setFlightBooking(null);
		passengerService.update(pass);
		
		
		return new ResponseEntity<Object>(toPassengerDtoConverter.convert(pass),HttpStatus.CREATED);
	}

}
