package com.dsa.DeGuzmanServerApplication.exception;

public class CarRecordNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public CarRecordNotFoundException(String message) {
		super(message);
	}
}
