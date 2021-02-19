package com.aitrich.services.flightBooking.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aitrich.services.flightBooking.domain.entity.Flight;
import com.aitrich.services.flightBooking.domain.repo.FlightRepo;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	

	@Autowired
	private FlightRepo flightRepo;


	
	public FlightServiceImpl(FlightRepo flightRepo)
	{
		this.flightRepo=flightRepo;
	}

	@Override
	public Flight insert(Flight flight) {
		//flight.setBookings(null);
		return flightRepo.save(flight);
			
			
	}

	@Override
	public List<Flight> getAllFlights() {
		
		List<Flight> flights = flightRepo.findAll();
		return flights;
	}

	@Override
	public Flight getFlightById(String id) {

		return flightRepo.findById(id).get();
	}

	@Override
	public void update(Flight flight) {

		/*
		 * Flight flightById = getFlightById(id);
		 * flightById.setArrival(flight.getArrival());
		 * flightById.setArrivalDate(flight.getArrivalDate());
		 * flightById.setDeparture(flight.getDeparture());
		 * flightById.setDepartureDate(flight.getDepartureDate());
		 * flightById.setBookings(null);
		 */
		flightRepo.save(flight);
	}

	@Override
	public void delete(String id) {

		flightRepo.deleteById(id);

	}

	@Override
	public List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate) {

		List<Flight> flights = flightRepo.findByDepartureAndDepartureDateGreaterThan(departure, departureDate);
		return flights;

	}

}
