package it.sincrono.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class LivelloContratto {


	private Integer id;


	private String ccnl;


	private String descrizione;

	private String minimiRet23;

	public LivelloContratto(Integer id, String ccnl, String descrizione, String minimiRet23) {
		super();
		this.id = id;
		this.ccnl = ccnl;
		this.descrizione = descrizione;
		this.minimiRet23 = minimiRet23;
	}

	public LivelloContratto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCcnl() {
		return ccnl;
	}

	public void setCcnl(String ccnl) {
		this.ccnl = ccnl;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMinimiRet23() {
		return minimiRet23;
	}

	public void setMinimiRet23(String minimiRet23) {
		this.minimiRet23 = minimiRet23;
	}

}
