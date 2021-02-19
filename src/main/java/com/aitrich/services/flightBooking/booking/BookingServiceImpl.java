package com.aitrich.services.flightBooking.booking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.services.flightBooking.booking.requestDto.BookingDto;
import com.aitrich.services.flightBooking.booking.requestDto.FlightBookingSummaryModel;
import com.aitrich.services.flightBooking.booking.requestDto.converter.ToFlightBookingModelMinimalConverter;
import com.aitrich.services.flightBooking.domain.entity.Flight;
import com.aitrich.services.flightBooking.domain.entity.FlightBooking;
import com.aitrich.services.flightBooking.domain.entity.Passenger;
import com.aitrich.services.flightBooking.domain.repo.FlightBookingRepo;
import com.aitrich.services.flightBooking.domain.repo.FlightRepo;
import com.aitrich.services.flightBooking.flight.FlightService;
import com.aitrich.services.flightBooking.passenger.PassengerService;

@Service
@Transactional
public class BookingServiceImpl  implements BookingService{
	
	@Autowired
	private FlightBookingRepo bookingRepo;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private FlightService flightService;
	

	
	@Autowired
	private ToFlightBookingModelMinimalConverter toBookingModelConverter;

	public BookingServiceImpl(FlightBookingRepo bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	@Override
	public Boolean insert(FlightBooking booking) {
		
		/*
		 * passengerService.getPassengerById(booking.getPassenger().getId());
		 * Set<Flight> flightSet=booking.getFlights(); for(Flight fli:flightSet) {
		 * flightService.getFlightById(fli.getId()); }
		 */
		
		if(bookingRepo.save(booking)!=null)
		{
			return true;
		}
		else
			return false;
		
		
		
		
	}

	@Override
	public FlightBooking getById(String id) {
		
		return bookingRepo.findById(id).get();
	}

	@Override
	public List<FlightBooking> findAll() {
		
		List<FlightBooking>listOfBookings = bookingRepo.findAll();
		
		return listOfBookings;
	}


	@Override
	public void delete(String id) {
	
		bookingRepo.deleteById(id);
	}

	@Override
	public FlightBooking checkPassengerAndFlightExist(BookingDto booking) {
	
		Passenger pass = passengerService.getPassengerById(booking.getPassengerId());
		
		Flight flight = flightService.getFlightById(booking.getFlightsId());
		Set<Flight> flights= new HashSet<Flight>();
		flights.add(flight);
		
		FlightBooking flightBooking = new FlightBooking();
		flightBooking.setFlights(flights);
		flightBooking.setPassenger(pass);
		
		return flightBooking;
	}

}
