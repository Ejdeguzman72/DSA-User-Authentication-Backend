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

import com.dsa.HomeInfoTracker.application_models.Card;
import com.dsa.HomeInfoTracker.application_repository.CardRepository;
import com.dsa.HomeInfoTracker.exception.CardNotFoundException;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.logger.FinancialLogger;
import com.dsa.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.dsa.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	/**
	 * returns all card information in a list
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<Card> getAllCardInformation() throws SecurityException, IOException {
		FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_ALL_CARD_INFO_MSG);
		return cardRepository.findAll();
	}

	/**
	 * passes cardid as an argument 
	 * retrueves the card information related to the cardid
	 * @param cardid
	 * @return
	 * @throws CardNotFoundException 
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Card> getCardById(@PathVariable Long cardid) throws CardNotFoundException, SecurityException, IOException
	{
		Card card = cardRepository.findById(cardid)
				.orElseThrow(() -> new CardNotFoundException("Card not found with matching ID: " + cardid));
		
		if (cardid != null)
		{			
			FinancialLogger.financialLogger.info(LoggerInfoMessage.GET_CARD_INFO_BY_ID_MSG + cardid);
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.CARD_ID_NULL_ERROR_MSG);
		}
		return ResponseEntity.ok().body(card);
	}
	
	/**
	 * passes cardTypeId as an argument
	 * retrieves the card information that are related to the card type id
	 * @param cardTypeId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws CardNotFoundException 
	 */
	public ResponseEntity<List<Card>> getCardByCardType(@PathVariable Long cardTypeId) throws CardNotFoundException
	{
		List<Card> card = cardRepository.findCardInformationByCardTypeId(cardTypeId);
		return ResponseEntity.ok().body(card);
	}

	/**
	 * passes the bankid as an argument 
	 * retreives the card information based on the bankid passed
	 * @param bankId
	 * @return
	 */
	public ResponseEntity<List<Card>> getCardByBankId(@PathVariable Long bankId) throws CardNotFoundException
	{
		List<Card> card = cardRepository.findCardInformationByBankId(bankId);
		return ResponseEntity.ok().body(card);
	}
	
	/**
	 * passes name as an argument
	 * retrieves the card information based on the name that is passed
	 * collected in a list
	 * @param name
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<List<Card>> getCardByName(@PathVariable String name) throws CardNotFoundException
	{
		List<Card> card = cardRepository.findCardInformationByName(name);
		return ResponseEntity.ok().body(card);
	}
	
	/**
	 * passes cardNumber as an argument
	 * retrieves the card information with the matching card number
	 * should be unique
	 * @param cardNumber
	 * @return
	 */
	public ResponseEntity<Card> getCardByCardNumber(@PathVariable String cardNumber)
	{
		Card card = cardRepository.findCardInformationByCardNumber(cardNumber);
		return ResponseEntity.ok().body(card);
	}
	
	/**
	 * takes the values entered into the required fields and saves a new card
	 * @param card
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Card addCardInformation(@Valid @RequestBody Card card) throws SecurityException, IOException
	{
		// FinancialLogger.financialLogger.info(LoggerInfoMessage.ADD_CARD_INFO_MSG + card);
		return cardRepository.save(card);
	}
	
	/**
	 * udpates the card information based on cardid passed 
	 * @param cardid
	 * @param cardDetails
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Card> updateCardInformation(@PathVariable Long cardid,
			@Valid @RequestBody Card cardDetails) throws SecurityException, IOException
	{
		Card card = null;
		try 
		{
			card = cardRepository.findById(cardid)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
			card.setBankId(cardDetails.getBankId());
			card.setCardNumber(cardDetails.getCardNumber());
			card.setCardTypeId(cardDetails.getCardTypeId());
			card.setExpirationDate(cardDetails.getExpirationDate());
			card.setName(cardDetails.getName());
			card.setSecurityCode(cardDetails.getSecurityCode());
		}
		catch (ResourceNotFoundException e)
		{
			e.printStackTrace();
		}
		final Card updatedCard = cardRepository.save(card);
		
		if (cardid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.UPDATE_CARD_INFO_MSG + cardid);
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.CARD_ID_NULL_ERROR_MSG);
		}
		return ResponseEntity.ok(updatedCard);
	}

	/**
	 * passes cardid as an argument 
	 * deletes the card information based on the id tha twas passed
	 * @param cardid
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Map<String, Boolean> deleteCard(@PathVariable Long cardid) throws SecurityException, IOException 
	{
		cardRepository.deleteById(cardid);
		if (cardid != null)
		{
			FinancialLogger.financialLogger.info(LoggerInfoMessage.DELETE_CARD_INFO_MSG + cardid);
		}
		else 
		{
			FinancialLogger.financialLogger.info(LoggerErrorMessage.CARD_ID_NULL_ERROR_MSG);
		}
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
