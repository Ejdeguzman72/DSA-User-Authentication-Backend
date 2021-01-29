package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.Contact;

public interface ContactServiceInterface {

	public List<Contact> getAllContacts();
	
	public ResponseEntity<Contact> getContactById(@PathVariable Long contactId);
	
	public Contact addContact(@Valid @RequestBody Contact contact);
	
	public ResponseEntity<Contact> updateContact(@PathVariable Long contactId,
			@Valid @RequestBody Contact ContactDetails);
	
	public Map<String,Boolean> deleteContact(@PathVariable Long contactId);
}
