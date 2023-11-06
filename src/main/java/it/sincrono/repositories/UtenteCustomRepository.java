package it.sincrono.repositories;

import it.sincrono.repositories.exceptions.RepositoryException;

public interface UtenteCustomRepository {

//	Integer isAuthorized(String percorso, String auth) throws NoResultException, RepositoryException;

	public Integer getAnagraficaByTokenPassword(String auth) throws RepositoryException;
}
