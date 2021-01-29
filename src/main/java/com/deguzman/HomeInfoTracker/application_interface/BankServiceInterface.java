package com.deguzman.HomeInfoTracker.application_interface;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.Bank;
import com.deguzman.HomeInfoTracker.exception.BankNotFoundException;

public interface BankServiceInterface {

	public List<Bank> findAllBankInformation() throws SecurityException, IOException;
	
	public ResponseEntity<Bank> findBankById(@PathVariable Long bankid) throws BankNotFoundException, SecurityException, IOException;
	
	public Bank addBank(@Valid @RequestBody Bank bank) throws SecurityException, IOException;
	
	public ResponseEntity<Bank> updateBank(@PathVariable Long bankid,
			@Valid @RequestBody Bank updatedBank) throws SecurityException, IOException;
	
	public Map<String,Boolean> deleteBank(@PathVariable Long bankid) throws SecurityException, IOException;
}
