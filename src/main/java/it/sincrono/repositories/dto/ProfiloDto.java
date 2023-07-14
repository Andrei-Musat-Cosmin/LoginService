package it.sincrono.repositories.dto;

import it.sincrono.entity.Ruolo;
import it.sincrono.entity.Utente;

public class ProfiloDto {

	private Utente utente;

	private Ruolo ruolo;

	public ProfiloDto(Utente utente, Ruolo ruolo) {
		super();
		this.utente = utente;
		this.ruolo = ruolo;
	}

	public ProfiloDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
