package com.dsa.HomeInfoTracker.application_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.HomeInfoTracker.application_models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Query(value = "SELECT * FROM contact ORDER BY contactid", nativeQuery=true)
	List<Contact> selectAllContacts();
	
	@Query(value = "SELECT * FROM contact WHERE phone = ?1", nativeQuery=true)
	Contact findContactByPhoneNumber(String phone);
	
	@Query(value = "SELECT * FROM contact WHERE email = ?1", nativeQuery=true)
	Contact findContactByEmailAddress(String email);
	
	@Query(value = "SELECT * FROM contact WHERE lastname = ?1", nativeQuery=true)
	List<Contact> findContactByLastName(String lastname);
	
	@Query(value = "SELECT * FROM contact WHERE firstname = ?1", nativeQuery=true)
	Contact findCOntactByFirstName(String firstname);
}
