package it.sincrono.controller;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.beans.Esito;
import it.sincrono.requests.LogoutRequest;
import it.sincrono.responses.GenericResponse;
import it.sincrono.services.LoginService;
import it.sincrono.services.UtenteService;
import it.sincrono.services.exceptions.ServiceException;
import it.sincrono.services.utils.RestClient;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/services")
@CrossOrigin()
public class DispacerController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RestClient restClient;

	@Autowired
	private UtenteService utenteService;

	@PutMapping("/logout")
	public HttpEntity<GenericResponse> authorizeAndDispatch(@RequestBody LogoutRequest logoutRequest) {
		HttpEntity<GenericResponse> httpEntity = null;

		GenericResponse genericResponse = new GenericResponse();
		try {

			loginService.logout(logoutRequest.getToken());

		} catch (ServiceException e) {
			String[] messaggio = new String[1];
			messaggio[0] = "Utente non autorizzato";
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), messaggio));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			genericResponse.setEsito(new Esito(500, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}
		return httpEntity;

	}

	@RequestMapping("/**")
	public HttpEntity<GenericResponse> authorizeAndDispatch(HttpServletRequest servletRequest) {

		HttpEntity<GenericResponse> httpEntity = null;

		GenericResponse genericResponse = new GenericResponse();

		ServletServerHttpRequest request = new ServletServerHttpRequest(servletRequest);

		try {
			if (utenteService.isAuthorized(request.getURI().getPath().substring(9).replaceAll("[0-9]+$", "%"),
					request.getHeaders().getFirst("authorization").substring(7)) != null) {

				httpEntity = new HttpEntity<GenericResponse>(restClient.sendRequest(
						"http://localhost:8085/".concat(request.getURI().getPath().substring(10)),
						HttpMethod.resolve(request.getMethodValue()).toString(), getBody(servletRequest).toString()));
			}

		} catch (ServiceException e) {
			String[] messaggio = new String[1];
			messaggio[0] = "Utente non autorizzato";
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), messaggio));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			genericResponse.setEsito(new Esito(500, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}

	private StringBuilder getBody(HttpServletRequest servletRequest) throws IOException {

		StringBuilder sb = new StringBuilder();

		BufferedReader reader;

		reader = servletRequest.getReader();

		String line;

		while ((line = reader.readLine()) != null) {

			sb.append(line);

		}

		return sb;

	}

}
