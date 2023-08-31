package it.sincrono.repositories.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import it.sincrono.entity.Anagrafica;
import it.sincrono.entity.Commessa;
import it.sincrono.entity.Contratto;
import it.sincrono.entity.Ruolo;

public class AnagraficaDto {

	@JsonView(Anagrafica.class)
	private Anagrafica anagrafica;

	@JsonView(Contratto.class)
	private Contratto contratto;

	@JsonView(Commessa.class)
	private List<Commessa> commesse;

	@JsonView(Ruolo.class)
	private Ruolo ruolo;

	public AnagraficaDto(Anagrafica anagrafica, Contratto contratto, List<Commessa> commesse, Ruolo ruolo) {
		super();
		this.anagrafica = anagrafica;
		this.contratto = contratto;
		this.commesse = commesse;
		this.ruolo = ruolo;
	}

	public AnagraficaDto() {
		super();
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public Contratto getContratto() {
		return contratto;
	}

	public void setContratto(Contratto contratto) {
		this.contratto = contratto;
	}

	public List<Commessa> getCommessa() {
		return commesse;
	}

	public void setCommessa(List<Commessa> commessa) {
		this.commesse = commessa;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
