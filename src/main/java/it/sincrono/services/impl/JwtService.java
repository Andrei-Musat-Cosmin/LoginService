package it.sincrono.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.sincrono.controllers.beans.requests.LoginRequest;
import it.sincrono.repositories.UtenteRepository;
import it.sincrono.repositories.entities.Utente;
import it.sincrono.repositories.exceptions.RepositoryException;
import it.sincrono.services.utils.CustomUserDetails;
import it.sincrono.services.utils.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Utente createJwtToken(LoginRequest loginRequest) throws Exception {

		String userName = loginRequest.getUtente().getUsername();
		String userPassword = loginRequest.getUtente().getPassword();
		authenticate(userName, userPassword);

		UserDetails userDetails = loadUserByUsername(userName);

		if (userDetails.getPassword() == loginRequest.getUtente().getPassword()
				&& userDetails.getUsername() == loginRequest.getUtente().getUsername()) {
			throw new BadCredentialsException("Credenziali di accesso non valide");
		}

		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		return new Utente(newGeneratedToken, loginRequest.getUtente().getUsername());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utente utente = null;
		try {
			utente = utenteRepository.findByUsername(username);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		UserDetails userDetails;

		if (utente != null) {

			userDetails = new CustomUserDetails(utente.getUsername(), utente.getPassword(), null);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		return userDetails;

	}

	private void authenticate(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
