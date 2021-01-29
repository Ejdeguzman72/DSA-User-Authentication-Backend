package com.dsa.HomeInfoTracker.application_controller;

import java.io.IOException;
import java.util.HashMap;
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

import com.dsa.HomeInfoTracker.application_models.Transaction;
import com.dsa.HomeInfoTracker.application_repository.TransactionRepository;
import com.dsa.HomeInfoTracker.application_service.TransactionService;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.exception.TransactionNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/transactions")
public class TransactionController {  
	
	@Autowired
	private TransactionService transactionService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Transaction> getAllTransactions() throws SecurityException, IOException {
		return transactionService.getAllTransactions();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/transaction/{transactionid}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionid) throws TransactionNotFoundException, SecurityException, IOException
	{
		return transactionService.getTransactionById(transactionid);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/tranasction/recipient/{recipient}")
	public ResponseEntity<List<Transaction>> getTransactionByRecipient(@PathVariable String recipient) throws TransactionNotFoundException
	{
		return transactionService.getTransactionByRecipient(recipient);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/transaction/amount/{amount}")
	public ResponseEntity<List<Transaction>> getTransactionByAmount(@PathVariable double amount)
	{
		return transactionService.getTransactionByAmount(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("transaction/greater-than-or-equal-amount/{amount}")
	public ResponseEntity<List<Transaction>> getTransactionByAmountGreaterThanOrEqualTo(@PathVariable double amount) throws TransactionNotFoundException
	{
		return transactionService.getTransactionByAmountGreaterThanOrEqualTo(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/transaction/less-than-or-equal-amount/{amount}")
	public ResponseEntity<List<Transaction>> getTransactionByAmountLessThanOrEqualTo(@PathVariable double amount) throws TransactionNotFoundException
	{
		return transactionService.getTransactionByAmountLessThanOrEqualTo(amount);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/transaction/transaction-date/{transactionDate}")
	public ResponseEntity<List<Transaction>> getTransactionByTransactionDate(@PathVariable String transactionDate) throws TransactionNotFoundException
	{
		return transactionService.getTransactionByTransactionDate(transactionDate);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/transactions/transaction-type/{transactionType}")
	public ResponseEntity<List<Transaction>> getTransactionByTransactionType(@PathVariable int transactionType) throws TransactionNotFoundException
	{
		return transactionService.getTransactionByTransactionType(transactionType);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-transactions")
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) throws SecurityException, IOException 
	{
		return transactionService.createTransaction(transaction);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/transaction/{transactionid}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionid, @Valid @RequestBody Transaction transactionDetails) throws TransactionNotFoundException, SecurityException, IOException 
	{
		return transactionService.updateTransaction(transactionid, transactionDetails);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("transaction/{transactionid}")
	public Map<String, Boolean> deleteTransaction(@PathVariable Long transactionid) throws ResourceNotFoundException, SecurityException, IOException 
	{
		return transactionService.deleteTransaction(transactionid);
	}
}	