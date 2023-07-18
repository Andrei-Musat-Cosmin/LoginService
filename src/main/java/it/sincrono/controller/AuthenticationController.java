package it.sincrono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.beans.Esito;
import it.sincrono.requests.AuthenticationRequest;
import it.sincrono.requests.RegisterRequest;
import it.sincrono.responses.AuthenticationResponse;
import it.sincrono.responses.GenericResponse;
import it.sincrono.services.AuthenticationService;
import it.sincrono.services.exceptions.ServiceException;

@RestController
@RequestMapping("/login-service")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/authenticate")
	public HttpEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

		HttpEntity<AuthenticationResponse> httpEntity = null;

		AuthenticationResponse authenticationResponse = new AuthenticationResponse();

		try {

			System.out.println("Start invocation of method authenticate of Authentication Service");

			authenticationResponse.setToken(authenticationService.authenticate(request).getToken());

			System.out.println("End invocation of method authenticate of Authentication Service");

			httpEntity = new HttpEntity<AuthenticationResponse>(authenticationResponse);

		} catch (ServiceException e) {
			authenticationResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<AuthenticationResponse>(authenticationResponse);
		}
		return httpEntity;

	}

	@PostMapping("/cambia-password")
	public HttpEntity<GenericResponse> recuperoPassword(@RequestBody RegisterRequest request) {

		HttpEntity<GenericResponse> httpEntity = null;

		GenericResponse genericResponse = new GenericResponse();

		try {

			System.out.println("Start invocation of method authenticate of Authentication Service");

			authenticationService.recuperoPassword(request.getUsername());

			System.out.println("End invocation of method authenticate of Authentication Service");

			httpEntity = new HttpEntity<GenericResponse>(genericResponse);

		} catch (ServiceException e) {
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}
		return httpEntity;
	}

}
