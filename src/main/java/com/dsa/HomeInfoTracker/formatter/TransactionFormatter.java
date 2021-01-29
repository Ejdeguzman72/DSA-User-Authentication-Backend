package com.dsa.HomeInfoTracker.formatter;

import java.text.DecimalFormat;

public class TransactionFormatter {
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public String formatCurrency(double amount)
	{
		return (format.format(amount));
	}
}
