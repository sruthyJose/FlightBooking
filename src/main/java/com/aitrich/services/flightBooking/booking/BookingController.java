package com.aitrich.services.flightBooking.booking;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.services.flightBooking.booking.requestDto.BookingDto;

import com.aitrich.services.flightBooking.booking.requestDto.FlightBookingSummaryModel;
import com.aitrich.services.flightBooking.booking.requestDto.converter.CreateRequestToBookingEntityConverter;

import com.aitrich.services.flightBooking.booking.requestDto.converter.ToFlightBookingModelMinimalConverter;
import com.aitrich.services.flightBooking.booking.response.converter.ToFlightBookingResponseDtoConverter;
import com.aitrich.services.flightBooking.domain.entity.FlightBooking;



@RestController
@RequestMapping("booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ToFlightBookingResponseDtoConverter toBookingModelConverter;
	
	@Autowired
	private CreateRequestToBookingEntityConverter toBookingEntity;
	@Autowired
	private ToFlightBookingModelMinimalConverter toSummaryModel;
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody BookingDto booking)
	{
		
		//FlightBooking flightBooking = toBookingEntity.convert(booking);
		FlightBooking flightBooking= bookingService.checkPassengerAndFlightExist(booking);
		if(bookingService.insert(flightBooking)==true)
		{
			return new ResponseEntity<Object>("Added suuceesfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>("Insertion failed", HttpStatus.BAD_REQUEST);
	}
	             
	@GetMapping("/{bookingId}")
	public ResponseEntity<Object>  getBookingById(@PathVariable String bookingId) {

		
		return new ResponseEntity<Object>(toBookingModelConverter.convert(bookingService.getById(bookingId)),HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<Object> findAll()
	{
		List<FlightBooking> listOfBooking=  bookingService.findAll();
		List<FlightBookingSummaryModel> listOfBookingModel = new ArrayList<FlightBookingSummaryModel>();
		if(listOfBooking!=null) 
		{
			for (FlightBooking list:listOfBooking) {
				
				listOfBookingModel.add(toSummaryModel.convert(list));
				
			}
			return new ResponseEntity<Object>(listOfBookingModel,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			
		
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@RequestBody String id)
	{
		bookingService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
