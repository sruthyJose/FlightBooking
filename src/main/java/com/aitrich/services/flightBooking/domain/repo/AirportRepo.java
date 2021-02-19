package com.aitrich.services.flightBooking.domain.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aitrich.services.flightBooking.domain.entity.Airport;

@Transactional
public interface AirportRepo extends JpaRepository<Airport,String>{

	@Query(value= "select a from Airport a where a.iataCode = ?1")
	public Airport getByIatacode(String iatacode);
}
