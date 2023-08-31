package it.sincrono.entity;

import java.util.List;

public class Ruolo {

	private Integer id;

	private Ruolo ruolo;

	private String nome;

	private String descrizione;

	private transient List<Ruolo> ruoli;

	public Ruolo(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Ruolo(Integer id, Ruolo ruolo, String nome, String descrizione, List<Ruolo> ruoli) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.descrizione = descrizione;
		this.ruoli = ruoli;
	}

	public Ruolo(Integer id) {
		super();
		this.id = id;
	}

	public Ruolo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

}
