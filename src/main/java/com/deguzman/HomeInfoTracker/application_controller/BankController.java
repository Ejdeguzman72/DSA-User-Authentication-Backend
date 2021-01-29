package com.deguzman.HomeInfoTracker.application_controller;

import java.io.IOException;
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

import com.deguzman.HomeInfoTracker.application_models.Bank;
import com.deguzman.HomeInfoTracker.application_service.BankService;
import com.deguzman.HomeInfoTracker.exception.BankNotFoundException;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/app/banks")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@GetMapping("/all")
	public List<Bank> findAllBankInformation() throws SecurityException, IOException {
		return bankService.findAllBankInformation();
	}
	
	@GetMapping("/bank/{bankid}")
	public ResponseEntity<Bank> getBankById(@PathVariable Long bankid) throws BankNotFoundException, SecurityException, IOException
	{
		return bankService.findBankById(bankid);
	}
	
	
	@PostMapping("/add-a-bank")
	public Bank addBankInformation(@Valid @RequestBody Bank bank) throws SecurityException, IOException
	{
		return bankService.addBank(bank);
	}
	
	
	@PutMapping("/bank/{bankid}")
	public ResponseEntity<Bank> updateBank(@PathVariable Long bankid, @Valid @RequestBody Bank bankDetails) throws SecurityException, IOException
	{
		return bankService.updateBank(bankid, bankDetails);
	}
	
	
	@DeleteMapping("/bank/{bankid}")
	public Map<String, Boolean> deleteBank(@PathVariable Long bankid) throws SecurityException, IOException
	{
		return bankService.deleteBank(bankid);
	}
}
