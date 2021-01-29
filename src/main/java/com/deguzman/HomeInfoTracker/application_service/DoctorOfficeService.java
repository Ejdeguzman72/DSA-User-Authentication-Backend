package com.deguzman.HomeInfoTracker.application_service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.DoctorOffice;
import com.deguzman.HomeInfoTracker.application_repository.DoctorOfficeRepository;
import com.deguzman.HomeInfoTracker.exception.DoctorOfficeNotFoundException;
import com.deguzman.HomeInfoTracker.logger.MedicalLogger;
import com.deguzman.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.deguzman.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class DoctorOfficeService {

	@Autowired
	private DoctorOfficeRepository doctorOfficeRepository;
	
	public List<DoctorOffice> getAllDoctorOffices() throws SecurityException, IOException{
		
		MedicalLogger.medicalLogger.info(LoggerInfoMessage.GET_ALL_DOCTOR_OFFICE_INFO_MSG);
		return doctorOfficeRepository.findAll();
	}
	
	public ResponseEntity<DoctorOffice> getDoctorOfficeById(@PathVariable Long doctorOfficeId) throws DoctorOfficeNotFoundException, SecurityException, IOException
	{
		DoctorOffice doctorOffice = doctorOfficeRepository.findById(doctorOfficeId)
				.orElseThrow(() -> new DoctorOfficeNotFoundException("Doctor Office not found with ID: " + doctorOfficeId));
		
		if (doctorOfficeId != null)
		{
			MedicalLogger.medicalLogger.info(LoggerInfoMessage.GET_DOCTOR_OFFICE_INFO_BY_ID_MSG);			
		}
		else 
		{
			MedicalLogger.medicalLogger.info(LoggerErrorMessage.DOCTOR_OFFICE_ID_NULL_ERROR_MSG);
		}
		
		return ResponseEntity.ok().body(doctorOffice);
	}
	
	public DoctorOffice addDoctorOffice(@Valid @RequestBody DoctorOffice doctorOffice) throws SecurityException, IOException
	{
		// MedicalLogger.medicalLogger.log(LoggerInfoMessage.ADD_DOCTOR_OFFICE_INFO_MSG + doctorOffice);
		return doctorOfficeRepository.save(doctorOffice);
	}
}
