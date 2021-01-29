package com.dsa.HomeInfoTracker.application_service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dsa.HomeInfoTracker.application_models.Contact;
import com.dsa.HomeInfoTracker.application_repository.ContactRepository;
import com.dsa.HomeInfoTracker.exception.ContactNotFoundException;
import com.dsa.HomeInfoTracker.exception.ResourceNotFoundException;
import com.dsa.HomeInfoTracker.logger.ContactLogger;
import com.dsa.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.dsa.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	/**
	 * finds all contacts that are listed in the database 
	 * uses a List to show the contacts
	 * @return will display the results for all the contacts within the database
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<Contact> getAllContacts() throws SecurityException, IOException {
		
		ContactLogger.contactLogger.info(LoggerInfoMessage.GET_ALL_CONTACT_INFO_MSG);
		return contactRepository.selectAllContacts();
	}

	/**
	 * returns a 
	 * @param contactid 
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws ResourceNotFoundException 
	 */
	public ResponseEntity<Contact> getContactById(@PathVariable Long contactid) throws ContactNotFoundException, SecurityException, IOException
	 {
		if (contactid != null)
		{
			ContactLogger.contactLogger.info(LoggerInfoMessage.GET_CONTACT_INFO_BY_ID_MSG + contactid);		
		}
		else 
		{
			ContactLogger.contactLogger.info(LoggerErrorMessage.CONTACT_ID_NULL_ERROR_MSG);
		}
		
	Contact contact = contactRepository.findById(contactid)
			.orElseThrow(() -> new ContactNotFoundException("No contact with the matching id"));
	
	
	return ResponseEntity.ok().body(contact);
	}

	/**
	 * phone number is passed as a paraeter 
	 * corresponding contact is found from the phone number entered
	 * @param phone
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ContactNotFoundException 
	 */
	public ResponseEntity<Contact> getContactByPhoneNumber(@PathVariable String phone) throws ContactNotFoundException
	{
		Contact contact = contactRepository.findContactByPhoneNumber(phone);
		return ResponseEntity.ok().body(contact);
	}

	/**
	 * Email is entered in a parameter
	 * contact is found by email entered 
	 * @param email
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ContactNotFoundException 
	 */
	public ResponseEntity<Contact> getContactByEmailAddress(@PathVariable String email) throws ContactNotFoundException
	{
		Contact contact = contactRepository.findContactByEmailAddress(email);	
		return ResponseEntity.ok().body(contact);
	}

	/**
	 * Contact is found by firstname 
	 * retrieves cotact with the firstname that is entered
	 * @param firstname
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ContactNotFoundException 
	 */
	public ResponseEntity<Contact> getContactByFirstName(@PathVariable String firstname) throws ContactNotFoundException
	{
		Contact contact = contactRepository.findCOntactByFirstName(firstname);
		return ResponseEntity.ok().body(contact);
	}

	/**
	 * Contact is found by the lastname 
	 * retrieves contact with the lastname that is entered
	 * @param lastname
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ContactNotFoundException 
	 */
	public ResponseEntity<List<Contact>> getContactByLastName(@PathVariable String lastname) throws ContactNotFoundException
	{
		List<Contact> contact = contactRepository.findContactByLastName(lastname);
		return ResponseEntity.ok().body(contact);
	}

	/**
	 * take the RequestBody for contact info and returns that as as object 
	 * will save the contact information and enter it into the database 
	 * @param contact
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Contact createContact(@Valid @RequestBody Contact contact) throws SecurityException, IOException {
		
		// ContactLogger.contactLogger.info(LoggerInfoMessage.ADD_CONTACT_INFO_MSG + contact);
		return contactRepository.save(contact);
	}
	
	
	/**
	 * works the same as the post mapping but takes the entered information for the 
	 * following contact id 
	 * @param contactid
	 * @param contactDetails
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<Contact> updateContact(@PathVariable Long contactid, 
			@Valid @RequestBody Contact contactDetails) throws ResourceNotFoundException, SecurityException, IOException{
		Contact contact = contactRepository.findById(contactid) 
				.orElseThrow(() -> new ResourceNotFoundException("No Contact with the matching id"));
		if (contactid != null)
		{
			ContactLogger.contactLogger.info(LoggerInfoMessage.UPDATE_CONTACT_INFO_MSG + contactid);			
		}
		else 
		{
			ContactLogger.contactLogger.info(LoggerErrorMessage.CONTACT_ID_NULL_ERROR_MSG);
		}
		
		// sets the new information for the following fields
		contact.setAddress(contactDetails.getAddress());
		contact.setCity(contactDetails.getCity());
		contact.setEmaill(contactDetails.getEmaill());
		contact.setFirstname(contactDetails.getFirstname());
		contact.setLastname(contactDetails.getLastname());
		contact.setPhone(contactDetails.getPhone());
		contact.setState(contactDetails.getState());
		contact.setZipcode(contactDetails.getZipcode());
		
		// makes an updatedContact object and saves it to the database
		final Contact updatedContact = contactRepository.save(contact);
		
		return ResponseEntity.ok(updatedContact);
	}
	
	// take the entered id and deletes the contact
	public Map<String, Boolean> deleteContact(@PathVariable Long contactid) throws ResourceNotFoundException, SecurityException, IOException {
		Contact contact = contactRepository.findById(contactid)
			.orElseThrow(() -> new ResourceNotFoundException("Cannot delete this employee!"));
		
		if (contactid != null)
		{
			ContactLogger.contactLogger.info(LoggerInfoMessage.DELETE_CONTACT_INFO_MSG + contactid);			
		}
		else 
		{
			ContactLogger.contactLogger.info(LoggerErrorMessage.CONTACT_ID_NULL_ERROR_MSG);
		}
		
		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		}
}
