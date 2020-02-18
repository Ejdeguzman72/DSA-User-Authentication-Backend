package com.dsa.DeGuzmanServerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	
}
