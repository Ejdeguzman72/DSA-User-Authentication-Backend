package com.dsa.HomeInfoTracker.exception;

public class BankNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public BankNotFoundException(String message) {
		super(message);
	}
}
