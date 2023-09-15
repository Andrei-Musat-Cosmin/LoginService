package it.sincrono.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.UtenteRepository;
import it.sincrono.services.UtenteService;
import it.sincrono.services.costants.ServiceMessages;
import it.sincrono.services.exceptions.ServiceException;
import jakarta.persistence.NoResultException;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository utenteReposiroty;

	public Integer isAuthorized(String percorso, String auth) throws ServiceException {
		Integer risultato = null;
		try {
			risultato = utenteReposiroty.isAuthorized(percorso, auth);
		} catch (NoResultException e) {
			throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
		} catch (Exception e) {
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
		return risultato;
	}

	@Override
	public Integer isCurrentLogged(String auth, Integer id) throws ServiceException {
		Integer risultato = null;
		Integer idDB = null;
		// GET DELL'ANAGRAFICA PER VISUALIZZARE SE L'ID CORRISPONDE CON QUELLO DA
		// ELIMINARE
		try {
			idDB = utenteReposiroty.getAnagraficaByToken(auth);
		} catch (NoResultException e) {
			throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
		} catch (Exception e) {
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
		if (idDB == id)
			return null;
		return idDB;
	}
}
