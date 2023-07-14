package it.sincrono.entity;

import java.util.Date;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Commessa {


	private Integer id;

	private String cliente;

	private String clienteFinale;

	private String titoloPosizione;

	private String distacco;

	private Date dataInizio;

	private Date dataFine;

	private String costoMese;

	private String tariffaGiornaliera;

	private String nominativo;

	private String azienda;

	private String aziendaDiFatturazioneInterna;

	private Boolean stato;

	private String attesaLavori;

	public Commessa(Integer id, String cliente, String clienteFinale, String titoloPosizione, String distacco,
			Date dataInizio, Date dataFine, String costoMese, String tariffaGiornaliera, String nominativo,
			String azienda, String aziendaDiFatturazioneInterna, Boolean stato, String attesaLavori) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.clienteFinale = clienteFinale;
		this.titoloPosizione = titoloPosizione;
		this.distacco = distacco;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.costoMese = costoMese;
		this.tariffaGiornaliera = tariffaGiornaliera;
		this.nominativo = nominativo;
		this.azienda = azienda;
		this.aziendaDiFatturazioneInterna = aziendaDiFatturazioneInterna;
		this.stato = stato;
		this.attesaLavori = attesaLavori;

	}

	public Commessa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(attesaLavori, azienda, aziendaDiFatturazioneInterna, cliente, clienteFinale, costoMese,
				dataFine, dataInizio, distacco, id, nominativo, stato, tariffaGiornaliera, titoloPosizione);
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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

	public String getDistacco() {
		return distacco;
	}

	public void setDistacco(String distacco) {
		this.distacco = distacco;
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

	public String getCostoMese() {
		return costoMese;
	}

	public void setCostoMese(String costoMese) {
		this.costoMese = costoMese;
	}

	public String getTariffaGiornaliera() {
		return tariffaGiornaliera;
	}

	public void setTariffaGiornaliera(String tariffaGiornaliera) {
		this.tariffaGiornaliera = tariffaGiornaliera;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public String getAziendaDiFatturazioneInterna() {
		return aziendaDiFatturazioneInterna;
	}

	public void setAziendaDiFatturazioneInterna(String aziendaDiFatturazioneInterna) {
		this.aziendaDiFatturazioneInterna = aziendaDiFatturazioneInterna;
	}

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public String getAttesaLavori() {
		return attesaLavori;
	}

	public void setAttesaLavori(String attesaLavori) {
		this.attesaLavori = attesaLavori;
	}

}
