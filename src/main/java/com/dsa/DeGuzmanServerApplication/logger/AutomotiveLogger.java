package com.dsa.DeGuzmanServerApplication.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class AutomotiveLogger {

	private final static Logger automotiveLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException
	{
		FileHandler automotiveHandler;
		
		automotiveHandler = new FileHandler("C:\\Users\\ejdeg\\DeGuzmanServerApplication\\DeGuzmanServerApplication\\log\\automotive-logger.log");
		automotiveLogger.addHandler(automotiveHandler);
	}
	
}
