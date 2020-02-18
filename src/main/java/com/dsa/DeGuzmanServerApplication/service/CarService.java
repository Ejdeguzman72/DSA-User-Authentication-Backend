package com.dsa.DeGuzmanServerApplication.service;

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

import com.dsa.DeGuzmanServerApplication.exception.CarNotFoundException;
import com.dsa.DeGuzmanServerApplication.exception.ResourceNotFoundException;
import com.dsa.DeGuzmanServerApplication.logger.AutomotiveLogger;
import com.dsa.DeGuzmanServerApplication.logger_message.LoggerErrorMessage;
import com.dsa.DeGuzmanServerApplication.logger_message.LoggerInfoMessage;
import com.dsa.DeGuzmanServerApplication.models.Car;
import com.dsa.DeGuzmanServerApplication.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	/**
	 * retrieves all from the database
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<Car> findAllCars() throws SecurityException, IOException
	{
		AutomotiveLogger.log(LoggerInfoMessage.GET_ALL_CAR_INFO_MSG);
		return carRepository.findAll();
	}
	
	/**
	 * passes carid as an argument
	 * retrieves the car information based on the carid passed
	 * @param carid
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Car> getCarById(@PathVariable Long carid) throws CarNotFoundException, SecurityException, IOException
	{
		Car car = carRepository.findById(carid)
				.orElseThrow(() -> new CarNotFoundException("Car not found with matching ID: " + carid));
		
		if (carid != null)
		{
			AutomotiveLogger.log(LoggerInfoMessage.GET_CAR_INFO_BY_ID_MSG);			
		}
		else 
		{
			AutomotiveLogger.log(LoggerErrorMessage.CAR_ID_NULL_ERROR_MSG);
		}
		
		return ResponseEntity.ok().body(car);
	}
	
	/**
	 * passes make as an argument
	 * retrieves related car information and is outputted into a list
	 * @param make
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<List<Car>> getCarsByMake(@PathVariable String make) throws CarNotFoundException
	{
		List<Car> car = carRepository.findCarsByMake(make);
		return ResponseEntity.ok().body(car);
	}
	
	/**
	 * model is passed as an argument
	 * Cars are retrieved by models and collected into a list
	 * @param model
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) throws CarNotFoundException
	{
		List<Car> car = carRepository.findCarsByModel(model);
		return ResponseEntity.ok().body(car);
	}
	
	/**
	 * capacity is passed as an argument
	 * cars are retrieved with the corresponding capacity and collected into a list
	 * @param capacity
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<List<Car>> getCarsByCapacity(@PathVariable int capacity) throws CarNotFoundException
	{
		List<Car> car = carRepository.findCarsByCapacity(capacity);
		return ResponseEntity.ok().body(car);
	}

	/**
	 * transmission is passed a an argument
	 * cars are retrieved by the passed argument and collected into a list
	 * @param transmisson
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<List<Car>> getCarsByTransmission(@PathVariable String transmisson) throws CarNotFoundException
	{
		List<Car> car = carRepository.findCarsByTransmission(transmisson);
		return ResponseEntity.ok().body(car);
	}
	
	/**
	 * takes the inputs and saves the information as a new car
	 * @param car
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Car createCar(@Valid @RequestBody Car car) throws SecurityException, IOException 
	{
		AutomotiveLogger.log(LoggerInfoMessage.ADD_CAR_INFO_MSG + car);
		return carRepository.save(car);
	}

	/**
	 * updates car information based on carid
	 * @param carid
	 * @param carDetails
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Car> updateCarInformation(@PathVariable Long carid,
			@Valid @RequestBody Car carDetails) throws CarNotFoundException, SecurityException, IOException
		{
			Car car = null;
			try {
				car = carRepository.findById(carid)
						.orElseThrow(() -> new ResourceNotFoundException("Cannnot find car wit id of " + carid));
				
				if (carid != null)
				{
					AutomotiveLogger.log(LoggerInfoMessage.UPDATE_CAR_INFO_MSG + carid);					
				}
				else
				{
					AutomotiveLogger.log(LoggerErrorMessage.CAR_ID_NULL_ERROR_MSG);
				}
				
				car.setAc(carDetails.getAc());
				car.setCapacity(carDetails.getCapacity());
				car.setMake(carDetails.getMake());
				car.setModel(carDetails.getModel());
				car.setTransmission(carDetails.getTransmission());
				car.setYear(carDetails.getYear());
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final Car updatedCar = carRepository.save(car);
			return ResponseEntity.ok(updatedCar);
		}
	
	/**
	 * deletes car information based on the carid passed
	 * @param carid
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Map<String, Boolean> deleteCar(@PathVariable Long carid) throws CarNotFoundException, SecurityException, IOException
	{
		carRepository.deleteById(carid);
		
		if (carid != null)
		{
			AutomotiveLogger.log(LoggerInfoMessage.UPDATE_CAR_INFO_MSG + carid);			
		}
		else 
		{
			AutomotiveLogger.log(LoggerErrorMessage.CAR_ID_NULL_ERROR_MSG);
		}
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
