package com.aitrich.services.flightBooking.flight;

import java.time.LocalDateTime;
import java.util.List;


import com.aitrich.services.flightBooking.domain.entity.Flight;


public interface FlightService {
	
	Flight insert(Flight flight);
	List<Flight> getAllFlights();
	Flight getFlightById(String id);
	
	//void update(Flight flight, String id);
	void delete(String id);
	List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);
	void update(Flight flight);


}
