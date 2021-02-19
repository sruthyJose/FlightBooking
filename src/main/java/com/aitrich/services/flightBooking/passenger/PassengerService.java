package com.aitrich.services.flightBooking.passenger;

import java.util.List;
import java.util.Optional;


import com.aitrich.services.flightBooking.domain.entity.Passenger;



public interface PassengerService {
	
	Passenger  insert(Passenger passanger);
	List<Passenger> getAllPassengers();
	Passenger getPassengerById(String passengerId);
	
	void update(Passenger passenger);
	void delete(String id);
	
	Passenger getByEmail(String email);

}
