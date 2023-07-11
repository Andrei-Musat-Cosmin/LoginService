package it.sincrono.responses;

import it.sincrono.beans.Esito;

public class AuthenticationResponse extends GenericResponse {

	private String token;

	public AuthenticationResponse(Esito esito, String token) {
		super(esito);
		this.token = token;
	}

	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(Esito esito) {
		super(esito);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
