package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.CarRecord;

public interface CarRecordServiceInterface {

	public List<CarRecord> getAllCarRecords();
	
	public ResponseEntity<CarRecord> getCarRecordById(@PathVariable Long carRecordId);
	
	public CarRecord addCarRecord(@Valid @RequestBody CarRecord carRecord);
	
	public ResponseEntity<CarRecord> updateCarRecord(@PathVariable Long carRecordId,
			@Valid @RequestBody CarRecord carRecordDetails);
	
	public Map<String,Boolean> deleteCarRecord(@PathVariable Long carRecordId);
}
