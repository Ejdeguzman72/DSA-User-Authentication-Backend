package com.deguzman.HomeInfoTracker.application_service;

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

import com.deguzman.HomeInfoTracker.authentication_models.Users;
import com.deguzman.HomeInfoTracker.authentication_repository.UserDao;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;

@Service
public class UsersService {
	
	@Autowired
	private UserDao usersRepository;
	
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}
	
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long userid)
	{
		Optional<Users> user = usersRepository.findById(userid);
		return ResponseEntity.ok().body(user);
	}
	
	public ResponseEntity<Users> getUsersByUsername(@PathVariable String username)
	{
		Users user = usersRepository.findUserByUsername(username);
		return ResponseEntity.ok().body(user);
	}
	
	public Users addUser(@Valid @RequestBody Users user)
	{
		return usersRepository.save(user);
	}
	
	public ResponseEntity<Users> updateUser(@PathVariable Long userid,
			@Valid @RequestBody Users userDetails)
	{
		Users user = null;
		
		try 
		{
			user = usersRepository.findById(userid)
					.orElseThrow(() -> new ResourceNotFoundException("not found"));
			user.setUsername(userDetails.getUsername());
			user.setPassword(userDetails.getPassword());
		}
		catch (ResourceNotFoundException e)
		{
			e.printStackTrace();
		}
		final Users updatedUser = usersRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	public Map<String, Boolean> deleteUser(@PathVariable Long userid)
	{
		usersRepository.deleteById(userid);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
