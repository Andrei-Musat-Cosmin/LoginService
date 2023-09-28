package it.sincrono.repositories.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.sincrono.controller.DispacerController;
import it.sincrono.entity.Utente;
import it.sincrono.repositories.UtenteCustomRepository;
import it.sincrono.repositories.exceptions.RepositoryException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UtenteRepositoryImpl extends BaseRepositoryImpl implements UtenteCustomRepository {
	private static final Logger LOGGER = LogManager.getLogger(DispacerController.class);

	@Override
	public Integer isAuthorized(String percorso, String auth) throws NoResultException, RepositoryException {

		Utente utente = null;
		try {
			String queryString1 = "SELECT a.* FROM utenti a WHERE a.token_password LIKE '" + auth + "'";
			Query query = entityManager.createNativeQuery(queryString1);

			LOGGER.info("Richiesta del servizio: '" + percorso + "' da parte di:" + utente.getUsername() + ".");

			String queryString2 = "SELECT a.* FROM utenti a JOIN profili b ON  a.id = b.id_utente "
					+ "JOIN ruoli c ON b.id_ruolo = c.id JOIN privilegi d ON c.id = d.id_ruolo "
					+ "JOIN funzioni e ON d.id_funzione = e.id JOIN operazioni f ON e.id = f.id_funzione "
					+ "WHERE f.percorso LIKE '{0}' AND a.id = {1} ";

			queryString2 = queryString2.replace("{0}", percorso);
			queryString2 = queryString2.replace("{1}", utente.getId().toString());

			query = entityManager.createNativeQuery(queryString2);

			utente = (Utente) query.getSingleResult();

		} catch (NoResultException e) {
			throw new NoResultException();
		} catch (Exception e) {
			throw new RepositoryException(e);
		}
		return utente.getId();
	}

	@Override
	public Integer getAnagraficaByToken(String auth) throws RepositoryException {
		Integer risultato = null;
		String queryString = "SELECT a.* FROM anagrafica a INNER JOIN utenti b ON a.id_utente = b.id WHERE b.token_password LIKE '{0}'";
		queryString = queryString.replace("{0}", auth);

		Query query = entityManager.createNativeQuery(queryString);
		try {
			Object[] anagraficaDB = (Object[]) query.getSingleResult();
			if (anagraficaDB != null)
				if (anagraficaDB[0] != null)
					risultato = (Integer) anagraficaDB[0];
		} catch (NoResultException e) {
			throw new NoResultException();
		} catch (Exception e) {
			throw new RepositoryException(e);
		}
		return risultato;
	}

}