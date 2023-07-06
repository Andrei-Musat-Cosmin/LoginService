package it.sincrono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import it.sincrono.beans.Esito;
import it.sincrono.responses.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/services")
public class DispacerController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public DispacerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@SuppressWarnings({ "removal", "unchecked" })
	@RequestMapping("/**")
	public HttpEntity<GenericResponse> authorizeAndDispatch(HttpServletRequest servletRequest) {
		System.out.println("bella");
		HttpEntity<GenericResponse> httpEntity = null;
		GenericResponse genericResponse = new GenericResponse();
		ServletServerHttpRequest request = new ServletServerHttpRequest(servletRequest);

		// Extract headers from the original request
		HttpHeaders headers = new HttpHeaders();
		servletRequest.getHeaderNames().asIterator()
				.forEachRemaining(headerName -> headers.add(headerName, servletRequest.getHeader(headerName)));

		// Set the headers in the forwarded request
		HttpEntity<?> httpEntityRequest = new HttpEntity<>(request, headers);
		HttpEntity<?> responseEntity;

		try {
			responseEntity = restTemplate.exchange(
					"http://localhost:8085/".concat(request.getURI().getPath().substring(10)),
					HttpMethod.resolve(request.getMethodValue()), httpEntityRequest, HttpEntity.class);

			httpEntity = (HttpEntity<GenericResponse>) responseEntity;
			// genericResponse.setOggetto(authenticationService.authenticate(request).getToken());

		} catch (Exception e) {
			genericResponse.setEsito(new Esito(404, e.getMessage(), null));
			httpEntity = new HttpEntity<GenericResponse>(genericResponse);
		}

		return httpEntity;
	}

}
