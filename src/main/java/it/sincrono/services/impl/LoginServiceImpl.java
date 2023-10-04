package it.sincrono.services.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.UtenteRepository;
import it.sincrono.repositories.exceptions.RepositoryException;
import it.sincrono.requests.LoginRequest;
import it.sincrono.responses.LoginResponse;
import it.sincrono.services.JwtService;
import it.sincrono.services.LoginService;
import it.sincrono.services.costants.ServiceMessages;
import it.sincrono.services.exceptions.ServiceException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger LOGGER = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	private UtenteRepository utenteReposiroty;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public LoginResponse login(LoginRequest request) throws ServiceException {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			if (utenteReposiroty.findByUsername(request.getEmail()).orElseThrow().isAttivo()) {
				var utente = utenteReposiroty.findByUsername(request.getEmail()).orElseThrow();
				var jwtToken = jwtService.generateToken(utente);
				utente.setTokenPassword(jwtToken);
				utenteReposiroty.saveAndFlush(utente);

				LOGGER.log(Level.INFO, "Utente loggato con successo.");
				return new LoginResponse(jwtToken);
			} else {
				LOGGER.log(Level.ERROR, "Utente con email: \"" + request.getEmail() + "\" e' disattivato");
				throw new ServiceException(ServiceMessages.UTENTE_DISATTIVATO);
			}

		} catch (AuthenticationException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			throw new ServiceException(ServiceMessages.CREDENZIALI_ERRATE);
		}
	}

	@Override
	public String recuperoPassword(String username) throws ServiceException {
		try {
			var utente = utenteReposiroty.findByUsername(username).orElseThrow();

			String jwtToken = jwtService.generateToken(utente);
			utente.setTokenPassword(jwtToken);
			utenteReposiroty.saveAndFlush(utente);
			return jwtToken;
		} catch (EntityNotFoundException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			throw new EntityNotFoundException();
		}

	}

	@Override
	public void logout(String token_password) throws ServiceException, RepositoryException {
		var utente = utenteReposiroty.findByTokenPassword(token_password).orElseThrow();
		LOGGER.info("Richiesta di logout da parte dell'utente: \"" + utente.getUsername() + "\".");
		utente.setTokenPassword(null);
		utenteReposiroty.save(utente);
		LOGGER.info("Utente sloggato correttamente.");

	}

}
