package it.sincrono.services;

import it.sincrono.requests.AuthenticationRequest;
import it.sincrono.responses.AuthenticationResponse;
import it.sincrono.services.exceptions.ServiceException;

public interface AuthenticationService {

	public AuthenticationResponse authenticate(AuthenticationRequest request) throws ServiceException;

	
	// public AuthenticationResponse login(RegisterRequest request, Role ruolo)
	// throws ServiceException;
}
