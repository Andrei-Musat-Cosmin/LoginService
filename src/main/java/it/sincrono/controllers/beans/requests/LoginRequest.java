package it.sincrono.controllers.beans.requests;

import it.sincrono.repositories.entities.Utente;

public class LoginRequest extends GenericRequest {
	
	private Utente utente;

    
	public LoginRequest(Utente utente) {
		super();
		this.utente = utente;
	}

	public LoginRequest() {
		super();
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
 
	
	
    
}