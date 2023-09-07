package it.sincrono.entity;

public class TipoCcnl {

	private Integer id;

	private String descrizione;

	private Integer numeroMensilita;

	public TipoCcnl(Integer id, String descrizione, Integer numeroMensilita) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroMensilita = numeroMensilita;
	}

	public TipoCcnl() {
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

	public Integer getNumeroMensilita() {
		return numeroMensilita;
	}

	public void setNumeroMensilita(Integer numeroMensilita) {
		this.numeroMensilita = numeroMensilita;
	}

}
