package it.sincrono.beans;

public class Esito {

	private Integer code = 0;
	private String target = null;
	private String[] args = null;

	public Esito(Integer code, String target, String[] args) {
		super();
		this.code = code;
		this.target = target;
		this.args = args;
	}

	public Esito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

}