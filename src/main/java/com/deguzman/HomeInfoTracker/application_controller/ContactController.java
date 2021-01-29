package com.deguzman.HomeInfoTracker.application_controller;

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

import com.deguzman.HomeInfoTracker.application_models.Contact;
import com.deguzman.HomeInfoTracker.application_repository.ContactRepository;
import com.deguzman.HomeInfoTracker.application_service.ContactService;
import com.deguzman.HomeInfoTracker.exception.ContactNotFoundException;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/app/contact-book")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/all")
	public List<Contact> getAllContacts() throws SecurityException, IOException {
		return contactService.getAllContacts();
	}
	
	
	@GetMapping("/contact/{contactid}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long contactid) throws ContactNotFoundException, SecurityException, IOException
	{
		return contactService.getContactById(contactid);
	}
	
	
	@GetMapping("/contact/phone/{phone}")
	public ResponseEntity<Contact> getContactByPhoneNumber(@PathVariable String phone) throws ResourceNotFoundException, ContactNotFoundException
	{
		return contactService.getContactByPhoneNumber(phone);
	}
	
	
	@GetMapping("/contact/get-a-contact-by-email/email/{email}")
	public ResponseEntity<Contact> getContactByEmailAddress(@PathVariable String email) throws ResourceNotFoundException, ContactNotFoundException
	{
		return contactService.getContactByEmailAddress(email);
	}

	
	@GetMapping("/contact/firstname/{firstname}")
	public ResponseEntity<Contact> getContactByFirstName(@PathVariable String firstname) throws ResourceNotFoundException, ContactNotFoundException
	{
		return contactService.getContactByFirstName(firstname);
	}
	
	
	@GetMapping("/contact/lastname/{lastname}")
	public ResponseEntity<List<Contact>> getContactByLastName(@PathVariable String lastname) throws ResourceNotFoundException, ContactNotFoundException
	{
		return contactService.getContactByLastName(lastname);
	}
	
	
	@PostMapping("/contacts")
	public Contact createContact(@Valid @RequestBody Contact contact) throws SecurityException, IOException {
		return contactService.createContact(contact);
	}

	
	@PutMapping("/contact/{contactid}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long contactid, 
			@Valid @RequestBody Contact contactDetails) throws ResourceNotFoundException, SecurityException, IOException{
		return contactService.updateContact(contactid, contactDetails);
	}
	
	
	@DeleteMapping("contact/{contactid}")
	public Map<String, Boolean> deleteContact(@PathVariable Long contactid)
		throws ResourceNotFoundException, SecurityException, IOException {
		return contactService.deleteContact(contactid);
	}
}
