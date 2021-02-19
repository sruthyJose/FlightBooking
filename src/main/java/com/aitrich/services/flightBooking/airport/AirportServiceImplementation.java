package com.aitrich.services.flightBooking.airport;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aitrich.services.flightBooking.domain.entity.Airport;
import com.aitrich.services.flightBooking.domain.repo.AirportRepo;

@Service
@Transactional
public class AirportServiceImplementation implements AirportService {

	@Autowired
	private AirportRepo airportRepo;

	@Override
	public Airport insert(Airport airport) {

		return airportRepo.save(airport);

	}

	@Override
	public List<Airport> getAllAirports() {

		return airportRepo.findAll();
	}

	@Override
	public void delete(String id) {

		airportRepo.deleteById(id);

	}

	@Override
	public Optional<Airport> getAirportById(String id) {

		return airportRepo.findById(id);
	}

	@Override
	public Airport update(Airport airport) {

		
		/*
		 * Airport airportExist = getAirportById(airport.getCountryIsoCode()).get();
		 * airportExist.setCountryIsoCode(airport.getCountryIsoCode());
		 * airportExist.setIataCode(airport.getIataCode());
		 * airportExist.setName(airport.getName());
		 */
		 
		return airportRepo.save(airport);
	}

}
