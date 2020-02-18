package com.dsa.DeGuzmanServerApplication.controller;

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

import com.dsa.DeGuzmanServerApplication.repository.CarRecordRepository;
import com.dsa.DeGuzmanServerApplication.service.CarRecordService;
import com.dsa.DeGuzmanServerApplication.exception.CarRecordNotFoundException;
import com.dsa.DeGuzmanServerApplication.exception.ResourceNotFoundException;
import com.dsa.DeGuzmanServerApplication.models.CarRecord;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/car-records")
public class CarRecordController {

	private CarRecordRepository carRecordRepository;
	
	@Autowired
	private CarRecordService carRecordService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<CarRecord> getAllCarRecords() throws SecurityException, IOException 
	{
		return  carRecordService.getAllCarRecords();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/{carRecordId}")
	public ResponseEntity<CarRecord> getCarRecordById(@PathVariable Long carRecordId) throws CarRecordNotFoundException, SecurityException, IOException
	{
		return carRecordService.getCarRecordById(carRecordId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/amount/{amount}")
	public ResponseEntity<List<CarRecord>> getCarRecordByAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		return carRecordService.getCarRecordByAmount(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/greater-than-or-equal-amount/{amount}")
	public ResponseEntity<List<CarRecord>> getCarRecordByGreaterThanOrEqualAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		return carRecordService.getCarRecordByGreaterThanOrEqualAmount(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/less-than-or-equal-amount/{amount}")
	public ResponseEntity<List<CarRecord>> getCarRecordBLessThanOrEqualyAmount(@PathVariable double amount) throws CarRecordNotFoundException
	{
		return carRecordService.getCarRecordBLessThanOrEqualyAmount(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/repairShop/{repairShopId}")
	public ResponseEntity<List<CarRecord>> getCarRecordByRepairShopId(@PathVariable Long repairShopId) 
	{
		return carRecordService.getCarRecordByRepairShopId(repairShopId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/car-record/carjob/{carJobId}")
	public ResponseEntity<List<CarRecord>> getCarRecordByCarJobId(@PathVariable Long carJobId) throws CarRecordNotFoundException
	{
		return carRecordService.getCarRecordByCarJobId(carJobId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-record")
	public CarRecord addCarRecord(@Valid @RequestBody CarRecord carRecord) throws SecurityException, IOException 
	{
		return carRecordService.addCarRecord(carRecord);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/car-record/{carRecordId}")
	public ResponseEntity<CarRecord> updateCarRecord(@PathVariable Long carRecordId,
			@Valid @RequestBody CarRecord carRecordDetails) throws CarRecordNotFoundException, SecurityException, IOException
	{
		return carRecordService.updateCarRecord(carRecordId, carRecordDetails);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/car-record/{carRecordId}")
	public Map<String, Boolean> deleteCarRecord(@PathVariable Long carRecordId) throws CarRecordNotFoundException, SecurityException, IOException
	{
		return carRecordService.deleteCarRecord(carRecordId);
	}
}
