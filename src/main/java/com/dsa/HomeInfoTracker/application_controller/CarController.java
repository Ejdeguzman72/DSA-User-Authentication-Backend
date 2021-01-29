package com.dsa.HomeInfoTracker.application_controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.HomeInfoTracker.application_models.Car;
import com.dsa.HomeInfoTracker.application_models.CarRecord;
import com.dsa.HomeInfoTracker.application_repository.CarRepository;
import com.dsa.HomeInfoTracker.application_service.CarService;
import com.dsa.HomeInfoTracker.exception.CarNotFoundException;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Car> getAllCars() throws SecurityException, IOException 
	{
		return carService.findAllCars();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car/{carid}")
	public ResponseEntity<Car> getCarById(@PathVariable Long carid) throws CarNotFoundException, SecurityException, IOException
	{
		return carService.getCarById(carid);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car/make/{make}")
	public ResponseEntity<List<Car>> getCarsByMake(@PathVariable String make) throws CarNotFoundException
	{
		return carService.getCarsByMake(make);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car/model/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) throws CarNotFoundException
	{
		return carService.getCarsByModel(model);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car/capacity/{capacity}")
	public ResponseEntity<List<Car>> getCarsByCapacity(@PathVariable int capacity) throws CarNotFoundException
	{
		return carService.getCarsByCapacity(capacity);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car/transmission/{transmission}")
	public ResponseEntity<List<Car>> getCarsByTransmission(@PathVariable String transmisson) throws CarNotFoundException
	{
		return carService.getCarsByTransmission(transmisson);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-car")
	public Car createCar(@Valid @RequestBody Car car) throws SecurityException, IOException 
	{
		return carService.createCar(car);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/car/{carid}")
	public ResponseEntity<Car> updateCarInformation(@PathVariable Long carid,
		@Valid @RequestBody Car carDetails) throws CarNotFoundException, SecurityException, IOException
	{
		return carService.updateCarInformation(carid, carDetails);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/car/{carid}")
	public Map<String, Boolean> deleteCar(@PathVariable Long carid) throws CarNotFoundException, SecurityException, IOException
	{
		return carService.deleteCar(carid);
	}
	
}
