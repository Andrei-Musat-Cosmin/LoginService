package it.sincrono.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.UtenteRepository;
import it.sincrono.requests.LoginRequest;
import it.sincrono.responses.LoginResponse;
import it.sincrono.services.JwtService;
import it.sincrono.services.LoginService;
import it.sincrono.services.costants.ServiceMessages;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UtenteRepository utenteReposiroty;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public LoginResponse login(LoginRequest request) throws ServiceException {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		if (utenteReposiroty.findByUsername(request.getEmail()).orElseThrow().isAttivo()) {
			var utente = utenteReposiroty.findByUsername(request.getEmail()).orElseThrow();
			var jwtToken = jwtService.generateToken(utente);
			utente.setTokenPassword(jwtToken);
			utenteReposiroty.saveAndFlush(utente);
			return new LoginResponse(jwtToken);
		} else {
			throw new ServiceException(ServiceMessages.RECORD_NON_TROVATO);
		}
	}

	@Override
	public String recuperoPassword(String username) throws ServiceException {
		var utente = utenteReposiroty.findByUsername(username).orElseThrow();
		String jwtToken = jwtService.generateToken(utente);
		utente.setTokenPassword(jwtToken);
		utenteReposiroty.saveAndFlush(utente);
		return jwtToken;

	}

	@Override
	public void logout(String token_password) throws ServiceException {
		var utente = utenteReposiroty.findByTokenPassword(token_password).orElseThrow();
		utente.setTokenPassword(null);
		utenteReposiroty.save(utente);

	}

}
