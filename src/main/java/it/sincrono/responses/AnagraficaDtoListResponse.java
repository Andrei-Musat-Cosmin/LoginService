package it.sincrono.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import it.sincrono.beans.Esito;
import it.sincrono.repositories.dto.AnagraficaDto;

public class AnagraficaDtoListResponse extends GenericResponse {
	
	@JsonView()
	private List<AnagraficaDto> list;

	public AnagraficaDtoListResponse(Esito esito, List<AnagraficaDto> list) {
		super(esito);
		this.list = list;
	}

	public AnagraficaDtoListResponse() {
	}

	public List<AnagraficaDto> getList() {
		return list;
	}

	public void setList(List<AnagraficaDto> list) {
		this.list = list;
	}

}