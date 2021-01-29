package com.deguzman.HomeInfoTracker.application_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.HomeInfoTracker.application_models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	
}
