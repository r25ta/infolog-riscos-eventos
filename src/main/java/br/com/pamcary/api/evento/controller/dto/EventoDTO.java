package br.com.pamcary.api.evento.controller.dto;



public class EventoDTO {
	private long ctlPlvia;
	private String nomEntidade;
	private String cnpjEntidade;
	private String documentoProprio;
	private String codigoExterno;
	private long ctlPtopd;
	private int ordDesti;
	private int ctlParad;
	private String sigParad;
	private String dhrPreviSis;
	private String dhrEfetiRea;
	private String tipoJanela;

	public long getCtlPlvia() {
		return this.ctlPlvia;
	}

	public void setCtlPlvia(long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}

	public String getNomEntidade() {
		return this.nomEntidade;
	}

	public void setNomEntidade(String nomEntidade) {
		this.nomEntidade = nomEntidade;
	}

	public String getCnpjEntidade() {
		return this.cnpjEntidade;
	}

	public void setCnpjEntidade(String cnpjEntidade) {
		this.cnpjEntidade = cnpjEntidade;
	}

	public String getDocumentoProprio() {
		return this.documentoProprio;
	}

	public void setDocumentoProprio(String documentoProprio) {
		this.documentoProprio = documentoProprio;
	}

	public String getCodigoExterno() {
		return this.codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public long getCtlPtopd() {
		return this.ctlPtopd;
	}

	public void setCtlPtopd(long ctlPtopd) {
		this.ctlPtopd = ctlPtopd;
	}

	public int getOrdDesti() {
		return this.ordDesti;
	}

	public void setOrdDesti(int ordDesti) {
		this.ordDesti = ordDesti;
	}

	public int getCtlParad() {
		return this.ctlParad;
	}

	public void setCtlParad(int ctlParad) {
		this.ctlParad = ctlParad;
	}

	public String getSigParad() {
		return this.sigParad;
	}

	public void setSigParad(String sigParad) {
		this.sigParad = sigParad;
	}

	public String getDhrPreviSis() {
		return this.dhrPreviSis;
	}

	public void setDhrPreviSis(String dhrPreviSis) {
		this.dhrPreviSis = dhrPreviSis;
	}

	public String getDhrEfetiRea() {
		return this.dhrEfetiRea;
	}

	public void setDhrEfetiRea(String dhrEfetiRea) {
		this.dhrEfetiRea = dhrEfetiRea;
	}

	public String getTipoJanela() {
		return this.tipoJanela;
	}

	public void setTipoJanela(String tipoJanela) {
		this.tipoJanela = tipoJanela;
	}

	public String toString() {
		return "EventoDTO [ctlPlvia=" + this.ctlPlvia + ", nomEntidade=" + this.nomEntidade + ", cnpjEntidade="
				+ this.cnpjEntidade + ", documentoProprio=" + this.documentoProprio + ", codigoExterno="
				+ this.codigoExterno + ", ctlPtopd=" + this.ctlPtopd + ", ordDesti=" + this.ordDesti + ", ctlParad="
				+ this.ctlParad + ", sigParad=" + this.sigParad + ", dhrPreviSis=" + this.dhrPreviSis + ", dhrEfetiRea="
				+ this.dhrEfetiRea + ", tipoJanela=" + this.tipoJanela + "]";
	}
}
