package com.dsa.DeGuzmanServerApplication.formatter;

public class RepairShopFormatter {
	
	public String formatAddress(String address)
	{
		String formattedAddress = address.substring(0).toUpperCase();
		return formattedAddress;
	}
	
	public String formatCity(String city)
	{
		String formattedCity = city.substring(0).toUpperCase();
		return formattedCity;
	}
	
	public String formatName(String name)
	{
		String formattedName = name.substring(0).toUpperCase();
		return formattedName;
	}
	
	public String formatState(String state)
	{
		String formattedState = state.substring(0).toUpperCase();
		return formattedState;
	}
}
