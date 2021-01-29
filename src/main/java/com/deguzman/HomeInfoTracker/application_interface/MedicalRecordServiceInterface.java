package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.MedicalRecord;

public interface MedicalRecordServiceInterface {

	public List<MedicalRecord> getAllMedicalRecords();
	
	public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long medicalRecordId);
	
	public MedicalRecord addMedicalRecord(@Valid @RequestBody MedicalRecord medicalRecord);
	
	public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long medicalRecordId,
			@Valid @RequestBody MedicalRecord medicalRecordDetails);
	
	public Map<String,Boolean> deleteMedicalRecord(@PathVariable Long medicalRecordId);
}
