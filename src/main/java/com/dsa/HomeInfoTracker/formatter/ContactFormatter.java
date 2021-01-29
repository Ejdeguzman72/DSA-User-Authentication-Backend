package com.dsa.HomeInfoTracker.formatter;

public class ContactFormatter {

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
	
	public String formatFirstname(String firstname)
	{
		String formattedFirstname = firstname.substring(0).toUpperCase();
		return formattedFirstname;
	}
	
	public String formatLastname(String lastname)
	{
		String formattedLastname = lastname.substring(0).toUpperCase();
		return formattedLastname;
	}
	
	public String formatPhoneNumber(String phone)
	{
		return "(" + phone.substring(0-2) + ")" + "-" + phone.substring(3-6) + "-" + phone.substring(7-10);
	}
	
	public String formatState(String state)
	{
		String formattedState = state.substring(0).toUpperCase();
		return formattedState;
	}
}
