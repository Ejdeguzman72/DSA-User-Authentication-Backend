package com.dsa.DeGuzmanServerApplication.models;

import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	public JwtResponse(String jwttoken) 
	{
		this.jwttoken = jwttoken;
	}
	
	public String getToken() 
	{
		return this.jwttoken;
	}
}