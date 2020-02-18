package com.dsa.DeGuzmanServerApplication.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class MedicalLogger {
	
	private final static Logger medicalLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException
	{
		FileHandler medicalHandler;
		
		medicalHandler = new FileHandler("C:\\Users\\ejdeg\\DeGuzmanServerApplication\\DeGuzmanServerApplication\\log\\medical-logger.log");
		medicalLogger.addHandler(medicalHandler);
	}
}
