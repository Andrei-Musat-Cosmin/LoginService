package it.sincrono.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.beans.Esito;
import it.sincrono.requests.EmailRequest;
import it.sincrono.requests.LoginRequest;
import it.sincrono.requests.RegisterRequest;
import it.sincrono.responses.GenericResponse;
import it.sincrono.responses.LoginResponse;
import it.sincrono.services.LoginService;
import it.sincrono.services.exceptions.ServiceException;
import it.sincrono.services.utils.RestClient;

@RestController
@RequestMapping("/login-service")
@CrossOrigin()
public class LoginController {
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
	
	@Value("${path-frontend.path}")
	private String pathFrontEnd;
	
	@Value("${path-backend.path}")
	private String pathBackEnd;

	@Autowired
	private LoginService loginService;

	@Autowired
	private RestClient restClient;

	@PostMapping("/login")
	public HttpEntity<LoginResponse> login(@RequestBody LoginRequest request) {

		HttpEntity<LoginResponse> httpEntity = null;

		LoginResponse authenticationResponse = new LoginResponse();

		LOGGER.info("Richiesta di login da parte di:" + request.getEmail() + ".");

		try {

			authenticationResponse.setToken(loginService.login(request).getToken());

			httpEntity = new HttpEntity<LoginResponse>(authenticationResponse);

		} catch (ServiceException e) {
			LOGGER.error(e.getMessage());
			authenticationResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<LoginResponse>(authenticationResponse);
		}
		return httpEntity;

	}

	@PostMapping("/recupero-password")
	public HttpEntity<GenericResponse> recuperoPassword(@RequestBody RegisterRequest request) {

		HttpEntity<GenericResponse> httpEntity = null;

		GenericResponse genericResponse = new GenericResponse();
		EmailRequest emailRequest = new EmailRequest(null, null, null, null, null);
		try {
			LOGGER.info("Richiesta di recupero password da parte di: " + request.getUsername() + ".");

			String jwtToken = loginService.recuperoPassword(request.getUsername());

			emailRequest.setTo(request.getUsername());
			emailRequest.setSubject("Link per il recupero password");
			emailRequest.setBody(pathFrontEnd+"form-recupero-password/" + jwtToken
					+ " Se non sei stato te a richiedere il reset della password," + " per favore ignora questa email");

			genericResponse = restClient.sendRequest(pathBackEnd+"mail/send", "POST",
					emailRequest.toString());

		} catch (ServiceException e) {
			LOGGER.error(e.getMessage());
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			genericResponse.setEsito(new Esito(500, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}
		LOGGER.info("Esito code: " + genericResponse.getEsito().getCode() + "; Esito message: "
				+ genericResponse.getEsito().getTarget());

		return httpEntity;
	}

}
