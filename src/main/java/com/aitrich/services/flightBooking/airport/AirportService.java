package com.aitrich.services.flightBooking.airport;

import java.util.List;
import java.util.Optional;

import com.aitrich.services.flightBooking.domain.entity.Airport;



public interface AirportService {
	
	Airport insert(Airport airport);
	Airport update(Airport airport);
	List<Airport> getAllAirports();
	void delete(String id);
	Optional<Airport> getAirportById(String id);

}
