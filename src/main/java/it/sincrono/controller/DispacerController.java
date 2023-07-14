package it.sincrono.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import it.sincrono.beans.Esito;
import it.sincrono.responses.AnagraficaDtoListResponse;
import it.sincrono.responses.GenericResponse;
import it.sincrono.services.utils.RestClient;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/services")
public class DispacerController {


	
	@Autowired
	private RestClient restClient;



	@SuppressWarnings({ "removal", "unchecked" })
	@RequestMapping("/**")
	public HttpEntity<GenericResponse> authorizeAndDispatch(HttpServletRequest servletRequest) {

		HttpEntity<GenericResponse> httpEntity = null;
		
		GenericResponse genericResponse = new GenericResponse();
		
		ServletServerHttpRequest request = new ServletServerHttpRequest(servletRequest);


		try {
		
			
					
			httpEntity=  new HttpEntity<GenericResponse>(restClient.sendRequest("http://localhost:8085/".concat(request.getURI().getPath().substring(10)), 
					HttpMethod.resolve(request.getMethodValue()).toString(), getBody(servletRequest).toString()));
		
		} catch (Exception e) {
			genericResponse.setEsito(new Esito(404, e.getMessage(), null));
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
