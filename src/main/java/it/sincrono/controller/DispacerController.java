package it.sincrono.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${path-backend.path}")
	private String pathBackEnd;

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
		String token = null;
		String bodyString = null;
		String auth = request.getHeaders().getFirst("authorization").substring(7);
		String[] partiDiPath = request.getURI().getPath().replaceAll("%20", " ").substring(10).split("/");
		String pathPerInvio = request.getURI().getPath().replaceAll("%20", " ").substring(10);
		String pathDaControllare = null;
		if (partiDiPath.length > 1) {
			switch (partiDiPath[0]) {
			case "mail":
				pathDaControllare = partiDiPath[0] + "/" + partiDiPath[1];
				break;
			case "dettaglio-token":
				pathDaControllare = partiDiPath[0];
				token = partiDiPath[1];
				break;
			default:
				pathDaControllare = partiDiPath[0];
			}
		} else {
			pathDaControllare = partiDiPath[0];
		}

		JSONObject body = null;
		try {
			body = getBody(servletRequest);
			if (body != null)
				bodyString = body.toString();

		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			genericResponse.setEsito(new Esito(500, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		try {
			if (utenteService.isUtenteAuthorized(pathDaControllare, auth, body, token)) {
				httpEntity = new HttpEntity<GenericResponse>(restClient.sendRequest(
						pathBackEnd.concat(pathPerInvio), servletRequest.getMethod(), bodyString));
			}

		} catch (ServiceException e) {
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			genericResponse.setEsito(new Esito(500, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}

	private JSONObject getBody(HttpServletRequest request) throws IOException {
		JSONObject jsonObject = null;
		try {
			// Step 1: Obtain the InputStream from the request
			InputStream inputStream = request.getInputStream();
			if (inputStream.available() != 0) {
				// Step 2: Parse the JSON data into a data structure
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder jsonBuffer = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					jsonBuffer.append(line);
				}

				String jsonData = jsonBuffer.toString();

				jsonObject = new JSONObject(jsonData);
			}
		} catch (IOException e) {
			throw new IOException();
		}
		return jsonObject;
	}
}
