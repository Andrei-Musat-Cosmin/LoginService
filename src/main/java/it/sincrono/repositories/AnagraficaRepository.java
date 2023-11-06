package it.sincrono.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.entity.Anagrafica;
import it.sincrono.entity.Utente;

public interface AnagraficaRepository extends JpaRepository<Utente, Integer>, UtenteCustomRepository {

	@Query("SELECT a FROM Anagrafica as a INNER JOIN Utente AS b ON b.id = a.utente.id WHERE b.id = ?1")
	public Anagrafica findByIdUtente(Integer id);

}
