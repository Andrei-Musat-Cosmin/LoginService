package it.sincrono.repositories.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

import it.sincrono.entity.Anagrafica;
import it.sincrono.entity.Commessa;
import it.sincrono.entity.Contratto;
import it.sincrono.entity.Ruolo;
import it.sincrono.responses.GenericResponse;



public class AnagraficaDto{
	

	@JsonView(Anagrafica.class)
	private Anagrafica anagrafica;

	@JsonView(Contratto.class)
	private Contratto contratto;

	@JsonView(Commessa.class)
	private Commessa commessa;
	
	@JsonView(Ruolo.class)
	private Ruolo ruolo;
	


	public AnagraficaDto(Anagrafica anagrafica, Contratto contratto, Commessa commessa, Ruolo ruolo) {
		super();
		this.anagrafica = anagrafica;
		this.contratto = contratto;
		this.commessa = commessa;
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


	public Commessa getCommessa() {
		return commessa;
	}


	public void setCommessa(Commessa commessa) {
		this.commessa = commessa;
	}


	public Ruolo getRuolo() {
		return ruolo;
	}


	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	
}
