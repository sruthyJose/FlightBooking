package com.aitrich.services.flightBooking.domain.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.aitrich.services.flightBooking.domain.entity.Passenger;

@Transactional
public interface PassangerRepo  extends JpaRepository<Passenger, String>{
	
	@Query(value = "select * from passenger p where p.email = ?1", nativeQuery = true )
	Passenger findByEmail(String email);

}
