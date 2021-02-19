package com.aitrich.services.flightBooking.test.airport;


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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.aitrich.services.flightBooking.airport.AirportNotFoundException;
import com.aitrich.services.flightBooking.airport.AirportService;
import com.aitrich.services.flightBooking.airport.AirportServiceImplementation;
import com.aitrich.services.flightBooking.domain.entity.Airport;
import com.aitrich.services.flightBooking.domain.repo.AirportRepo;

@ExtendWith(SpringExtension.class)
public class AirportServiceTest {

	@Mock
	private AirportRepo airportRepo;

	@InjectMocks
	private AirportService airportService;

	private TestEntityManager entityManager;

	public AirportServiceTest() {
		airportService = new AirportServiceImplementation();
		airportRepo = mock(AirportRepo.class);
		entityManager = mock(TestEntityManager.class);
	}

	@Test
	public void testAirportSave() {
		Airport airport = new Airport("cnn", "Kannur International Airport", "IND");
		when(airportRepo.save(airport)).thenReturn(airport);
		Airport airport2 = airportService.insert(airport);
		assertEquals("cnn", airport2.getIataCode());
		assertEquals("Kannur International Airport", airport2.getName());
		assertEquals("IND", airport2.getCountryIsoCode());
	}
	
	@Test
	public void testAirportUpdate() {
		Airport airport = new Airport("cnn", "Kannur International Airport", "IND");
		when(airportRepo.save(airport)).thenReturn(airport);
		Airport airport2 = airportService.update(airport);
		assertEquals("cnn", airport2.getIataCode());
		assertEquals("Kannur International Airport", airport2.getName());
		assertEquals("IND", airport2.getCountryIsoCode());
	}

	@Test
	public void testFindAllAirport() {
		List<Airport> airports = new ArrayList<Airport>();
		airports.add(new Airport("koc", "koc-ind", "kochin"));
		airports.add(new Airport("clt", "clt-ind", "calicut"));
		airports.add(new Airport("tvm", "tvm-ind", "trivandrum"));
		when(airportRepo.findAll()).thenReturn(airports);
		List<Airport> airportlist = airportService.getAllAirports();
		assertEquals(3, airportlist.size());
	}

	@Test
	public void testAirportFindById() {
		final Airport airport = new Airport("koc", "koc-ind", "kochin");
		Optional<Airport> optionalEntityType = Optional.of(airport);
		Mockito.when(airportRepo.findById("koc")).thenReturn(optionalEntityType);

		assertAll(() -> Optional.ofNullable(airportService.getAirportById("koc"))
				.orElseThrow(() -> new AirportNotFoundException("test")));
		

	}

	@Test
	public void testAirportDeleteById() {
		Airport airport = new Airport("koc", "koc-ind", "kochin");
		airportService.delete(airport.getIataCode());
		verify(airportRepo, times(1)).deleteById(airport.getIataCode());

	}

}
