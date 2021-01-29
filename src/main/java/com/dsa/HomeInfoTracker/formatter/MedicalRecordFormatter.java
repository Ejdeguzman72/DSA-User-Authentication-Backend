package com.dsa.HomeInfoTracker.formatter;

import java.text.DecimalFormat;

public class MedicalRecordFormatter {

	public String formatName(String name)
	{
		String formattedName = name.substring(0).toUpperCase();
		return formattedName;
	}
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public String formatCurrency(double amount)
	{
		return (format.format(amount));
	}
}
