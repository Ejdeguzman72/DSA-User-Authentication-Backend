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

import com.dsa.DeGuzmanServerApplication.exception.MedicalRecordNotFoundException;
import com.dsa.DeGuzmanServerApplication.exception.ResourceNotFoundException;
import com.dsa.DeGuzmanServerApplication.logger.MedicalLogger;
import com.dsa.DeGuzmanServerApplication.logger_message.LoggerErrorMessage;
import com.dsa.DeGuzmanServerApplication.logger_message.LoggerInfoMessage;
import com.dsa.DeGuzmanServerApplication.models.Card;
import com.dsa.DeGuzmanServerApplication.models.MedicalRecord;
import com.dsa.DeGuzmanServerApplication.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public List<MedicalRecord> getAllMedicalRecordInformation() throws SecurityException, IOException {
		
		MedicalLogger.log(LoggerInfoMessage.GET_ALL_MEDICAL_RECORD_INFO_MSG);
		return medicalRecordRepository.findAll();
	}
	
	public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long medicalRecordId) throws MedicalRecordNotFoundException, SecurityException, IOException
	{
		MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId)
				.orElseThrow(() -> new MedicalRecordNotFoundException("Medical Record not found with ID: " + medicalRecordId));
		
		if (medicalRecordId != null)
		{
			MedicalLogger.log(LoggerInfoMessage.GET_MEDICAL_RECORD_INFO_BY_ID_MSG);			
		}
		else 
		{
			MedicalLogger.log(LoggerErrorMessage.MEDICAL_RECORD_ID_NULL_ERROR_MSG);
		}
		return ResponseEntity.ok().body(medicalRecord);
	}
	
	public MedicalRecord addMedicalRecordInformation(@Valid @RequestBody MedicalRecord medicalRecord) throws SecurityException, IOException
	{
		MedicalLogger.log(LoggerInfoMessage.ADD_MEDICAL_RECORD_INFO_MSG + medicalRecord);
		return medicalRecordRepository.save(medicalRecord);
	}
	
	public ResponseEntity<MedicalRecord> updateMedicalRecordInformation(@PathVariable Long medicalRecordId,
			@Valid @RequestBody MedicalRecord medicalRecordDetails) throws MedicalRecordNotFoundException, SecurityException, IOException
	{
		MedicalRecord medicalRecord = null;
		try 
		{
			if (medicalRecordId != null)
			{
				MedicalLogger.log(LoggerInfoMessage.UPDATE_MEDICAL_RECORD_INFO_MSG + medicalRecordId);				
			}
			else 
			{
				MedicalLogger.log(LoggerErrorMessage.MEDICAL_RECORD_ID_NULL_ERROR_MSG);
			}
			medicalRecord = medicalRecordRepository.findById(medicalRecordId)
					.orElseThrow(() -> new MedicalRecordNotFoundException("Cannot find"));
			medicalRecord.setAmount(medicalRecordDetails.getAmount());
			medicalRecord.setDescription(medicalRecordDetails.getDescription());
			medicalRecord.setDoctorName(medicalRecordDetails.getDoctorName());
			medicalRecord.setDoctorOfficeId(medicalRecordDetails.getDoctorOfficeId());
			medicalRecord.setPersonid(medicalRecordDetails.getPersonid());
		}
		catch (MedicalRecordNotFoundException e)
		{
			e.printStackTrace();
		}
		final MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);
		
		return ResponseEntity.ok(updatedMedicalRecord);
	}
	
	public Map<String, Boolean> deleteMedicalRecord(@PathVariable Long medicalRecordId) throws SecurityException, IOException
	{
		if (medicalRecordId != null)
		{
			MedicalLogger.log(LoggerInfoMessage.DELETE_MEDICAL_RECORD_INFO_MSG + medicalRecordId);			
		}
		else 
		{
			MedicalLogger.log(LoggerErrorMessage.MEDICAL_RECORD_ID_NULL_ERROR_MSG);
		}
		
		medicalRecordRepository.deleteById(medicalRecordId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
