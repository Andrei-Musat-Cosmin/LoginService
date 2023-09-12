package it.sincrono.entity;

import java.util.Date;

public class Anagrafica {

	private Integer id;

	private String nome;

	private String cognome;

	private String codiceFiscale;

	private Utente utente;

	private TipoAzienda tipoAzienda;

	private String comuneDiNascita;

	private Date dataDiNascita;

	private String residenza;

	private String domicilio;

	private String cellularePrivato;

	private String cellulareAziendale;

	private String mailPrivata;

	private String mailAziendale;

	private String mailPec;

	private String titoliDiStudio;

	private String altriTitoli;

	private Boolean coniugato;

	private Boolean figliACarico;

	private Boolean attivo;

	private Boolean attesaLavori;

	public Anagrafica(Integer id, Utente utente, Boolean attivo, TipoAzienda tipoAzienda, String cognome, String nome,
			String codiceFiscale, String comuneDiNascita, Date dataDiNascita, String residenza, String domicilio,
			String cellularePrivato, String cellulareAziendale, String mailPrivata, String mailAziendale,
			String mailPec, String titoliDiStudio, String altriTitoli, Boolean coniugato, Boolean figliACarico,
			Boolean attesaLavori) {
		super();
		this.id = id;
		this.utente = utente;
		this.attivo = attivo;
		this.tipoAzienda = tipoAzienda;
		this.cognome = cognome;
		this.nome = nome;
		this.codiceFiscale = codiceFiscale;
		this.comuneDiNascita = comuneDiNascita;
		this.dataDiNascita = dataDiNascita;
		this.residenza = residenza;
		this.domicilio = domicilio;
		this.cellularePrivato = cellularePrivato;
		this.cellulareAziendale = cellulareAziendale;
		this.mailPrivata = mailPrivata;
		this.mailAziendale = mailAziendale;
		this.mailPec = mailPec;
		this.titoliDiStudio = titoliDiStudio;
		this.altriTitoli = altriTitoli;
		this.coniugato = coniugato;
		this.figliACarico = figliACarico;
		this.attesaLavori = attesaLavori;

	}

	public Anagrafica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anagrafica(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public TipoAzienda getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipoAzienda tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getComuneDiNascita() {
		return comuneDiNascita;
	}

	public void setComuneDiNascita(String comuneDiNascita) {
		this.comuneDiNascita = comuneDiNascita;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCellularePrivato() {
		return cellularePrivato;
	}

	public void setCellularePrivato(String cellularePrivato) {
		this.cellularePrivato = cellularePrivato;
	}

	public String getCellulareAziendale() {
		return cellulareAziendale;
	}

	public void setCellulareAziendale(String cellulareAziendale) {
		this.cellulareAziendale = cellulareAziendale;
	}

	public String getMailPrivata() {
		return mailPrivata;
	}

	public void setMailPrivata(String mailPrivata) {
		this.mailPrivata = mailPrivata;
	}

	public String getMailAziendale() {
		return mailAziendale;
	}

	public void setMailAziendale(String mailAziendale) {
		this.mailAziendale = mailAziendale;
	}

	public String getMailPec() {
		return mailPec;
	}

	public void setMailPec(String mailPec) {
		this.mailPec = mailPec;
	}

	public String getTitoliDiStudio() {
		return titoliDiStudio;
	}

	public void setTitoliDiStudio(String titoliDiStudio) {
		this.titoliDiStudio = titoliDiStudio;
	}

	public String getAltriTitoli() {
		return altriTitoli;
	}

	public void setAltriTitoli(String altriTitoli) {
		this.altriTitoli = altriTitoli;
	}

	public Boolean getConiugato() {
		return coniugato;
	}

	public void setConiugato(Boolean coniugato) {
		this.coniugato = coniugato;
	}

	public Boolean getFigliACarico() {
		return figliACarico;
	}

	public void setFigliACarico(Boolean figliACarico) {
		this.figliACarico = figliACarico;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Boolean getAttesaLavori() {
		return attesaLavori;
	}

	public void setAttesaLavori(Boolean attesaLavori) {
		this.attesaLavori = attesaLavori;
	}

}
