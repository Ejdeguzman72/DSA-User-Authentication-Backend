package com.deguzman.HomeInfoTracker.exception;

public class CardNotFoundException extends Exception{
public static final Long serialVersionID = 1L;
	
	public CardNotFoundException(String message) {
		super(message);
	}
}
