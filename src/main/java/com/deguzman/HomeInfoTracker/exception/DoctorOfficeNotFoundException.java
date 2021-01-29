package com.deguzman.HomeInfoTracker.exception;

public class DoctorOfficeNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public DoctorOfficeNotFoundException(String message) {
		super(message);
	}
}
