package com.aitrich.services.flightBooking.test.passenger;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.aitrich.services.flightBooking.airport.AirportNotFoundException;
import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.domain.repo.PassangerRepo;
import com.aitrich.services.flightBooking.passenger.PassengerNotFoundException;
import com.aitrich.services.flightBooking.passenger.PassengerService;
import com.aitrich.services.flightBooking.passenger.PassengerServiceImpl;

public class PassengerServiceTest {
	
	@Mock
	private PassangerRepo passengerRepo;

	@InjectMocks
	private PassengerService passengerService;

	//private TestEntityManager entityManager;

	public PassengerServiceTest() {
   
		passengerRepo = mock(PassangerRepo.class);
		 passengerService = new PassengerServiceImpl(passengerRepo);
		//entityManager = mock(TestEntityManager.class);
	}
	
	@Test
	public void testPassangerSave()
	{
		Passenger passenger = new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com");
		when(passengerRepo.save(passenger)).thenReturn(passenger);
		Passenger passenger2 = passengerService.insert(passenger);
		assertEquals("PS-1", passenger2.getId());
		assertEquals("Sruthy", passenger2.getFirstName());
		assertEquals("Jose", passenger2.getLastName());
		assertEquals("Sruthy@gmail.com", passenger2.getEmail());	
		
	}
	@Test
	public void testPassenerUpdate()
	{
		Passenger passenger = new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com");
	
		Mockito.when(passengerRepo.findByEmail("Sruthy@gmail.com")).thenReturn(passenger);

		assertAll(() -> Optional.ofNullable(passengerService.getByEmail("Sruthy@gmail.com"))
				.orElseThrow(() -> new AirportNotFoundException("test")));
		
		
	}
	
	@Test
	public void testPassengerFindAll()
	{
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com"));
		passengers.add(new Passenger("PS-2","Safeer","Ismayil","Safeer@gmail.com"));
		passengers.add(new Passenger("PS-3","Vinaya","Mukundhan","Mukundhan@gmail.com"));
		when(passengerRepo.findAll()).thenReturn(passengers);
		List<Passenger> passengerList = passengerService.getAllPassengers();
		assertEquals(3, passengerList.size());
	}
	
	@Test
	public void testPassengerFindById()
	{
		Passenger passenger = new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com");
		Optional<Passenger> passenger2 = Optional.of(passenger);
		Mockito.when(passengerRepo.findById("PS-1")).thenReturn(passenger2);
		assertAll(() -> Optional.ofNullable(passengerService.getPassengerById("PS-1"))
				.orElseThrow(() -> new PassengerNotFoundException("test")));
		
	}
	
	@Test
	public void testPassengerFindByEmail()
	{
		Passenger passenger = new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com");
		
		Mockito.when(passengerRepo.findByEmail("Sruthy@gmail.com")).thenReturn(passenger);
		assertAll(() -> Optional.ofNullable(passengerService.getByEmail("Sruthy@gmail.com"))
				.orElseThrow(() -> new PassengerNotFoundException("test")));
		
	}
	
	@Test
	public void testPassengerDeleteById() {
		Passenger passenger = new Passenger("PS-1","Sruthy","Jose","Sruthy@gmail.com");
		passengerService.delete(passenger.getId());
		verify(passengerRepo, times(1)).deleteById(passenger.getId());

	}
	
	

	
	

}
