package it.sincrono.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import it.sincrono.beans.Esito;

public class GenericResponse implements Serializable {

	@JsonView(Esito.class)
	private Esito esito = new Esito();

	public GenericResponse(Esito esito) {
		super();
		this.esito = esito;
	}

	public GenericResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Esito getEsito() {
		return esito;
	}

	public void setEsito(Esito esito) {
		this.esito = esito;
	}

	// private Object oggetto;

}