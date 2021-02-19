package com.aitrich.services.flightBooking.ExpectionHandler;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 62898215276911029L;

	public ResourceNotFoundException(String resourceType, String keyName, String keyValue) {
		super(resourceType + " with " + keyName + " [ " + keyValue + " ] not found in the system!");
		System.out.println("Inside ResourceNotFound");
		
	}

}
