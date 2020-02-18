package com.dsa.DeGuzmanServerApplication.exception;

public class TransactionNotFoundException extends Exception{
	
	public static final Long serialVersionID = 1L;
	
	public TransactionNotFoundException(String message) {
		super(message);
	}
}
