package com.dsa.HomeInfoTracker.application_service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dsa.HomeInfoTracker.application_interface.BankServiceInterface;
import com.dsa.HomeInfoTracker.application_models.Bank;
import com.dsa.HomeInfoTracker.application_repository.BankRepository;
import com.dsa.HomeInfoTracker.exception.BankNotFoundException;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.formatter.BankFormatter;
import com.dsa.HomeInfoTracker.logger.FinancialLogger;
import com.dsa.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.dsa.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class BankService implements BankServiceInterface {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private BankFormatter bankFormatter;
	
	public List<Bank> findAllBankInformation() throws SecurityException, IOException {
		
		FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_ALL_BANK_INFO_MSG);
		return bankRepository.findAll();
	}
	
	public ResponseEntity<Bank> findBankById(@PathVariable Long bankid) throws BankNotFoundException, SecurityException, IOException
	{
		Bank bank = bankRepository.findById(bankid)
				.orElseThrow(() -> new BankNotFoundException("Bank not found with ID:" + bankid));
		
		if (bankid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_BANK_INFO_BY_ID_MSG + bankid);			
		}
		
		else
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.BANK_ID_NULL_ERROR_MSG);
		}
		return ResponseEntity.ok().body(bank);
	}
	
	public Bank addBank(@Valid @RequestBody Bank bank) 
	{
//		FinancialLogger.log(LoggerInfoMessage.ADD_BANK_INFO_MSG + bank.getName());
		
		String bankAddress = bank.getAddress();
		System.out.println(bankAddress);
		bankAddress = bankFormatter.formatAddress(bankAddress);
		
		String bankCity = bank.getCity();
		bankCity = bankFormatter.formatCity(bankCity);
		
		String bankName = bank.getName();
		bankName = bankFormatter.formatName(bankName);
		
		String bankState = bank.getState();
		bankState = bankFormatter.formatState(bankState);
		
		return bankRepository.save(bank);
	}
	
	public ResponseEntity<Bank> updateBank(@PathVariable Long bankid, @Valid @RequestBody Bank bankDetails) throws SecurityException, IOException
	{
		Bank bank = null;
		try 
		{
			bank = bankRepository.findById(bankid)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
			bank.setAddress(bankDetails.getAddress());
			bank.setCity(bankDetails.getCity());
			bank.setName(bankDetails.getName());
			bank.setState(bankDetails.getState());
			bank.setZip(bankDetails.getZip());
			
			if (bankid != null) 
			{
				FinancialLogger.financialLogger.info(LoggerInfoMessage.UPDATE_BANK_INFO_MSG + bankid);				
			}
			else 
			{
				FinancialLogger.financialLogger.info(LoggerErrorMessage.BANK_ID_NULL_ERROR_MSG);
			}
		}
		
		catch (ResourceNotFoundException e)
		{
			e.printStackTrace();
		}
		
		final Bank updatedBank = bankRepository.save(bank);
		return ResponseEntity.ok(updatedBank);
	}
	
	public Map<String, Boolean> deleteBank(@PathVariable Long bankid) throws SecurityException, IOException
	{
		bankRepository.deleteById(bankid);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		if (bankid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.DELETE_BANK_INFO_MSG + bankid);	
		}
		else
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.BANK_ID_NULL_ERROR_MSG);
		}
		return response;
	}
}
