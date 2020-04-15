package com.dsa.DeGuzmanServerApplication.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class FinancialLogger {
	
	private final static Logger financialLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException
	{
		FileHandler financialHandler;
		
		financialHandler = new FileHandler("C:\\EJ-Projects\\EJ-Application-DSA\\Project-DSA-Authentication-Backend\\log\\financial-logger.log");
		financialLogger.addHandler(financialHandler);
		financialLogger.info(logMessage);
		
	}
}
