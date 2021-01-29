package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.Car;

public interface CarServiceInterface {

	public List<Car> getAllCars();
	
	public ResponseEntity<Car> getCarById(@PathVariable Long carId);
	
	public Car addCar(@Valid @RequestBody Car car);
	
	public ResponseEntity<Car> updateCar(@PathVariable Long carId,
			@Valid @RequestBody Car carDetails);
	
	public Map<String,Boolean> deleteCar(@PathVariable Long carId);
}
