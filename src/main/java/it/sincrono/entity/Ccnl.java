package it.sincrono.entity;

public class Ccnl {

	private Integer id;

	private String descrizione;

	public Ccnl(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public Ccnl() {
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
