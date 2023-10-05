package it.sincrono.services.utils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

import it.sincrono.responses.AnagraficaDtoListResponse;
import it.sincrono.responses.AnagraficaDtoResponse;
import it.sincrono.responses.CommessaListResponse;
import it.sincrono.responses.ConfiguratorListResponse;
import it.sincrono.responses.ContrattoListResponse;
import it.sincrono.responses.FunzioniListResponse;
import it.sincrono.responses.GenericResponse;
import it.sincrono.responses.OperazioniListResponse;
import it.sincrono.responses.OrganicoDtoListResponse;
import it.sincrono.responses.RapportinoDtoResponse;
import it.sincrono.responses.RuoloListResponse;
import it.sincrono.responses.TipologicheListResponse;

@Component
public class RestClient {
	private static final Logger LOGGER = LogManager.getLogger(RestClient.class);

	private ResteasyClient client;

	public RestClient() {
		client = new ResteasyClientBuilder().build();
	}

	public GenericResponse sendRequest(String url, String method, String requestEntity) {
		ResteasyWebTarget target = client.target(url);

		Invocation.Builder builder = target.request();

		Response response;
		switch (method.toUpperCase()) {
		case "GET":
			response = builder.get();
			break;
		case "POST":
			response = builder.post(Entity.json(requestEntity));
			break;
		case "PUT":
			response = builder.put(Entity.json(requestEntity));
			break;
		case "DELETE":
			response = builder.delete();
			break;
		default:
			throw new IllegalArgumentException("Invalid HTTP method: " + method);
		}

		if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
			throw new RuntimeException("HTTP error code: " + response.getStatus());
		}

		LOGGER.log(Level.INFO, "Response: " + response.getEntity().getClass());

		GenericResponse responseBody = readEntity(response, method, url.substring(9).split("/")[1]);
		response.close();

		return responseBody;
	}

	private GenericResponse readEntity(Response response, String method, String url) {

		GenericResponse genericResponse = null;

		// Otteniamo la parte del percorso URL che ci interessa

		switch (url) {
		case "dettaglio":
			genericResponse = response.readEntity(AnagraficaDtoResponse.class);
			break;
		case "dettaglio-token":
			genericResponse = response.readEntity(AnagraficaDtoResponse.class);
			break;
		case "organico":
			genericResponse = response.readEntity(OrganicoDtoListResponse.class);
			break;
		case "storico-commesse":
			genericResponse = response.readEntity(CommessaListResponse.class);
			break;
		case "storico-contratti":
			genericResponse = response.readEntity(ContrattoListResponse.class);
			break;
		case "ruoli-map":
			genericResponse = response.readEntity(RuoloListResponse.class);
			break;
		case "operazioni":
			genericResponse = response.readEntity(OperazioniListResponse.class);
			break;
		case "funzioni-ruolo-tree":
			genericResponse = response.readEntity(FunzioniListResponse.class);
			break;
		case "filter":
		case "list":
		case "list-commesse":
		case "list-contratti":
		case "list-filter":
		case "list-all-commesse":
		case "anagrafica-list-contratti":
			genericResponse = response.readEntity(AnagraficaDtoListResponse.class);
			break;
		case "tipo-azienda-map":
		case "tipo-contratto-map":
		case "tipo-ccnl-map":
		case "tipo-livelli-contrattuali-map":
		case "tipo-causa-fine-rapporto-map":
		case "tipo-canale-reclutamento-map":
		case "livelli-by-ccnl":
			genericResponse = response.readEntity(TipologicheListResponse.class);
			break;
		case "get-list-configurator":
			genericResponse = response.readEntity(ConfiguratorListResponse.class);
			break;
		case "get-rapportino":
			genericResponse = response.readEntity(RapportinoDtoResponse.class);
			break;
		default:
			// Se nessun caso corrisponde, gestiamo di default
			genericResponse = response.readEntity(GenericResponse.class);
			break;
		}

		return genericResponse;

	}

	public void close() {
		client.close();
	}
}
