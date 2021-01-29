package com.dsa.HomeInfoTracker.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class ContactLogger {
	
	public final static Logger contactLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void createLog() throws SecurityException, IOException
	{
		
		FileHandler contactFileHandler;
		
		contactFileHandler = new FileHandler(".\\log\\contact-logger.log");
		
		contactLogger.addHandler(contactFileHandler);
	}
	
	
}
