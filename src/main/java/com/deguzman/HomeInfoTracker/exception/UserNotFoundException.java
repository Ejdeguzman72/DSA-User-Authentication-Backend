package com.deguzman.HomeInfoTracker.exception;

public class UserNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
