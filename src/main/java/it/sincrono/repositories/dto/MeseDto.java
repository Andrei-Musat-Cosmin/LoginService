package it.sincrono.repositories.dto;

import java.util.List;

public class MeseDto {

	private List<GiornoDto> mese;

	public MeseDto(List<GiornoDto> mese) {
		super();
		this.mese = mese;
	}

	public MeseDto() {
	}

	public List<GiornoDto> getMese() {
		return mese;
	}

	public void setMese(List<GiornoDto> mese) {
		this.mese = mese;
	}

}
