package it.sincrono.responses;

import it.sincrono.beans.Esito;

public class LoginResponse extends GenericResponse {

	private String token;

	public LoginResponse(Esito esito, String token) {
		super(esito);
		this.token = token;
	}

	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(Esito esito) {
		super(esito);
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(String token) {
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
