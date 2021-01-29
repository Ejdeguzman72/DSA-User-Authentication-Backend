package com.deguzman.HomeInfoTracker.exception;

public class MedicalRecordNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public MedicalRecordNotFoundException(String message) {
		super(message);
	}
}
