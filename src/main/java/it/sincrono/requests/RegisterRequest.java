package it.sincrono.requests;

public class RegisterRequest extends GenericRequest {

	private String username;

	public RegisterRequest(String username) {
		super();
		this.username = username;
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

}
