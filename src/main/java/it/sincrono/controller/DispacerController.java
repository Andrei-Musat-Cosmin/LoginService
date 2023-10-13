package it.sincrono.controller;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
	private static final Logger LOGGER = LogManager.getLogger(DispacerController.class);

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

			genericResponse.setEsito(new Esito());

			httpEntity = new HttpEntity<GenericResponse>(genericResponse);

		} catch (ServiceException e) {
			LOGGER.error(e.getMessage());
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
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
		String auth = request.getHeaders().getFirst("authorization").substring(7);
		String path = request.getURI().getPath().replaceAll("%20", " ").substring(9).split("/")[1];
		String body = null;
		try {
			body = getBody(servletRequest).toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (utenteService.isAuthorized(path, auth) != null) {
				if (path.equals("delete")) {
					String idDB = body.substring(37).split(",\"nome\":")[0];
					if (utenteService.isCurrentLogged(auth, Integer.valueOf(idDB)) == null) {
						LOGGER.info("Utente da eliminare è utilizzato per il login, operazione annulata");
						genericResponse.setEsito(new Esito(-1,
								"Utente da eliminare è utilizzato per il login, operazione annulata", null));
						return httpEntity = new HttpEntity<GenericResponse>(genericResponse);
					}
				}
				httpEntity = new HttpEntity<GenericResponse>(restClient.sendRequest(
						"http://localhost:8085/".concat(request.getURI().getPath().substring(10)),
						servletRequest.getMethod(), body));
			}

		} catch (ServiceException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e.getMessage());
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
