package com.aitrich.services.flightBooking.passenger;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.domain.repo.PassangerRepo;
import com.aitrich.services.flightBooking.passenger.response.converter.ToPassengerDtoConverter;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassangerRepo passengerRepo;
	

	
	public PassengerServiceImpl(PassangerRepo passengerRepo)
	{
		this.passengerRepo=passengerRepo;
	}

	@Override
	public Passenger insert(Passenger passenger) {
			return passengerRepo.save(passenger);
	
	}

	@Override
	public List<Passenger> getAllPassengers() {
		

		List<Passenger> pass = passengerRepo.findAll();
		return pass;
		
	}

	@Override
	public Passenger getPassengerById(String id) {

		return passengerRepo.findById(id).get();

	}

	@Override
	public void update(Passenger passenger) {

	
	
		passengerRepo.save(passenger);

	}

	@Override
	public void delete(String id) {
		passengerRepo.deleteById(id);

	}

	@Override
	public Passenger getByEmail(String email) {

		return passengerRepo.findByEmail(email);
	
	}

}
