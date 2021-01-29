package com.deguzman.HomeInfoTracker.exception;

public class ResourceNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}