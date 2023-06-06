package it.sincrono.controllers.beans.requests;




import it.sincrono.repositories.entities.Utente;


public class UtenteRequest extends GenericRequest {
	private Utente utente;

	public UtenteRequest(Utente utente) {
		super();
		this.utente = utente;
	}

	public UtenteRequest() {
		super();
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}