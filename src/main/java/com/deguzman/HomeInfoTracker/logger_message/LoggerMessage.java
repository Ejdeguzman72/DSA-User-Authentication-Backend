package com.deguzman.HomeInfoTracker.logger_message;

public class LoggerMessage {

	// person info messages 
	public static String GET_ALL_PERSON_INFO = "Retreived all person info";
	
	public static String GET_PERSON_INFO_BY_ID = "Retrieved Person Info with ID: ";
	
	public static String ADD_PERSON_INFO = "Added Person Info";
	
	public static String UPDATE_PERSON_INFO = "Updated Person Info";
	
	public static String DELETE_PERSON_INFO = "Deleted Person Info";
	
	
	// person error messages
	public static String GET_ALL_PERSON_INFO_ERROR_MESSAGE = "List is Empty";
	
	public static String GET_PERSON_INFO_BY_ID_ERROR_MESSAGE = "Invalid ID / Null";
	
	public static String ADD_PERSON_INFO_ERROR_MESSAGE = "Person Entity is null";
	
	public static String UPDATE_PERSON_INFO_ERROR_MESSAGE = "Person Info was not updated";
	
	public static String DELETE_PERSON_INFO_ERROR_MESSAGE = "Person Info was not deleted";
	
	
	// auto transaction info messages 
	public static String GET_ALL_AUTO_TRX_INFO_MESSAGE = "Retrieved all auto transaction info";
	
	public static String GET_AUTO_TRX_INFO_BY_ID_MESSAGE = "Retrieved auto transaction:";
	
	public static String ADD_AUTO_TRX_INFO_MESSAGE = "Added auto tranasction information";
	
	public static String UPDATE_AUTO_TRX_INFO_MESSAGE = "Updated auto transaction information";
	
	public static String DELETE_AUTO_TRX_MESSAGE = "Deleted auto transaction information";
	
	
	// auto transaction error messasges
	public static String GET_ALL_AUTO_TRX_INFO_ERROR_MESSAGE = "List is empty / List is null";
	
	public static String GET_AUTO_TRX_INFO_BY_ID_ERROR_MESSAGE = "Invalid ID / Null ID";
	
	public static String ADD_AUTO_TRX_INFO_ERROR_MESSAGE = "Auto Transaction is null";
	
	public static String UPDATE_AUTO_TRX_INFO_ERROR_MESSAGE = "Auto transaction information cannot be updated";
	
	public static String DELETE_AUTO_TRX_INFO_ERROR_MESSAGE = "Auto transaction information cannot be deleted";
	
	
	// medical transaction info messages 
	public static String GET_ALL_MEDICAL_TRX_INFO_MESSAGE = "retrieved all medical transaction information";
	
	public static String GET_MEDICAL_TRX_BY_ID_INFO_MESSAGE = "Retrieved medical transaction information";
	
	public static String ADD_MEDICAL_TRX_INFORMATION_INFO_MESSAGE = "Added new medical transaction";
	
	public static String UPDATE_MEDICAL_TRX_INFORMATION_INFO_MESSAGE = "Updated medical transaction";
	
	public static String DELETE_MEDICAL_TRX_INFORMATION_INFO_MESSAGE = "Deleted medical transaction";
	
	
	// medical transaction error messages
	public static String GET_ALL_MEDICAL_TRX_ERROR_MESSAGE = "Unable to get list of medical transactions. List is empty / null";
	
	public static String GET_MEDICAL_TRX_BY_ID_ERROR_MESSAGE = "medical transcation id is null / invalid";
	 
	public static String ADD_MEDICAL_TRX_ERROR_MESSAGE = "Unable to add new medical transaction";
	
	public static String UPDATE_MEDICAL_TRX_ERROR_MESSAGE = "Unable to update medical transation information";
	
	public static String DELETE_MEDICAL_TRX_ERROR_MESSAGE = "Unable to delete medical transaction information";
	
	
	// general transaction info messages
	public static String GET_ALL_GENERAL_TRX_INFO_MESSAGE = "Retrieved all general transaction information";
	
	public static String GET_GENERAL_TRX_BY_ID_INFO_MESSAGE = "Retrieved general transaction information";
	
	public static String ADD_GENERAL_TRX_INFO_MESSAGE = "Added general transaction information";
	
	public static String UPDATE_GENERAL_TRX_INFO_MESSAGE = "Updated general transaction information";
	
	public static String DELETE_GENERAL_TRX_INFO_MESSAGE = "Deleted general transaction information";
	
	
	// general transaction error messages
	public static String GET_ALL_GENERAL_TRX_ERROR_MESSAGE = "General transaction list is null / empty";
	
	public static String GET_GENERAL_TRX_BY_ID_ERROR_MESSAGE = "General transaction ID is empty / null";
	
	public static String ADD_GENERAL_TRX_ERROR_MESSAGE = "Added general transcation:";
	
	public static String UPDATE_GENERAL_TRX_ERROR_MESSAGE = "Updated general transaction";
	
	public static String DELETE_GENERAL_TRX_ERROR_MESSAGE = "Deleted general transaction";
	
	
	// auto transaction file upload info messages
	public static String CREATE_AUTO_TRANSACTION_UPLOADS_INFO_MESSAGE = "Created auto-transaction-uploads folder";
	
	public static String SAVE_AUTO_TRANSACTION_FILE_INFO_MESSAGE = "Auto transaction file was uploaded";
	
	public static String GET_AUTO_TRANSACTION_FILE_INFO_MESSAGE = "Retrieved auto transaction file";
	
	
	// auto transaction file upload error messages
	public static String CREATE_AUTO_TRANSACTION_UPLOADS_ERROR_MESSAGE = "Unable to create auto-transaction-uploads folder";
	
	public static String SAVE_AUTO_TRANSACTION_FILE_ERROR_MESSAGE = "Auto transaction file upload failed";
	
	public static String GET_AUTO_TRANSACTION_FILE_ERROR_MESSAGE = "Unable to retrieve auto transaction file. File does not exist";
	
	
	// general transaction file upload info messages 
	public static String CREATE_GENERAL_TRANSACTION_UPLOADS_INFO_MESSAGE = "Created general-transaction-uploads folder";
	
	public static String SAVE_GENERAL_TRANSACTION_FILE_INFO_MESSAGE = "general transaction file was uploaded";
	
	public static String GET_GENERAL_TRANSACTION_FILE_INFO_MESAGE = "Retrieved general transaction file";
	
	
	// general transaction file uplaod error messages
	public static String CREATE_GENERAL_TRANSACTION_UPLOADS_ERROR_MESSAGE = "Unable to create general-transaction-uploads folder";
	
	public static String SAVE_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE = "General transaction file upload failed";
	
	public static String GET_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE = "general transaction file cannot be retrieved";
	
	
	// medical transaction file upload info messages
	public static String CREATE_MEDICAL_TRANSACTION_UPLOADS_INFO_MESSAGE = "Created medical-transaction-uploads folder";
	
	public static String SAVE_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE = " medical transaction file was uploaded";
	
	public static String GET_MEDICAL_TRANSACTION_FILE_INFO_MESSAGE = "Retrieved medical transaction file";
	
	
	// medical transaction file upload error messages
	public static String CREATE_MEDICAL_TRANSACTION_UPLOADS_ERROR_MESSAGE = "Unable to create  medical-transaction-uploads folder";
	
	public static String SAVE_MEDICAL_TRANSACTION_FILE_ERROR_MESSAGE = " medical transaction file upload failed";
	
	public static String GET_MEDICAL_TRANSACTION_FILE_ERROR_MESSAGE = "Could not retrieve medical transaction file. Does not exist";
}