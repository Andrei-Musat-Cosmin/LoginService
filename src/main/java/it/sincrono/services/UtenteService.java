package it.sincrono.services;

import org.json.JSONObject;

import it.sincrono.services.exceptions.ServiceException;

public interface UtenteService {

	public Boolean isUtenteAuthorized(String percorso, String auth, JSONObject body, String token)
			throws ServiceException;
}
