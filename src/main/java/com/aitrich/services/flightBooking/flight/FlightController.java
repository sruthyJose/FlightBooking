package com.aitrich.services.flightBooking.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.aitrich.services.flightBooking.domain.entity.Flight;
import com.aitrich.services.flightBooking.flight.requestDto.FlightDto;
import com.aitrich.services.flightBooking.flight.requestDto.converter.CreateRequestToFlightEntityConverter;
import com.aitrich.services.flightBooking.flight.response.converter.CreateResponseToFlightDtoConverter;

@RestController
@RequestMapping("flight")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private  CreateRequestToFlightEntityConverter  toFlight;
	@Autowired
	private CreateResponseToFlightDtoConverter toFlightModel;
	
	
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody FlightDto flight)
	{
		Flight flight1= toFlight.convert(flight);
		Flight flight2= flightService.insert(flight1);
	
				if(flight2==null)
					return new ResponseEntity<Object>("insertion failed",HttpStatus.BAD_REQUEST);
				else
					return new ResponseEntity<Object>("Added successfully",HttpStatus.CREATED);
	
		
	
	}
	
	@GetMapping
	public ResponseEntity<Object>  findAll()
	{
		List<Flight> flights = flightService.getAllFlights();
		List<FlightDto> flightModels = new ArrayList<FlightDto>();
		if(flights.isEmpty())
		{
			return new ResponseEntity<Object>("No Flights found",HttpStatus.NOT_FOUND);
		}
		else
		{
			for(Flight flight: flights)
			{
				flightModels.add(toFlightModel.convert(flight));
			}
			return new ResponseEntity<Object>(flightModels,HttpStatus.OK);
			
		}
		
			
		
		
			
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object>  finbById( @RequestParam String id)
	{
		Flight flight = flightService.getFlightById(id);
		return new ResponseEntity<Object>(toFlightModel.convert(flight),HttpStatus.OK);
		
	}
	
	 @GetMapping("/{departure}/{departureDate}") 
	 public ResponseEntity<Object> findByDateAndPlace(@RequestParam String departure, @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate) 
	 {
	  List<Flight> flights = flightService.findByDepartureAndDepartureDateGreaterThan(departure,departureDate); 
	  List<FlightDto> flightModels = new ArrayList<FlightDto>();
		if (!flights.isEmpty()) 
		{
			for (Flight flight : flights) 
			{
				flightModels.add(toFlightModel.convert(flight));
			}
			 return new ResponseEntity<Object>(flights,HttpStatus.OK);
		}
		 
		else
			 return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	 
		 
	 
	  }
	 
	
	@PutMapping("/{id}")
	public ResponseEntity<Object>  update(@Valid @RequestBody FlightDto flight, @RequestParam String id)
	{
		
		Flight flightById = flightService.getFlightById(id);
		flightById.setArrival(flight.getArrival());
		flightById.setArrivalDate(flight.getArrivalDate());
		flightById.setDeparture(flight.getDeparture());
		flightById.setDepartureDate(flight.getDepartureDate());
		flightById.setBookings(null);
		flightService.update(flightById);
		return new ResponseEntity<Object>("Updated ",HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@RequestParam String id)
	{
		flightService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
