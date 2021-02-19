package com.aitrich.services.flightBooking.ExpectionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
//@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(value = { ResourceNotFoundException.class})
	    public final ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		 
		 ExceptionMessage exceptionDetails = new ExceptionMessage(HttpStatus.NOT_FOUND.value(),new Date(),ex.getMessage());
		 System.out.println("INside excception handler1");
	        return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(value= {Exception.class})
	 public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		 ExceptionMessage exceptionDetails = new ExceptionMessage(HttpStatus.NOT_FOUND.value(),new Date(),ex.getMessage());
		 System.out.println("INside excception handler2");
		 return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	 }
	 
	 @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ExceptionMessage exceptionDetails = new ExceptionMessage(HttpStatus.BAD_REQUEST.value(),new Date(),ex.getMessage());
		 System.out.println("INside excception handler3");
			return new ResponseEntity<Object>(exceptionDetails, new HttpHeaders(), exceptionDetails.getStatus());
		}
	 
	 @ExceptionHandler(value = { EmptyResultDataAccessException.class })
	 public final ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
	  
		 ExceptionMessage exceptionDetails = new ExceptionMessage(HttpStatus.BAD_REQUEST.value(),new Date(),ex.getMessage());
		 System.out.println("INside excception handler4");
		 return new ResponseEntity<Object>(exceptionDetails, HttpStatus.BAD_REQUEST);
	 }
	 
	 


}
