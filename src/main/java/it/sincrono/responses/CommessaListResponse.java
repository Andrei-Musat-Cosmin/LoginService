package it.sincrono.responses;

import java.util.List;

import it.sincrono.beans.Esito;
import it.sincrono.entity.Commessa;

public class CommessaListResponse extends GenericResponse {
	private List<Commessa> list;

	public CommessaListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommessaListResponse(Esito esito) {
		super(esito);
		// TODO Auto-generated constructor stub
	}

	public List<Commessa> getList() {
		return list;
	}

	public void setList(List<Commessa> list) {
		this.list = list;
	}

	public CommessaListResponse(Esito esito, List<Commessa> list) {
		super(esito);
		this.list = list;
	}
}
