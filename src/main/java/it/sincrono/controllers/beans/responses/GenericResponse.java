package it.sincrono.controllers.beans.responses;

import it.sincrono.controllers.beans.Esito;


public class GenericResponse {
	private Esito esito;

	public GenericResponse(Esito esito) {
		super();
		this.esito = esito;
	}

	public Esito getEsito() {
		return esito;
	}

	public void setEsito(Esito esito) {
		this.esito = esito;
	}

	public GenericResponse() {
		super();
	}
	
	
	
	
}