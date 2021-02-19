package com.aitrich.services.flightBooking.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
@Component
public class DateUtil {
public static final DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static LocalDateTime toLocalDateTime(String strDate) {
		return LocalDateTime.parse(strDate, GlobalDateFormatter);
	}
	

}
