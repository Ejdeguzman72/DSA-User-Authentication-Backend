package com.dsa.DeGuzmanServerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	@Query(value = "SELECT * FROM card_tbl WHERE cardTypeId = ?1",nativeQuery=true)
	List<Card> findCardInformationByCardTypeId(Long cardTypeId);
	
	@Query(value = "SELECT * FROM card_tbl WHERE bankId = ?1",nativeQuery=true)
	List<Card> findCardInformationByBankId(Long bankId);
	
	@Query(value = "SELECT * FROM card_tbl WHERE name = ?1",nativeQuery=true)
	List<Card> findCardInformationByName(String name);
	
	@Query(value = "SELECT * FROM card_tbl WHERE cardNumber = ?1",nativeQuery=true)
	Card findCardInformationByCardNumber(String cardNumber);
}

