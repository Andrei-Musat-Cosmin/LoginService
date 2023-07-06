package it.sincrono.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sincrono.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	// TROVA UN USER DAL USERNAME
	public Optional<Utente> findByUsername(String username);

}
