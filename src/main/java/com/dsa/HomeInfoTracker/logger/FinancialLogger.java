package com.dsa.HomeInfoTracker.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class FinancialLogger {
	
	public final static Logger financialLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void createLog() throws SecurityException, IOException
	{
		FileHandler financialHandler;
		
		financialHandler = new FileHandler(".\\log\\financial-logger.txt");
		
		financialLogger.addHandler(financialHandler);
		
	}
}
