package com.deguzman.HomeInfoTracker.application_controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.HomeInfoTracker.application_models.DoctorOffice;
import com.deguzman.HomeInfoTracker.application_repository.DoctorOfficeRepository;
import com.deguzman.HomeInfoTracker.application_service.DoctorOfficeService;
import com.deguzman.HomeInfoTracker.exception.DoctorOfficeNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/doctor-offices")
public class DoctorOfficeController {
	
	@Autowired
	private DoctorOfficeService doctorOfficeService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<DoctorOffice> getAllDoctorOffices() throws SecurityException, IOException{
		return doctorOfficeService.getAllDoctorOffices();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("doctor-office/{doctorOfficeId}")
	public ResponseEntity<DoctorOffice> getDoctorOfficeById(@PathVariable Long doctorOfficeId) throws DoctorOfficeNotFoundException, SecurityException, IOException 
	{
		return doctorOfficeService.getDoctorOfficeById(doctorOfficeId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-doctor-office")
	public DoctorOffice addDoctorOffice(@Valid @RequestBody DoctorOffice doctorOffice) throws SecurityException, IOException
	{
		return doctorOfficeService.addDoctorOffice(doctorOffice);
	}
}
