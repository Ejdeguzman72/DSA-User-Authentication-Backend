package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.Card;

public interface CardServiceInterface {

	public List<Card> getAllCardInformation();
	
	public ResponseEntity<Card> getCardById(@PathVariable long cardid);
	
	public Card addCardInformation(@Valid @RequestBody Card card);
	
	public ResponseEntity<Card> updateCardInformation(@PathVariable Long cardid, @Valid @RequestBody Card cardDetails);
	
	public Map<String,Boolean> deleteCard(@PathVariable Long cardid);
	
}
