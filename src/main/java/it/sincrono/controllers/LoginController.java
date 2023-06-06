package it.sincrono.controllers;





import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.controllers.beans.Esito;
import it.sincrono.controllers.beans.requests.AnagraficaRequest;
import it.sincrono.controllers.beans.requests.LoginRequest;
import it.sincrono.controllers.beans.responses.GenericResponse;
import it.sincrono.controllers.beans.responses.LoginResponse;
import it.sincrono.controllers.constants.ControllerMaps;
import it.sincrono.service.LoginService;
import it.sincrono.services.exceptions.ServiceException;
import it.sincrono.services.impl.JwtService;

import javax.servlet.http.Cookie;


@RestController
@CrossOrigin
public class LoginController extends BaseController {
	
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private JwtService jwtService;



    @PostMapping("/login")
    public @ResponseBody HttpEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
    	
    	HttpEntity<LoginResponse> httpEntity;

    	LoginResponse loginResponse = new LoginResponse();

		try {

			loginResponse.setUtente(jwtService.createJwtToken(loginRequest));

			httpEntity = new HttpEntity<LoginResponse>(loginResponse);


		} catch(SecurityException e) {
			loginResponse.setEsito(new Esito(null,e.getMessage()));
			httpEntity = new HttpEntity<LoginResponse>(loginResponse);
		}

		return httpEntity;
    }
	

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
    	
        Cookie cookie = new Cookie("jwtToken", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok("Logout effettuato con successo");
    }


	@RequestMapping(value = "public/ripristina-password", method = RequestMethod.POST, consumes = ControllerMaps.JSON)
	public @ResponseBody HttpEntity<GenericResponse> ripristinaPassword(@RequestBody AnagraficaRequest anagraficaRequest) {

		HttpEntity<GenericResponse> httpEntity;

		GenericResponse genericResponse = new GenericResponse();

		try {

			loginService.ripristinaPassword(anagraficaRequest.getAnagrafica());

			genericResponse.setEsito(new Esito());

			httpEntity = new HttpEntity<GenericResponse>(genericResponse);


		} catch(ServiceException e) {
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}

	@RequestMapping(value = "public/ripristina-password/{token}", method = RequestMethod.POST, consumes = ControllerMaps.JSON)
	public @ResponseBody HttpEntity<GenericResponse> ripristinaPassword(@PathVariable("token") String token, @RequestBody AnagraficaRequest anagraficaRequest) {

		HttpEntity<GenericResponse> httpEntity;

		GenericResponse genericResponse = new GenericResponse();

		try {

			loginService.ripristinaPassword(token, anagraficaRequest.getAnagrafica());

			genericResponse.setEsito(new Esito());

			httpEntity = new HttpEntity<GenericResponse>(genericResponse);


		} catch(ServiceException e) {
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}

	@RequestMapping(value = "/primo-accesso/{token}", method = RequestMethod.POST, consumes = ControllerMaps.JSON)
	public @ResponseBody HttpEntity<GenericResponse> primoAccesso(@PathVariable("token") String token, @RequestBody AnagraficaRequest anagraficaRequest) {

		HttpEntity<GenericResponse> httpEntity;

		GenericResponse genericResponse = new GenericResponse();

		try {

			loginService.primoAccesso(token, anagraficaRequest.getAnagrafica());

			genericResponse.setEsito(new Esito());

			httpEntity = new HttpEntity<GenericResponse>(genericResponse);


		} catch(ServiceException e) {
			genericResponse.setEsito(new Esito(e.getCode(), e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}
}