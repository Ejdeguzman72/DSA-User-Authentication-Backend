package com.deguzman.HomeInfoTracker.application_controller;

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

import com.deguzman.HomeInfoTracker.application_service.UsersService;
import com.deguzman.HomeInfoTracker.authentication_models.Users;
import com.deguzman.HomeInfoTracker.authentication_repository.UserDao;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("app/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/user/{userid}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long userid)
	{
		return usersService.getUserById(userid);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/user/username/{username}")
	public ResponseEntity<Users> getUsersByUsername(@PathVariable String username)
	{
		return usersService.getUsersByUsername(username);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-user")
	public Users addUser(@Valid @RequestBody Users user)
	{
		return usersService.addUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/user/{userid}")
	public ResponseEntity<Users> updateUser(@PathVariable Long userid,
			@Valid @RequestBody Users userDetails)
	{
		return usersService.updateUser(userid, userDetails);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/user/{userid}")
	public Map<String, Boolean> deleteUser(@PathVariable Long userid)
	{
		return usersService.deleteUser(userid);
	}
}
