package com.dsa.DeGuzmanServerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "SELECT * FROM transaction_tbl WHERE recipient = ?1", nativeQuery=true)
	List<Transaction> findTransactionByRecipient(String recipient);
	
	@Query(value = "SELECT * FROM transaction_tbl WHERE amount = ?1", nativeQuery=true)
	List<Transaction> findTransactionByAmount(double amount);
	
	@Query(value = "SELECT * FROM transaction_tbl WHERE amount >= ?!",nativeQuery=true)
	List<Transaction> findTransactionsByAmountGreaterThanOrEqualTo(double amount);
	
	@Query(value ="SELECT * FROM transcation_tbl WHERE amount <= ?1",nativeQuery=true)
	List<Transaction> findTransactionsByAmountLessThanOrEqualTo(double amount);
	
	@Query(value = "SELECT * FROM transaction_tbl WHERE transaction_date = ?1",nativeQuery=true)
	List<Transaction> findTransactionByDate(String transactionDate);
	
	@Query(value = "SELECT * FROM transaction_tbl WHERE transaction_type = ?1", nativeQuery=true)
	List<Transaction> findTransactionByType(int transactionType);
}
