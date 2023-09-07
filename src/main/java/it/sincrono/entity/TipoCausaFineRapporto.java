package it.sincrono.entity;

public class TipoCausaFineRapporto {

	private Integer id;

	private String descrizione;

	public TipoCausaFineRapporto(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public TipoCausaFineRapporto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
}
