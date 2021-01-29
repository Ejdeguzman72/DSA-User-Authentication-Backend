package com.dsa.HomeInfoTracker.formatter;

import org.springframework.stereotype.Service;

@Service
public class CarFormatter {
	
	public String formatAC(String ac)
	{
		String formmatedAC = ac.substring(0).toUpperCase();
		return formmatedAC;
	}
	
	
	public String formatMake(String make)
	{
		String formattedMake = make.substring(0).toUpperCase();
		return formattedMake;
	}
	
	public String formatModel(String model)
	{
		String formattedModel = model.substring(0).toUpperCase();
		return formattedModel;
	}
	
	public String formatTransmission(String transmission)
	{
		String formattedTransmission = transmission.substring(0).toUpperCase();
		return formattedTransmission;
	}
}
