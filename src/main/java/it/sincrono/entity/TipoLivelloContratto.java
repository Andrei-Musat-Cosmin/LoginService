package it.sincrono.entity;

public class TipoLivelloContratto {

	private Integer id;

	private String ccnl;

	private String livello;

	private Double minimiRet23;

	public TipoLivelloContratto(Integer id, String ccnl, String livello, Double minimiRet23) {
		super();
		this.id = id;
		this.ccnl = ccnl;
		this.livello = livello;
		this.minimiRet23 = minimiRet23;
	}

	public TipoLivelloContratto() {
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

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}

	public Double getMinimiRet23() {
		return minimiRet23;
	}

	public void setMinimiRet23(Double minimiRet23) {
		this.minimiRet23 = minimiRet23;
	}

	
}
