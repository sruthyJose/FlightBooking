package com.aitrich.services.flightBooking.airport;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.services.flightBooking.ExpectionHandler.ResourceNotFoundException;
import com.aitrich.services.flightBooking.domain.entity.Airport;



@RestController
@RequestMapping("airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	

	
	@PostMapping("add")
	public ResponseEntity<String> insert(@Valid @RequestBody Airport airport)
	{
		Airport airportResponse = airportService.insert(airport);
		if(airportResponse==null)
			throw new ResourceNotFoundException("Airport", "", "insertion failed");
		
			
		else
			return new ResponseEntity<String>("added successfully",HttpStatus.CREATED);
			
	}

	@GetMapping("findAll")
	public ResponseEntity<Object>  getAllAirports() {
		List<Airport> airports = airportService.getAllAirports();
		if(airports.isEmpty())
			{
			return new ResponseEntity<Object>("No airports found",HttpStatus.NOT_FOUND);
			}
		else
			return new ResponseEntity<Object>(airports,HttpStatus.OK);
	}

	@GetMapping("/{iata-code}")
	public ResponseEntity<Airport> getAirportById(@RequestParam String iataCode) {
		
		return new ResponseEntity<Airport>(airportService.getAirportById(iataCode).get(),HttpStatus.OK);
	}
	
	@PutMapping("update/{iatacode}")
	public ResponseEntity<Object> update(@Valid @RequestBody Airport airport)
	{
		
		airportService.update(airport);
		Airport airportExist = airportService.getAirportById(airport.getCountryIsoCode()).get();
		if( airportExist !=null)
		return new ResponseEntity<Object>(HttpStatus.OK);
		else
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("delete/{iatacode}")
	public  ResponseEntity<Object> delete(@Valid @RequestParam String id)
	{
		
		airportService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	

}
