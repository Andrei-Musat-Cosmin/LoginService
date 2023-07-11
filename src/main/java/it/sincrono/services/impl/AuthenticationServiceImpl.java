package it.sincrono.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.UtenteRepository;
import it.sincrono.requests.AuthenticationRequest;
import it.sincrono.responses.AuthenticationResponse;
import it.sincrono.services.AuthenticationService;
import it.sincrono.services.JwtService;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UtenteRepository utenteReposiroty;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationResponse authenticate(AuthenticationRequest request) throws ServiceException {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var utente = utenteReposiroty.findByUsername(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(utente);
		utente.setToken_password(jwtToken);
		utenteReposiroty.saveAndFlush(utente);
		return new AuthenticationResponse(jwtToken);
	}

	// SALVARE UN USER NEL DATABASE DINAMICO
	/**
	 * public AuthenticationResponse login(RegisterRequest request, Role ruolo)
	 * throws ServiceException { var user =
	 * User.builder().username(request.getUsername())
	 * .password(passwordEncoder.encode(request.getPassword())).ruolo(ruolo).build();
	 * userReposiroty.save(user); var jwtToken = jwtService.generateToken(user);
	 * return AuthenticationResponse.builder().token(jwtToken).build(); }
	 **/
}
