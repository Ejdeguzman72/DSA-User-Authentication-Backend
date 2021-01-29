package com.dsa.HomeInfoTracker.exception;

public class CarNotFoundException extends Exception{

	public static final Long serialVersionID = 1L;
	
	public CarNotFoundException(String message) {
		super(message);
	}
}
