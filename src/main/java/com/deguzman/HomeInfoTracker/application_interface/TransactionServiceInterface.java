package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.Transaction;

public interface TransactionServiceInterface {

	public List<Transaction> getAllTransactions();
	
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId);
	
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction);
	
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionId,
			@Valid @RequestBody Transaction transactionDetails);
	
	public Map<String,Boolean> deleteTransaction(@PathVariable Long transactionId);
}
