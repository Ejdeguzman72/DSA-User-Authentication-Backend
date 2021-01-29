package com.dsa.HomeInfoTracker.exception;

public class CarRecordNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public CarRecordNotFoundException(String message) {
		super(message);
	}
}
