package com.aitrich.services.flightBooking.test.flight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import com.aitrich.services.flightBooking.domain.entity.Flight;

import com.aitrich.services.flightBooking.domain.repo.FlightRepo;
import com.aitrich.services.flightBooking.flight.FlightNotFoundException;
import com.aitrich.services.flightBooking.flight.FlightService;
import com.aitrich.services.flightBooking.flight.FlightServiceImpl;


public class FlightServiceTest {
	@Mock
	private FlightRepo flightRepo;
	
	@InjectMocks
	private FlightService flightService;
	
	
	public FlightServiceTest()
	{
		flightRepo =  mock(FlightRepo.class);
		flightService = new FlightServiceImpl(flightRepo);
	}
	
	@Test
	public void testFlightSave()
	{
		Flight flight  = new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364"));
		when(flightRepo.save(flight)).thenReturn(flight);
		Flight flight2 = flightService.insert(flight);
		assertEquals("FL-1", flight2.getId());
		assertEquals("Dubai", flight2.getDeparture());
		assertEquals("Kochi", flight2.getArrival());
		assertEquals(LocalDateTime.parse("2021-02-19T07:25:05.364"),flight2.getDepartureDate());	
		assertEquals(LocalDateTime.parse("2021-02-19T07:25:05.364"),flight2.getArrivalDate());
	}
	
	@Test
	public void testFlightUpdate()
	{
		Flight flight  = new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364"));
		Optional<Flight> flight2 = Optional.of(flight);
		Mockito.when(flightRepo.findById("FL-1")).thenReturn(flight2);

		assertAll(() -> Optional.ofNullable(flightService.getFlightById("FL-1"))
				.orElseThrow(() -> new FlightNotFoundException("test")));
		
		
	}
	
	@Test
	public void testFlightFindAll()
	{
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364")) );
		flights.add(new Flight("FL-2","Dubai","Kannur",LocalDateTime.parse("2021-03-19T07:25:05.364"),LocalDateTime.parse("2021-03-19T07:25:05.364")) );
		
		when(flightRepo.findAll()).thenReturn(flights);
		List<Flight> flightList = flightService.getAllFlights();
		assertEquals(2, flightList.size());
	}
	
	@Test
	public void testPassengerFindById()
	{
		Flight flight = new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364"));
		Optional<Flight> flight2 = Optional.of(flight);
		Mockito.when(flightRepo.findById("FL-1")).thenReturn(flight2);
		assertAll(() -> Optional.ofNullable(flightService.getFlightById("FL-1"))
				.orElseThrow(() -> new FlightNotFoundException("test")));
		
	}
	
	@Test
	public void testFlightDeleteById() {
		Flight flight = new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364"));
		flightService.delete(flight.getId());
		verify(flightRepo, times(1)).deleteById(flight.getId());

	}
	
	@Test
	public void testFlightFindByDeparture()
	{
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("FL-1","Dubai","Kochi",LocalDateTime.parse("2021-02-19T07:25:05.364"),LocalDateTime.parse("2021-02-19T07:25:05.364")) );
		flights.add(new Flight("FL-2","Dubai","Kannur",LocalDateTime.parse("2021-03-19T07:25:05.364"),LocalDateTime.parse("2021-03-19T07:25:05.364")) );
		
		
		Mockito.when(flightRepo.findByDepartureAndDepartureDateGreaterThan("Dubai", LocalDateTime.parse("2021-02-19T07:25:05.364"))).thenReturn(flights);
		assertAll(() -> Optional.ofNullable(flightService.findByDepartureAndDepartureDateGreaterThan("Dubai", LocalDateTime.parse("2021-02-19T07:25:05.364"))));
		
	}
}
