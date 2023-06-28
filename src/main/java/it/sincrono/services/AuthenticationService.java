package it.sincrono.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import it.sincrono.entity.Role;
import it.sincrono.entity.User;
import it.sincrono.repositories.UserRepository;
import it.sincrono.requests.AuthenticationRequest;
import it.sincrono.requests.RegisterRequest;
import it.sincrono.responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	// SALVARE UN USER NEL DATABASE DINAMICO
	public AuthenticationResponse login(RegisterRequest request, Role ruolo) {
		var user = User.builder().username(request.getUsername()).password(request.getPassword()).ruolo(ruolo).build();
		userReposiroty.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = userReposiroty.findByUsername(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

}
