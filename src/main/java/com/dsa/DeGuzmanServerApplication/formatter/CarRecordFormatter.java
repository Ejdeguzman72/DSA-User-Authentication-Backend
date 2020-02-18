package com.dsa.DeGuzmanServerApplication.formatter;

import java.text.DecimalFormat;

public class CarRecordFormatter {
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public String formatCurrency(double amount)
	{
		return (format.format(amount));
	}
}
