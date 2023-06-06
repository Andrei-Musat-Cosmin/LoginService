package it.sincrono.controllers.beans.responses;

import it.sincrono.controllers.beans.Esito;
import it.sincrono.repositories.entities.Utente;

public class LoginResponse extends GenericResponse {

    private Utente utente;
    private String jwtToken;

    public LoginResponse(Utente utente, String jwtToken) {
        this.utente = utente;
        this.jwtToken = jwtToken;
    }
    
    

    public LoginResponse() {
	}



	public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
