package com.dsa.HomeInfoTracker.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class AutomotiveLogger {

	public final static Logger automotiveLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void createLog() throws SecurityException, IOException
	{
		FileHandler automotiveHandler;
		
		automotiveHandler = new FileHandler(".\\log\\automotive-logger.log");
		
		automotiveLogger.addHandler(automotiveHandler);
	}
	
}
