package it.sincrono.entity;

public class LivelloContratto {

	private Integer id;

	private String ccnl;

	private String livello;

	private String minimiRet23;

	public LivelloContratto(Integer id, String ccnl, String livello, String minimiRet23) {
		super();
		this.id = id;
		this.ccnl = ccnl;
		this.livello = livello;
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

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}

	public String getMinimiRet23() {
		return minimiRet23;
	}

	public void setMinimiRet23(String minimiRet23) {
		this.minimiRet23 = minimiRet23;
	}

}
