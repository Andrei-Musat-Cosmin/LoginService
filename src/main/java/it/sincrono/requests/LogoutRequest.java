package it.sincrono.requests;

public class LogoutRequest extends GenericRequest {

	private String token;

	public LogoutRequest(String token) {
		super();
		this.token = token;
	}

	public LogoutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
