package it.sincrono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.entity.Role;
import it.sincrono.requests.AuthenticationRequest;
import it.sincrono.requests.RegisterRequest;
import it.sincrono.responses.AuthenticationResponse;
import it.sincrono.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login-service")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authenticationService.login(request, Role.DIPENDENTE));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));

	}

}
