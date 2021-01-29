package com.dsa.HomeInfoTracker.application_service;

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

import com.dsa.HomeInfoTracker.application_models.Transaction;
import com.dsa.HomeInfoTracker.application_repository.TransactionRepository;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.exception.TransactionNotFoundException;
import com.dsa.HomeInfoTracker.logger.FinancialLogger;
import com.dsa.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.dsa.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	/**
	 * retrieve all transactions listed in the database
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<Transaction> getAllTransactions() throws SecurityException, IOException {
		FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_ALL_TRANSACTION_INFO_MSG);
		return transactionRepository.findAll();
	}
	
	/**
	 * passes transactionid as an argument
	 * retrieves transaction based on the transactionid that is passed
	 * @param transactionid
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionid) throws TransactionNotFoundException, SecurityException, IOException
	{
		if (transactionid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_TRANSACTION_INFO_BY_ID_MSG);			
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.TRANSACTION_ID_NULL_ERROR_MSG);
		}
		
		Transaction transaction = transactionRepository.findById(transactionid)
				.orElseThrow(() -> new TransactionNotFoundException("Transaction not found with ID: " + transactionid));
		return ResponseEntity.ok().body(transaction);
	}
	
	/**
	 * passes recipient as an argument
	 * returns the list of tranasctions that correspond to the recipient passed
	 * @param recipient
	 * @return
	 */
	public ResponseEntity<List<Transaction>> getTransactionByRecipient(@PathVariable String recipient) throws TransactionNotFoundException
	{
		List<Transaction> transaction = transactionRepository.findTransactionByRecipient(recipient);
		return ResponseEntity.ok().body(transaction);
	}
	
	public ResponseEntity<List<Transaction>> getTransactionByAmount(@PathVariable double amount)
	{
		List<Transaction> transaction = transactionRepository.findTransactionByAmount(amount);
		return ResponseEntity.ok().body(transaction);
	}
	
	public ResponseEntity<List<Transaction>> getTransactionByAmountGreaterThanOrEqualTo(@PathVariable double amount) throws TransactionNotFoundException
	{
		List<Transaction> transaction = transactionRepository.findTransactionsByAmountGreaterThanOrEqualTo(amount);
		return ResponseEntity.ok().body(transaction);
	}
	
	/**
	 * passes amount as an argument
	 * retrieves the list of amounts that are less than or equal to the amount given
	 * @param amount
	 * @return
	 */
	public ResponseEntity<List<Transaction>> getTransactionByAmountLessThanOrEqualTo(@PathVariable double amount) throws TransactionNotFoundException
	{
		List<Transaction> transaction = transactionRepository.findTransactionsByAmountLessThanOrEqualTo(amount);
		return ResponseEntity.ok().body(transaction);
	}

	/**
	 * passes transaction date as an argument
	 * retrieves the list of transactions that have the same date
	 * @param transactionDate
	 * @return
	 */
	public ResponseEntity<List<Transaction>> getTransactionByTransactionDate(@PathVariable String transactionDate) throws TransactionNotFoundException
	{
		List<Transaction> transaction = transactionRepository.findTransactionByDate(transactionDate);
		return ResponseEntity.ok().body(transaction);
	}
	
	/**
	 * takes tranasctionType as an argument 
	 * retrieves list of the transactions based on the type that was passed 
	 * @param transactionType
	 * @return
	 */
	public ResponseEntity<List<Transaction>> getTransactionByTransactionType(@PathVariable int transactionType) throws TransactionNotFoundException
	{
		List<Transaction> transaction = transactionRepository.findTransactionByType(transactionType);
		return ResponseEntity.ok().body(transaction);
	}
	
	/**
	 * user fills out required fields and submits them
	 * new tranasction is created after filling out the required fields
	 * @param transaction
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) throws SecurityException, IOException 
	{
		// FinancialLogger.financialLogger.info(LoggerInfoMessage.ADD_TRANSACTION_INFO_MSG + transaction);
		return transactionRepository.save(transaction);
	}
	
	/**
	 * updates the transation based on the id that is being passed
	 * @param transactionid
	 * @param transactionDetails
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionid, @Valid @RequestBody Transaction transactionDetails) throws TransactionNotFoundException, SecurityException, IOException 
	{
		
		Transaction transaction = transactionRepository.findById(transactionid)
			.orElseThrow(() -> new TransactionNotFoundException("No transaction with the matching id"));
		
		transaction.setAmount(transactionDetails.getAmount());
		transaction.setRecipient(transactionDetails.getRecipient());
		transaction.setTransactionDate(transactionDetails.getTransactionDate());
		transaction.setTransactionType(transactionDetails.getTransactionType());
		final Transaction updatedTransaction = transactionRepository.save(transaction);
		
		if (transactionid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.UPDATE_TRANSACTION_INFO_MSG + transactionid);			
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.TRANSACTION_ID_NULL_ERROR_MSG);
		}
		
		return ResponseEntity.ok(updatedTransaction);
	}
	
	/**
	 * passes transactionid as an argyment
	 * deletes a tranasction based on the id
	 * @param transactionid
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Map<String, Boolean> deleteTransaction(@PathVariable Long transactionid) throws ResourceNotFoundException, SecurityException, IOException 
	{
		if (transactionid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.DELETE_TRANASACTION_INFO_MSG + transactionid);			
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.TRANSACTION_ID_NULL_ERROR_MSG);
		}
		Transaction transaction = transactionRepository.findById(transactionid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find transaction of that id"));
		transactionRepository.delete(transaction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
