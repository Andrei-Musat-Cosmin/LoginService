package it.sincrono.requests;

import it.sincrono.entity.Role;

public class RegisterRequest extends GenericRequest {

	private String username;

	private String password;

	private Role ruolo;

	public RegisterRequest(String username, String password, Role ruolo) {
		super();
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}

	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRuolo() {
		return ruolo;
	}

	public void setRuolo(Role ruolo) {
		this.ruolo = ruolo;
	}

}
