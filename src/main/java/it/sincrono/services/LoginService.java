package it.sincrono.services;

import it.sincrono.repositories.exceptions.RepositoryException;
import it.sincrono.requests.LoginRequest;
import it.sincrono.responses.LoginResponse;
import it.sincrono.services.exceptions.ServiceException;

public interface LoginService {

	public LoginResponse login(LoginRequest request) throws ServiceException;

	public String recuperoPassword(String username) throws ServiceException;

	public void logout(String token_password) throws ServiceException, RepositoryException;

}
