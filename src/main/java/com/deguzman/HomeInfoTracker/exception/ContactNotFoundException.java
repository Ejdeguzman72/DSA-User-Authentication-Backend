package com.deguzman.HomeInfoTracker.exception;

public class ContactNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public ContactNotFoundException(String message) {
		super(message);
	}
}
