package it.sincrono.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.entity.Ruolo;
import it.sincrono.entity.Utente;

public interface RuoloRepository extends JpaRepository<Utente, Integer>, UtenteCustomRepository {

	@Query("SELECT c FROM Utente a JOIN Profilo b ON  a.id = b.utente.id "
			+ "JOIN Ruolo c ON b.ruolo.id = c.id WHERE a.id = ?1")
	public Ruolo findRuoloByUtenteId(Integer id);
}
