package it.sincrono.responses;

import com.fasterxml.jackson.annotation.JsonView;

import it.sincrono.beans.Esito;
import it.sincrono.repositories.dto.AnagraficaDto;

public class AnagraficaDtoResponse extends GenericResponse {

	@JsonView(AnagraficaDto.class)
	private AnagraficaDto anagraficaDto;

	public AnagraficaDtoResponse(Esito esito, AnagraficaDto anagraficaDto) {
		super(esito);
		this.anagraficaDto = anagraficaDto;
	}

	public AnagraficaDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnagraficaDto getAnagraficaDto() {
		return anagraficaDto;
	}

	public void setAnagraficaDto(AnagraficaDto anagraficaDto) {
		this.anagraficaDto = anagraficaDto;
	}

}