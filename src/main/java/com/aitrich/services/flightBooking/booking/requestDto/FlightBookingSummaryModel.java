package com.aitrich.services.flightBooking.booking.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingSummaryModel {
	
	private String bookingId;
	private String lastName;
	private String departure;
	/*
	 * public FlightBookingSummaryModel() { super(); // TODO Auto-generated
	 * constructor stub } public FlightBookingSummaryModel(String bookingId, String
	 * lastName, String departure) { super(); this.bookingId = bookingId;
	 * this.lastName = lastName; this.departure = departure; } public String
	 * getBookingId() { return bookingId; } public void setBookingId(String
	 * bookingId) { this.bookingId = bookingId; } public String getLastName() {
	 * return lastName; } public void setLastName(String lastName) { this.lastName =
	 * lastName; } public String getDeparture() { return departure; } public void
	 * setDeparture(String departure) { this.departure = departure; }
	 * 
	 * @Override public String toString() { return
	 * "FlightBookingSummaryModel [bookingId=" + bookingId + ", lastName=" +
	 * lastName + ", departure=" + departure + "]"; }
	 * 
	 */
}
