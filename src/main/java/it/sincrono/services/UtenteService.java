package it.sincrono.services;

import it.sincrono.services.exceptions.ServiceException;

public interface UtenteService {
	
	public Integer isAuthorized(String percorso, String auth) throws ServiceException;

}
