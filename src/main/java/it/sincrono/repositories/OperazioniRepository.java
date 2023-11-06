package it.sincrono.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.entity.Utente;

public interface OperazioniRepository extends JpaRepository<Utente, Integer>, UtenteCustomRepository {

	@Query("SELECT a FROM Utente a JOIN Profilo b ON  a.id = b.utente.id "
			+ "JOIN Ruolo c ON b.ruolo.id = c.id JOIN Privilegio d ON c.id = d.ruolo.id "
			+ "JOIN Funzione e ON d.funzione.id = e.id JOIN Operazione f ON e.id = f.funzione.id "
			+ "WHERE f.percorso LIKE ?1 AND a.id = ?2 ")
	public Utente findOperazioneById(String path, Integer id);

}
