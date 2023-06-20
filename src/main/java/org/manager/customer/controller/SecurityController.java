package org.manager.customer.controller;

import org.manager.customer.controller.model.AuthenticationRequest;
import org.manager.customer.controller.model.AuthenticationResponse;
import org.manager.customer.security.JavaWebTokenService;
import org.manager.customer.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private JavaWebTokenService javaWebTokenService;
	
	@Autowired
	MyUserDetailService detailService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("")
	public String authonticate() {
		return "Hello Suchita";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> getNewSessionToken(@RequestBody AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails userDetails = detailService.loadUserByUsername(request.getUsername());
		String token = javaWebTokenService.getToken(userDetails.getUsername());
		AuthenticationResponse res = new AuthenticationResponse(token);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
}
