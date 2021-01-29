package com.dsa.HomeInfoTracker.application_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsa.HomeInfoTracker.application_models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	
}
