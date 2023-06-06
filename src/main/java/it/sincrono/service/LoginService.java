package it.sincrono.service;

import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.services.exceptions.ServiceException;

public interface LoginService {

	public void ripristinaPassword(Anagrafica anagrafica) throws ServiceException;
	public void ripristinaPassword(String token, Anagrafica anagrafica) throws ServiceException;
	public void primoAccesso(String token, Anagrafica anagrafica) throws ServiceException;
}