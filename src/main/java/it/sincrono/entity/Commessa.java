package it.sincrono.entity;

import java.util.Date;

public class Commessa {

	private Integer id;

	private String aziendaCliente;

	private String clienteFinale;

	private String titoloPosizione;

	private Boolean distacco;

	private String distaccoAzienda;

	private Date distaccoData;

	private Date dataInizio;

	private Date dataFine;

	private String tariffaGiornaliera;

	private String aziendaDiFatturazioneInterna;

	private Boolean attivo;

	public Commessa(Integer id, String aziendaCliente, String clienteFinale, String titoloPosizione, Boolean distacco,
			String distaccoAzienda, Date distaccoData, Date dataInizio, Date dataFine, String tariffaGiornaliera,
			String aziendaDiFatturazioneInterna, Boolean attivo) {
		super();
		this.id = id;
		this.aziendaCliente = aziendaCliente;
		this.clienteFinale = clienteFinale;
		this.titoloPosizione = titoloPosizione;
		this.distacco = distacco;
		this.distaccoAzienda = distaccoAzienda;
		this.distaccoData = distaccoData;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.tariffaGiornaliera = tariffaGiornaliera;
		this.aziendaDiFatturazioneInterna = aziendaDiFatturazioneInterna;
		this.attivo = attivo;
	}

	public Commessa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commessa(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAziendaCliente() {
		return aziendaCliente;
	}

	public void setAziendaCliente(String aziendaCliente) {
		this.aziendaCliente = aziendaCliente;
	}

	public String getClienteFinale() {
		return clienteFinale;
	}

	public void setClienteFinale(String clienteFinale) {
		this.clienteFinale = clienteFinale;
	}

	public String getTitoloPosizione() {
		return titoloPosizione;
	}

	public void setTitoloPosizione(String titoloPosizione) {
		this.titoloPosizione = titoloPosizione;
	}

	public Boolean getDistacco() {
		return distacco;
	}

	public void setDistacco(Boolean distacco) {
		this.distacco = distacco;
	}

	public String getDistaccoAzienda() {
		return distaccoAzienda;
	}

	public void setDistaccoAzienda(String distaccoAzienda) {
		this.distaccoAzienda = distaccoAzienda;
	}

	public Date getDistaccoData() {
		return distaccoData;
	}

	public void setDistaccoData(Date distaccoData) {
		this.distaccoData = distaccoData;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getTariffaGiornaliera() {
		return tariffaGiornaliera;
	}

	public void setTariffaGiornaliera(String tariffaGiornaliera) {
		this.tariffaGiornaliera = tariffaGiornaliera;
	}

	public String getAziendaDiFatturazioneInterna() {
		return aziendaDiFatturazioneInterna;
	}

	public void setAziendaDiFatturazioneInterna(String aziendaDiFatturazioneInterna) {
		this.aziendaDiFatturazioneInterna = aziendaDiFatturazioneInterna;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

}
