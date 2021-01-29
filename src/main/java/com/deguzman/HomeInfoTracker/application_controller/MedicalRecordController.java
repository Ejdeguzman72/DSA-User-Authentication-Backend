package com.deguzman.HomeInfoTracker.application_controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

import com.deguzman.HomeInfoTracker.application_models.MedicalRecord;
import com.deguzman.HomeInfoTracker.application_repository.MedicalRecordRepository;
import com.deguzman.HomeInfoTracker.application_service.MedicalRecordService;
import com.deguzman.HomeInfoTracker.exception.MedicalRecordNotFoundException;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/medical-records")
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<MedicalRecord> getAllMedicalRecord() throws SecurityException, IOException 
	{
		return medicalRecordService.getAllMedicalRecordInformation();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/medical-record/{medicalRecordId}")
	public ResponseEntity<MedicalRecord> getMedicalRecordInformationById(@PathVariable Long medicalRecordId) throws MedicalRecordNotFoundException, SecurityException, IOException 
	{
		return medicalRecordService.getMedicalRecordById(medicalRecordId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-medical-record")
	public MedicalRecord createMedicalRecord(@Valid @RequestBody MedicalRecord medicalRecord) throws SecurityException, IOException
	{
		return medicalRecordService.addMedicalRecordInformation(medicalRecord);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/medical-record/{medicalRecordId}")
	public ResponseEntity<MedicalRecord> updateMedicalRecordInformation(@PathVariable Long medicalRecordId,
			@Valid @RequestBody MedicalRecord medicalRecordDetails) throws MedicalRecordNotFoundException, SecurityException, IOException
	{
		return medicalRecordService.updateMedicalRecordInformation(medicalRecordId, medicalRecordDetails);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/medicalRecord/{medicalRecordId}")
	public Map<String, Boolean> deleteMedicalRecordInformation(@PathVariable Long medicalRecordId) throws MedicalRecordNotFoundException, SecurityException, IOException
	{
		return medicalRecordService.deleteMedicalRecord(medicalRecordId);
	}
}
