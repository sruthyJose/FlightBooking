package com.aitrich.services.flightBooking.domain.repo;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aitrich.services.flightBooking.domain.entity.Flight;

@Transactional
public interface FlightRepo extends JpaRepository<Flight, String>{
	
	@Query(value = "select f from Flight f where f.departure =?1 and f.departureDate >= ?2")
	List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);
	
	

}
