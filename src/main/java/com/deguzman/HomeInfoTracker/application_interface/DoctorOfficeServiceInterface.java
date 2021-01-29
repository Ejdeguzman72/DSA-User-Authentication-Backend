package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.DoctorOffice;

public interface DoctorOfficeServiceInterface {

	public List<DoctorOffice> getAllDoctorOffices();
	
	public ResponseEntity<DoctorOffice> getDoctorOfficeById(@PathVariable Long doctorOfficeId);
	
	public DoctorOffice addDoctorOffice(@Valid @RequestBody DoctorOffice doctorOffice);
	
	public ResponseEntity<DoctorOffice> updateDoctorOffice(@PathVariable Long doctorOfficeId,
			@Valid @RequestBody DoctorOffice doctorOfficeDetails);
	
	public Map<String,Boolean> deleteDoctorOffice(@PathVariable Long doctorOfficeId);
}
