package com.dsa.HomeInfoTracker.authentication_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.HomeInfoTracker.application_config_values.ConfigValues;
import com.dsa.HomeInfoTracker.authentication_config.JwtTokenUtil;
import com.dsa.HomeInfoTracker.authentication_models.JwtRequest;
import com.dsa.HomeInfoTracker.authentication_models.JwtResponse;
import com.dsa.HomeInfoTracker.authentication_models.UserDTO;
import com.dsa.HomeInfoTracker.authentication_models.Users;
import com.dsa.HomeInfoTracker.authentication_service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Users user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/guest-authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createGuestAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	private void guestAuthentication(String username, String password) throws Exception {
		try {
			
			username = ConfigValues.GLOBAL_USERNAME;
			
			password = ConfigValues.GLOBAL_PASSWORD;
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		} catch (DisabledException e) {
			
			throw new Exception("USER DISABLED", e);
			
		} catch (BadCredentialsException e) {
			
			throw new Exception("INVALID CREDENTIALS", e);
			
		}
	}
}