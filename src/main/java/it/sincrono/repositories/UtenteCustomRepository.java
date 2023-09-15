package it.sincrono.repositories;

import it.sincrono.repositories.exceptions.RepositoryException;
import jakarta.persistence.NoResultException;

public interface UtenteCustomRepository {

	Integer isAuthorized(String percorso, String auth) throws NoResultException, RepositoryException;

	public Integer getAnagraficaByToken(String auth) throws RepositoryException;
}
