package com.aitrich.services.flightBooking.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

import com.aitrich.services.flightBooking.domain.entity.FlightBooking;
@Repository
public interface FlightBookingRepo extends JpaRepository<FlightBooking, String>{
	
//	@Query(value = "select f from FlightBooking f where f.flights=?1 and f.passenger= ?2")
//	FlightBooking checkBookingAlreadyExist(@Param("flightId") String flightId, @Param("passengerId") String pssengerId);

}
