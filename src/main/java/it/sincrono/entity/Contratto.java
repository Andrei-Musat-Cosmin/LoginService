package it.sincrono.entity;

import java.util.Date;

public class Contratto {

	private Integer id;

	private TipoContratto tipoContratto;

	private TipoLivelloContratto tipoLivelloContratto;

	private TipoAzienda tipoAzienda;

	private TipoCcnl tipoCcnl;

	private TipoCanaleReclutamento tipoCanaleReclutamento;

	private TipoCausaFineRapporto tipoCausaFineRapporto;

	private Boolean attivo;

	private String qualifica;

	private String sedeAssunzione;

	private Date dataAssunzione;

	private Date dataInizioProva;

	private Date dataFineProva;

	private Date dataFineRapporto;

	private Integer mesiDurata;

	private String livelloAttuale;

	private String livelloFinale;

	private Boolean dimissioni;

	private Boolean partTime;

	private Double percentualePartTime;

	private Double retribuzioneMensileLorda;

	private Double superminimoMensile;

	private Double ralAnnua;

	private Double superminimoRal;

	private Double diariaMensile;

	private Double diariaGiornaliera;

	private Boolean ticket;

	private Double valoreTicket;

	private Boolean categoriaProtetta;

	private String tutor;

	private String pfi;

	private Boolean corsoSicurezza;

	private Date dataCorsoSicurezza;

	private Boolean pc;

	private Boolean visitaMedica;

	private Date dataVisitaMedica;

	private Double scattiAnzianita;

	private Double tariffaPartitaIva;

	private Boolean assicurazioneObbligatoria;

	private Double retribuzioneNettaGiornaliera;

	private Double retribuzioneNettaMensile;

	private Double diariaAnnua;

	public Contratto(Integer id, TipoContratto tipoContratto, TipoLivelloContratto tipoLivelloContratto,
			TipoAzienda tipoAzienda, TipoCcnl tipoCcnl, TipoCanaleReclutamento tipoCanaleReclutamento,
			TipoCausaFineRapporto tipoCausaFineRapporto, Boolean attivo, String qualifica, String sedeAssunzione,
			Date dataAssunzione, Date dataInizioProva, Date dataFineProva, Date dataFineRapporto, Integer mesiDurata,
			String livelloAttuale, String livelloFinale, Boolean dimissioni, Boolean partTime,
			Double percentualePartTime, Double retribuzioneMensileLorda, Double superminimoMensile, Double ralAnnua,
			Double superminimoRal, Double diariaMensile, Double diariaGiornaliera, Boolean ticket, Double valoreTicket,
			Boolean categoriaProtetta, String tutor, String pfi, Boolean corsoSicurezza, Date dataCorsoSicurezza,
			Boolean pc, Boolean visitaMedica, Date dataVisitaMedica, Double scattiAnzianita, Double tariffaPartitaIva,
			Boolean assicurazioneObbligatoria, Double retribuzioneNettaGiornaliera, Double retribuzioneNettaMensile,
			Double diariaAnnua) {
		super();
		this.id = id;
		this.tipoContratto = tipoContratto;
		this.tipoLivelloContratto = tipoLivelloContratto;
		this.tipoAzienda = tipoAzienda;
		this.tipoCcnl = tipoCcnl;
		this.tipoCanaleReclutamento = tipoCanaleReclutamento;
		this.tipoCausaFineRapporto = tipoCausaFineRapporto;
		this.attivo = attivo;
		this.qualifica = qualifica;
		this.sedeAssunzione = sedeAssunzione;
		this.dataAssunzione = dataAssunzione;
		this.dataInizioProva = dataInizioProva;
		this.dataFineProva = dataFineProva;
		this.dataFineRapporto = dataFineRapporto;
		this.mesiDurata = mesiDurata;
		this.livelloAttuale = livelloAttuale;
		this.livelloFinale = livelloFinale;
		this.dimissioni = dimissioni;
		this.partTime = partTime;
		this.percentualePartTime = percentualePartTime;
		this.retribuzioneMensileLorda = retribuzioneMensileLorda;
		this.superminimoMensile = superminimoMensile;
		this.ralAnnua = ralAnnua;
		this.superminimoRal = superminimoRal;
		this.diariaMensile = diariaMensile;
		this.diariaGiornaliera = diariaGiornaliera;
		this.ticket = ticket;
		this.valoreTicket = valoreTicket;
		this.categoriaProtetta = categoriaProtetta;
		this.tutor = tutor;
		this.pfi = pfi;
		this.corsoSicurezza = corsoSicurezza;
		this.dataCorsoSicurezza = dataCorsoSicurezza;
		this.pc = pc;
		this.visitaMedica = visitaMedica;
		this.dataVisitaMedica = dataVisitaMedica;
		this.scattiAnzianita = scattiAnzianita;
		this.tariffaPartitaIva = tariffaPartitaIva;
		this.assicurazioneObbligatoria = assicurazioneObbligatoria;
		this.retribuzioneNettaGiornaliera = retribuzioneNettaGiornaliera;
		this.retribuzioneNettaMensile = retribuzioneNettaMensile;
		this.diariaAnnua = diariaAnnua;
	}

	public Contratto(TipoContratto tipoContratto, TipoAzienda tipoAzienda, TipoCcnl tipoCcnl) {
		super();
		this.tipoContratto = tipoContratto;
		this.tipoAzienda = tipoAzienda;
		this.tipoCcnl = tipoCcnl;
	}

	public Contratto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contratto(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoContratto getTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(TipoContratto tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	public TipoLivelloContratto getTipoLivelloContratto() {
		return tipoLivelloContratto;
	}

	public void setTipoLivelloContratto(TipoLivelloContratto tipoLivelloContratto) {
		this.tipoLivelloContratto = tipoLivelloContratto;
	}

	public TipoAzienda getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipoAzienda tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public TipoCcnl getTipoCcnl() {
		return tipoCcnl;
	}

	public void setTipoCcnl(TipoCcnl tipoCcnl) {
		this.tipoCcnl = tipoCcnl;
	}

	public TipoCanaleReclutamento getTipoCanaleReclutamento() {
		return tipoCanaleReclutamento;
	}

	public void setTipoCanaleReclutamento(TipoCanaleReclutamento tipoCanaleReclutamento) {
		this.tipoCanaleReclutamento = tipoCanaleReclutamento;
	}

	public TipoCausaFineRapporto getTipoCausaFineRapporto() {
		return tipoCausaFineRapporto;
	}

	public void setTipoCausaFineRapporto(TipoCausaFineRapporto tipoCausaFineRapporto) {
		this.tipoCausaFineRapporto = tipoCausaFineRapporto;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public String getSedeAssunzione() {
		return sedeAssunzione;
	}

	public void setSedeAssunzione(String sedeAssunzione) {
		this.sedeAssunzione = sedeAssunzione;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Date getDataInizioProva() {
		return dataInizioProva;
	}

	public void setDataInizioProva(Date dataInizioProva) {
		this.dataInizioProva = dataInizioProva;
	}

	public Date getDataFineProva() {
		return dataFineProva;
	}

	public void setDataFineProva(Date dataFineProva) {
		this.dataFineProva = dataFineProva;
	}

	public Date getDataFineRapporto() {
		return dataFineRapporto;
	}

	public void setDataFineRapporto(Date dataFineRapporto) {
		this.dataFineRapporto = dataFineRapporto;
	}

	public Integer getMesiDurata() {
		return mesiDurata;
	}

	public void setMesiDurata(Integer mesiDurata) {
		this.mesiDurata = mesiDurata;
	}

	public String getLivelloAttuale() {
		return livelloAttuale;
	}

	public void setLivelloAttuale(String livelloAttuale) {
		this.livelloAttuale = livelloAttuale;
	}

	public String getLivelloFinale() {
		return livelloFinale;
	}

	public void setLivelloFinale(String livelloFinale) {
		this.livelloFinale = livelloFinale;
	}

	public Boolean getDimissioni() {
		return dimissioni;
	}

	public void setDimissioni(Boolean dimissioni) {
		this.dimissioni = dimissioni;
	}

	public Boolean getPartTime() {
		return partTime;
	}

	public void setPartTime(Boolean partTime) {
		this.partTime = partTime;
	}

	public Double getPercentualePartTime() {
		return percentualePartTime;
	}

	public void setPercentualePartTime(Double percentualePartTime) {
		this.percentualePartTime = percentualePartTime;
	}

	public Double getRetribuzioneMensileLorda() {
		return retribuzioneMensileLorda;
	}

	public void setRetribuzioneMensileLorda(Double retribuzioneMensileLorda) {
		this.retribuzioneMensileLorda = retribuzioneMensileLorda;
	}

	public Double getSuperminimoMensile() {
		return superminimoMensile;
	}

	public void setSuperminimoMensile(Double superminimoMensile) {
		this.superminimoMensile = superminimoMensile;
	}

	public Double getRalAnnua() {
		return ralAnnua;
	}

	public void setRalAnnua(Double ralAnnua) {
		this.ralAnnua = ralAnnua;
	}

	public Double getSuperminimoRal() {
		return superminimoRal;
	}

	public void setSuperminimoRal(Double superminimoRal) {
		this.superminimoRal = superminimoRal;
	}

	public Double getDiariaMensile() {
		return diariaMensile;
	}

	public void setDiariaMensile(Double diariaMensile) {
		this.diariaMensile = diariaMensile;
	}

	public Double getDiariaGiornaliera() {
		return diariaGiornaliera;
	}

	public void setDiariaGiornaliera(Double diariaGiornaliera) {
		this.diariaGiornaliera = diariaGiornaliera;
	}

	public Boolean getTicket() {
		return ticket;
	}

	public void setTicket(Boolean ticket) {
		this.ticket = ticket;
	}

	public Double getValoreTicket() {
		return valoreTicket;
	}

	public void setValoreTicket(Double valoreTicket) {
		this.valoreTicket = valoreTicket;
	}

	public Boolean getCategoriaProtetta() {
		return categoriaProtetta;
	}

	public void setCategoriaProtetta(Boolean categoriaProtetta) {
		this.categoriaProtetta = categoriaProtetta;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getPfi() {
		return pfi;
	}

	public void setPfi(String pfi) {
		this.pfi = pfi;
	}

	public Boolean getCorsoSicurezza() {
		return corsoSicurezza;
	}

	public void setCorsoSicurezza(Boolean corsoSicurezza) {
		this.corsoSicurezza = corsoSicurezza;
	}

	public Date getDataCorsoSicurezza() {
		return dataCorsoSicurezza;
	}

	public void setDataCorsoSicurezza(Date dataCorsoSicurezza) {
		this.dataCorsoSicurezza = dataCorsoSicurezza;
	}

	public Boolean getPc() {
		return pc;
	}

	public void setPc(Boolean pc) {
		this.pc = pc;
	}

	public Boolean getVisitaMedica() {
		return visitaMedica;
	}

	public void setVisitaMedica(Boolean visitaMedica) {
		this.visitaMedica = visitaMedica;
	}

	public Date getDataVisitaMedica() {
		return dataVisitaMedica;
	}

	public void setDataVisitaMedica(Date dataVisitaMedica) {
		this.dataVisitaMedica = dataVisitaMedica;
	}

	public Double getScattiAnzianita() {
		return scattiAnzianita;
	}

	public void setScattiAnzianita(Double scattiAnzianita) {
		this.scattiAnzianita = scattiAnzianita;
	}

	public Double getTariffaPartitaIva() {
		return tariffaPartitaIva;
	}

	public void setTariffaPartitaIva(Double tariffaPartitaIva) {
		this.tariffaPartitaIva = tariffaPartitaIva;
	}

	public Boolean getAssicurazioneObbligatoria() {
		return assicurazioneObbligatoria;
	}

	public void setAssicurazioneObbligatoria(Boolean assicurazioneObbligatoria) {
		this.assicurazioneObbligatoria = assicurazioneObbligatoria;
	}

	public Double getRetribuzioneNettaGiornaliera() {
		return retribuzioneNettaGiornaliera;
	}

	public void setRetribuzioneNettaGiornaliera(Double retribuzioneNettaGiornaliera) {
		this.retribuzioneNettaGiornaliera = retribuzioneNettaGiornaliera;
	}

	public Double getRetribuzioneNettaMensile() {
		return retribuzioneNettaMensile;
	}

	public void setRetribuzioneNettaMensile(Double retribuzioneNettaMensile) {
		this.retribuzioneNettaMensile = retribuzioneNettaMensile;
	}

	public Double getDiariaAnnua() {
		return diariaAnnua;
	}

	public void setDiariaAnnua(Double diariaAnnua) {
		this.diariaAnnua = diariaAnnua;
	}

}
