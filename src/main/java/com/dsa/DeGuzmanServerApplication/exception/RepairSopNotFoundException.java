package com.dsa.DeGuzmanServerApplication.exception;

public class RepairSopNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public RepairSopNotFoundException(String message) {
		super(message);
	}
}
