package br.com.pamcary.api.evento.dao.model;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class DestinoViagemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ctlPlvia;
	private Long ctlDesti;
	private String nomDesti;
	private Long numConsiMer;
	private String nomConsiMer;
	private String dhrPlviaTer;
	private int ordDesti;
	private int sitPlvia;
	private String desPlvia;
	private String sigOrdemEve;
	private String tipoJanela;
	private Long ctlRotaGri;
	private List<RoteiroViagemModel> eventos;

	public Long getCtlPlvia() {
		return this.ctlPlvia;
	}

	public void setCtlPlvia(Long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}

	public Long getCtlDesti() {
		return this.ctlDesti;
	}

	public void setCtlDesti(Long ctlDesti) {
		this.ctlDesti = ctlDesti;
	}

	public String getNomDesti() {
		return this.nomDesti;
	}

	public void setNomDesti(String nomDesti) {
		this.nomDesti = nomDesti;
	}

	public Long getNumConsiMer() {
		return this.numConsiMer;
	}

	public void setNumConsiMer(Long numConsiMer) {
		this.numConsiMer = numConsiMer;
	}

	public String getNomConsiMer() {
		return this.nomConsiMer;
	}

	public void setNomConsiMer(String nomConsiMer) {
		this.nomConsiMer = nomConsiMer;
	}

	public String getDhrPlviaTer() {
		return this.dhrPlviaTer;
	}

	public void setDhrPlviaTer(String dhrPlviaTer) {
		this.dhrPlviaTer = dhrPlviaTer;
	}

	public int getOrdDesti() {
		return this.ordDesti;
	}

	public void setOrdDesti(int ordDesti) {
		this.ordDesti = ordDesti;
	}

	public int getSitPlvia() {
		return this.sitPlvia;
	}

	public void setSitPlvia(int sitPlvia) {
		this.sitPlvia = sitPlvia;
	}

	public String getDesPlvia() {
		return this.desPlvia;
	}

	public void setDesPlvia(String desPlvia) {
		this.desPlvia = desPlvia;
	}

	public String getSigOrdemEve() {
		return this.sigOrdemEve;
	}

	public void setSigOrdemEve(String sigOrdemEve) {
		this.sigOrdemEve = sigOrdemEve;
	}

	public String getTipoJanela() {
		return this.tipoJanela;
	}

	public void setTipoJanela(String tipoJanela) {
		this.tipoJanela = tipoJanela;
	}

	public Long getCtlRotaGri() {
		return this.ctlRotaGri;
	}

	public void setCtlRotaGri(Long ctlRotaGri) {
		this.ctlRotaGri = ctlRotaGri;
	}

	public List<RoteiroViagemModel> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<RoteiroViagemModel> eventos) {
		this.eventos = eventos;
	}

	public String toString() {
		return "DestinatarioViagemModel [ctlPlvia=" + this.ctlPlvia + ", ctlDesti=" + this.ctlDesti + ", nomDesti="
				+ this.nomDesti + ", numConsiMer=" + this.numConsiMer + ", nomConsiMer=" + this.nomConsiMer
				+ ", dhrPlviaTer=" + this.dhrPlviaTer + ", ordDesti=" + this.ordDesti + ", sitPlvia=" + this.sitPlvia
				+ ", desPlvia=" + this.desPlvia + ", sigOrdemEve=" + this.sigOrdemEve + ", tipoJanela="
				+ this.tipoJanela + ", ctlRotaGri=" + this.ctlRotaGri + ", eventos=" + this.eventos + "]";
	}
}
