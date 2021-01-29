package com.deguzman.HomeInfoTracker.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class MedicalLogger {
	
	public final static Logger medicalLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void createLog() throws SecurityException, IOException
	{
		FileHandler medicalHandler;
		
		medicalHandler = new FileHandler(".\\log\\medical-logger.log");
		
		medicalLogger.addHandler(medicalHandler);
	}
}
