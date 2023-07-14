package it.sincrono.repositories.impl;

import it.sincrono.repositories.UtenteCustomRepository;
import it.sincrono.repositories.exceptions.RepositoryException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UtenteRepositoryImpl extends BaseRepositoryImpl implements UtenteCustomRepository {

	@Override
	public Integer isAuthorized(String percorso, String auth) throws NoResultException, RepositoryException {

		Integer risultato = null;
		String queryString = "SELECT a.id FROM utenti a " + "JOIN profili b ON  a.id = b.id_utente "
				+ "JOIN ruoli c ON b.id_ruolo = c.id " + "JOIN privilegi d ON c.id = d.id_ruolo "
				+ "JOIN funzioni e ON d.id_funzione = e.id " + "JOIN operazioni f ON e.id = f.id_funzione "
				+ "WHERE f.percorso LIKE '{0}' " + "AND a.token_password LIKE '{1}' ";

		queryString = queryString.replace("{0}", percorso);
		queryString = queryString.replace("{1}", auth);

		Query query = entityManager.createNativeQuery(queryString);
		try {
			risultato = (Integer) query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultException();
		} catch (Exception e) {
			throw new RepositoryException(e);
		}
		return risultato;
	}

}