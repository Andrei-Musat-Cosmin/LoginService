package it.sincrono.entity;

import java.util.Date;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


public class Contratto {

	
	private Integer id;

	
	private TipoContratto tipoContratto;

	private LivelloContratto livelloContratto;

	private TipoAzienda tipoAzienda;

	private ContrattoNazionale contrattoNazionale;

	private Boolean attivo;

	private String sedeAssunzione;

	private String qualifica;

	private Date dataAssunzione;

	private Date dataInizioProva;

	private Date dataFineProva;

	private Date dataFineRapporto;

	private Integer mesiDurata;

	private String livelloAttuale;

	private String livelloFinale;

	private Boolean dimissioni;

	private Boolean partTime;

	private Boolean partTimeA;

	private String retribuzioneMensileLorda;

	private String superminimoMensile;

	private String ralAnnua;

	private String superminimoRal;

	private String diariaMese;

	private String diariaGg;

//	@Column(name = "data_visita_medica")
//	private Date dataVisitaMedica;
	
	private String ticket;

	private String valoreTicket;

	private Boolean categoriaProtetta;

	private String tutor;

	private String pfi;

	private String assicurazioneObbligatoria;

	private Date corsoSicurezza;

	private String motivazioneFineRapporto;

	private Boolean pc;

	private String scattiAnzianita;

	private String tariffaPartitaIva;

	private String canaleReclutamento;

	public Contratto(Integer id, TipoContratto tipoContratto, LivelloContratto livelloContratto,
			TipoAzienda tipoAzienda, ContrattoNazionale contrattoNazionale, Boolean attivo, String sedeAssunzione,
			String qualifica, Date dataAssunzione, Date dataInizioProva, Date dataFineProva, Date dataFineRapporto,
			Integer mesiDurata, String livelloAttuale, String livelloFinale, Boolean dimissioni,
			Boolean partTime, Boolean partTimeA, String retribuzioneMensileLorda, String superminimoMensile,
			String ralAnnua, String superminimoRal, String diariaMese, String diariaGg, String ticket,
			String valoreTicket, Boolean categoriaProtetta, String tutor, String pfi, String assicurazioneObbligatoria,
			Date corsoSicurezza, String motivazioneFineRapporto, Boolean pc, String scattiAnzianita,
			String tariffaPartitaIva, String canaleReclutamento) {
		super();
		this.id = id;
		this.tipoContratto = tipoContratto;
		this.livelloContratto = livelloContratto;
		this.tipoAzienda = tipoAzienda;
		this.contrattoNazionale = contrattoNazionale;
		this.attivo = attivo;
		this.sedeAssunzione = sedeAssunzione;
		this.qualifica = qualifica;
		this.dataAssunzione = dataAssunzione;
		this.dataInizioProva = dataInizioProva;
		this.dataFineProva = dataFineProva;
		this.dataFineRapporto = dataFineRapporto;
		this.mesiDurata = mesiDurata;
		this.livelloAttuale = livelloAttuale;
		this.livelloFinale = livelloFinale;
		this.dimissioni = dimissioni;
		this.partTime = partTime;
		this.partTimeA = partTimeA;
		this.retribuzioneMensileLorda = retribuzioneMensileLorda;
		this.superminimoMensile = superminimoMensile;
		this.ralAnnua = ralAnnua;
		this.superminimoRal = superminimoRal;
		this.diariaMese = diariaMese;
		this.diariaGg = diariaGg;
		this.ticket = ticket;
		this.valoreTicket = valoreTicket;
		this.categoriaProtetta = categoriaProtetta;
		this.tutor = tutor;
		this.pfi = pfi;
		this.assicurazioneObbligatoria = assicurazioneObbligatoria;
		this.corsoSicurezza = corsoSicurezza;
		this.motivazioneFineRapporto = motivazioneFineRapporto;
		this.pc = pc;
		this.scattiAnzianita = scattiAnzianita;
		this.tariffaPartitaIva = tariffaPartitaIva;
		this.canaleReclutamento = canaleReclutamento;

	}

	public Contratto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(assicurazioneObbligatoria, attivo, canaleReclutamento, categoriaProtetta,
				contrattoNazionale, corsoSicurezza, dataAssunzione, dataFineProva, dataFineRapporto, dataInizioProva,
				diariaGg, diariaMese, dimissioni, id, livelloAttuale, livelloContratto, livelloFinale, mesiDurata,
				motivazioneFineRapporto, partTime, partTimeA, pc, pfi, qualifica, ralAnnua, retribuzioneMensileLorda,
				scattiAnzianita, sedeAssunzione, superminimoMensile, superminimoRal, tariffaPartitaIva, ticket,
				tipoAzienda, tipoContratto, tutor, valoreTicket);
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

	public LivelloContratto getLivelloContratto() {
		return livelloContratto;
	}

	public void setLivelloContratto(LivelloContratto livelloContratto) {
		this.livelloContratto = livelloContratto;
	}

	public TipoAzienda getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipoAzienda tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public ContrattoNazionale getContrattoNazionale() {
		return contrattoNazionale;
	}

	public void setContrattoNazionale(ContrattoNazionale contrattoNazionale) {
		this.contrattoNazionale = contrattoNazionale;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public String getSedeAssunzione() {
		return sedeAssunzione;
	}

	public void setSedeAssunzione(String sedeAssunzione) {
		this.sedeAssunzione = sedeAssunzione;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
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

	public Boolean getPartTimeA() {
		return partTimeA;
	}

	public void setPartTimeA(Boolean partTimeA) {
		this.partTimeA = partTimeA;
	}

	public String getRetribuzioneMensileLorda() {
		return retribuzioneMensileLorda;
	}

	public void setRetribuzioneMensileLorda(String retribuzioneMensileLorda) {
		this.retribuzioneMensileLorda = retribuzioneMensileLorda;
	}

	public String getSuperminimoMensile() {
		return superminimoMensile;
	}

	public void setSuperminimoMensile(String superminimoMensile) {
		this.superminimoMensile = superminimoMensile;
	}

	public String getRalAnnua() {
		return ralAnnua;
	}

	public void setRalAnnua(String ralAnnua) {
		this.ralAnnua = ralAnnua;
	}

	public String getSuperminimoRal() {
		return superminimoRal;
	}

	public void setSuperminimoRal(String superminimoRal) {
		this.superminimoRal = superminimoRal;
	}

	public String getDiariaMese() {
		return diariaMese;
	}

	public void setDiariaMese(String diariaMese) {
		this.diariaMese = diariaMese;
	}

	public String getDiariaGg() {
		return diariaGg;
	}

	public void setDiariaGg(String diariaGg) {
		this.diariaGg = diariaGg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getValoreTicket() {
		return valoreTicket;
	}

	public void setValoreTicket(String valoreTicket) {
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

	public String getAssicurazioneObbligatoria() {
		return assicurazioneObbligatoria;
	}

	public void setAssicurazioneObbligatoria(String assicurazioneObbligatoria) {
		this.assicurazioneObbligatoria = assicurazioneObbligatoria;
	}

	public Date getCorsoSicurezza() {
		return corsoSicurezza;
	}

	public void setCorsoSicurezza(Date corsoSicurezza) {
		this.corsoSicurezza = corsoSicurezza;
	}

	public String getMotivazioneFineRapporto() {
		return motivazioneFineRapporto;
	}

	public void setMotivazioneFineRapporto(String motivazioneFineRapporto) {
		this.motivazioneFineRapporto = motivazioneFineRapporto;
	}

	public Boolean getPc() {
		return pc;
	}

	public void setPc(Boolean pc) {
		this.pc = pc;
	}

	public String getScattiAnzianita() {
		return scattiAnzianita;
	}

	public void setScattiAnzianita(String scattiAnzianita) {
		this.scattiAnzianita = scattiAnzianita;
	}

	public String getTariffaPartitaIva() {
		return tariffaPartitaIva;
	}

	public void setTariffaPartitaIva(String tariffaPartitaIva) {
		this.tariffaPartitaIva = tariffaPartitaIva;
	}

	public String getCanaleReclutamento() {
		return canaleReclutamento;
	}

	public void setCanaleReclutamento(String canaleReclutamento) {
		this.canaleReclutamento = canaleReclutamento;
	}

	public Contratto(TipoContratto tipoContratto, TipoAzienda tipoAzienda, ContrattoNazionale contrattoNazionale) {
		super();
		this.tipoContratto = tipoContratto;
		this.tipoAzienda = tipoAzienda;
		this.contrattoNazionale = contrattoNazionale;
	}

}
