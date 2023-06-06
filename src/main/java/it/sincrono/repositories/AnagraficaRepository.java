package it.sincrono.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.sincrono.repositories.entities.Anagrafica;

public interface AnagraficaRepository extends JpaRepository<Anagrafica, Integer>, AnagraficaCustomRepository {

	@Query(value = "select a from Anagrafica a where a.mailPrivata = :email")
	public Anagrafica findByEmail(@Param("email") String email);
}