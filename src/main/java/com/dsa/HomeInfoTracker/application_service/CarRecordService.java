package com.dsa.HomeInfoTracker.application_service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dsa.HomeInfoTracker.application_models.CarRecord;
import com.dsa.HomeInfoTracker.application_repository.CarRecordRepository;
import com.dsa.HomeInfoTracker.exception.CarRecordNotFoundException;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.logger.AutomotiveLogger;
import com.dsa.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.dsa.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class CarRecordService {

	@Autowired
	private CarRecordRepository carRecordRepository;
	
	/**
	 * retrieves all car record information 
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<CarRecord> getAllCarRecords() throws SecurityException, IOException 
	{
		AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.GET_ALL_CAR_RECORD_INFO_MSG);
		return carRecordRepository.findAll();
	}

	/**
	 * passes the carRecordId as an argument
	 * retrieves the car record based on the id that is passed
	 * @param carRecordId
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<CarRecord> getCarRecordById(@PathVariable Long carRecordId) throws CarRecordNotFoundException, SecurityException, IOException
	{
		CarRecord carRecord = carRecordRepository.findById(carRecordId)
				.orElseThrow(() -> new CarRecordNotFoundException("Car Record not found with matching ID: " + carRecordId));
		
		if (carRecordId != null)
		{
			AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.GET_ALL_CAR_RECORD_INFO_MSG + carRecordId);			
		}
		else 
		{
			AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.CAR_RECORD_ID_NULL_ERROR_MSG);
		}
		
		return ResponseEntity.ok().body(carRecord);
	}

	/**
	 * passes amount as a parameter
	 * retrieves the car record that has the same amount as the one passed 
	 * @param amount
	 * @return
	 */
	public ResponseEntity<List<CarRecord>> getCarRecordByAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		List<CarRecord> carRecord = carRecordRepository.findCarRecordByAmount(amount);
		return ResponseEntity.ok().body(carRecord);
	}

	/**
	 * passes amount as an argument
	 * retrieves the list of car records that are greater than or equal the same as the amount passed
	 * @param amount
	 * @return
	 */
	public ResponseEntity<List<CarRecord>> getCarRecordByGreaterThanOrEqualAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		List<CarRecord> carRecord = carRecordRepository.findCarRecordByAmount(amount);
		return ResponseEntity.ok().body(carRecord);
	}

	/**
	 * passes amount as an argument
	 * retrieves the list of car records that have an amount less than or equal to the amount passed
	 * @param amount
	 * @return
	 */
	public ResponseEntity<List<CarRecord>> getCarRecordBLessThanOrEqualyAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		List<CarRecord> carRecord = carRecordRepository.findCarRecordByAmount(amount);
		return ResponseEntity.ok().body(carRecord);
	}

	/**
	 * passes repairShopId as an argument
	 * retrieves the car record information that have the same repair shop id
	 * records are collected into a list
	 * @param repairShopId
	 * @return
	 */
	public ResponseEntity<List<CarRecord>> getCarRecordByRepairShopId(@PathVariable Long repairShopId) 
	{
		List<CarRecord> carRecord = carRecordRepository.findCarRecordByRepairShopId(repairShopId);
		return ResponseEntity.ok().body(carRecord);
	}

	/**
	 * passes carJobId as an argument
	 * retrieves the car record information that have the same car job id
	 * 
	 * @param carJobId
	 * @return
	 */
	public ResponseEntity<List<CarRecord>> getCarRecordByCarJobId(@PathVariable Long carJobId) throws CarRecordNotFoundException
	{
		List<CarRecord> carRecord = carRecordRepository.findCarRecordByCarJobId(carJobId);
		return ResponseEntity.ok().body(carRecord);
	}
	
	/**
	 * information is filled out for the fields 
	 * information is then used to create a new car record
	 * @param carRecord
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public CarRecord addCarRecord(@Valid @RequestBody CarRecord carRecord) throws SecurityException, IOException 
	{
		// AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.ADD_CAR_RECORD_INFO_MSG + carRecord);
		return carRecordRepository.save(carRecord);
	}

	/**
	 * updates the car record based on the id that is passed
	 * @param carRecordId
	 * @param carRecordDetails
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<CarRecord> updateCarRecord(@PathVariable Long carRecordId,
			@Valid @RequestBody CarRecord carRecordDetails) throws CarRecordNotFoundException, SecurityException, IOException
	{
		CarRecord carRecord = null;
		try {
			carRecord = carRecordRepository.findById(carRecordId)
					.orElseThrow(() -> new CarRecordNotFoundException("not found"));
			
			if (carRecordId != null)
			{
				AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.UPDATE_CAR_RECORD_INFO_MSG + carRecordId);
			}
			else 
			{
				AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.CAR_RECORD_ID_NULL_ERROR_MSG);
			}
			carRecord.setAmount(carRecordDetails.getAmount());
			carRecord.setCarJobId(carRecordDetails.getCarJobId());
			carRecord.setRepairShopId(carRecordDetails.getRepairShopId());
		} catch (CarRecordNotFoundException e) {
			e.printStackTrace();
		}
		final CarRecord updatedCarRecord = carRecordRepository.save(carRecord);
		return ResponseEntity.ok(updatedCarRecord);
	}
	
	/**
	 * deletes the car record based on the id that is passed
	 * @param carRecordId
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Map<String, Boolean> deleteCarRecord(@PathVariable Long carRecordId) throws CarRecordNotFoundException, SecurityException, IOException
	{
		carRecordRepository.deleteById(carRecordId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		if (carRecordId != null)
		{
			AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.DELETE_CAR_RECORD_INFO_MSG + carRecordId);			
		}
		else 
		{
			AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.CAR_RECORD_ID_NULL_ERROR_MSG);
		}
		return response;
	}
}
