package com.dsa.DeGuzmanServerApplication.controller;

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

import com.dsa.DeGuzmanServerApplication.repository.CardRepository;
import com.dsa.DeGuzmanServerApplication.service.CardService;
import com.dsa.DeGuzmanServerApplication.exception.CardNotFoundException;
import com.dsa.DeGuzmanServerApplication.exception.ResourceNotFoundException;
import com.dsa.DeGuzmanServerApplication.models.Card;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Card> getAllCardInformation() throws SecurityException, IOException {
		return cardService.getAllCardInformation();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/card/{cardid}")
	public ResponseEntity<Card> getCardById(@PathVariable Long cardid) throws CardNotFoundException, SecurityException, IOException
	{
		return cardService.getCardById(cardid);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/card/cardType/{cardTypeId")
	public ResponseEntity<List<Card>> getCardByCardType(@PathVariable Long cardTypeId) throws ResourceNotFoundException, CardNotFoundException
	{
		return cardService.getCardByCardType(cardTypeId);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/card/bank/{bankId}")
	public ResponseEntity<List<Card>> getCardByBankId(@PathVariable Long bankId) throws CardNotFoundException
	{
		return cardService.getCardByBankId(bankId);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/card/name/{name}")
	public ResponseEntity<List<Card>> getCardByName(@PathVariable String name) throws CardNotFoundException
	{
		return cardService.getCardByName(name);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/card/cardNumber/{cardNumber}")
	public ResponseEntity<Card> getCardByCardNumber(@PathVariable String cardNumber) throws CardNotFoundException
	{
		return cardService.getCardByCardNumber(cardNumber);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-card")
	public Card addCardInformation(@Valid @RequestBody Card card) throws SecurityException, IOException
	{
		return cardService.addCardInformation(card);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/card/{cardid}")
	public ResponseEntity<Card> updateCardInformation(@PathVariable Long cardid,
			@Valid @RequestBody Card cardDetails) throws SecurityException, IOException
	{
		return cardService.updateCardInformation(cardid, cardDetails);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/card/{cardid}")
	public Map<String, Boolean> deleteCard(@PathVariable Long cardid) throws SecurityException, IOException 
	{
		return cardService.deleteCard(cardid);
	}
}
