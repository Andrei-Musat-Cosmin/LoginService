package it.sincrono.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.sincrono.repositories.entities.Utente;
import it.sincrono.repositories.exceptions.RepositoryException;


public interface UtenteRepository extends JpaRepository<Utente, Integer>, UtenteCustomRepository {

	@Query(value = "select a from Utente a where a.tokenPassword=:token")
	public Utente findByToken(@Param("token")String token) throws RepositoryException;
	
	@Query(value = "select a from Utente a where a.username=:username")
	public Utente findByUsername(@Param("username")String username) throws RepositoryException;
	
}