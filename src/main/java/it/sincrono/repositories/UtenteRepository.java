package it.sincrono.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>, UtenteCustomRepository {

	// TROVA UN USER DAL USERNAME
	public Optional<Utente> findByUsername(String username);

	// TROVA UN USER DAL TOKEN
	public Optional<Utente> findByTokenPassword(String token_password);

	@Query("SELECT a.id FROM Utente a JOIN Profilo b ON  a.id = b.utente.id "
			+ "JOIN Ruolo c ON b.ruolo.id = c.id JOIN Privilegio d ON c.id = d.ruolo.id "
			+ "JOIN Funzione e ON d.funzione.id = e.id JOIN Operazione f ON e.id = f.funzione.id "
			+ "WHERE f.percorso LIKE ?1 AND a.id = ?2 ")
	public Integer findOperazioneById(String path, Integer id);

}
