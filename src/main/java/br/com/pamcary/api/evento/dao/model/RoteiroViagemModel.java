package br.com.pamcary.api.evento.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RoteiroViagemModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long ctlRtmot;
	private long ctlPtopd;
	private String desEntidade;
	private String cnpjEntidade;
	private String documentoProprio;
	private String codigoExterno;
	private int ordDesti;	
	private int ctlParad;	
	private String sigParad;
	private String dhrPreviSis;
	private String dhrEfetiRea;
	private String dhrPreviMot;
	private String dhrTendeChg;
	private String tipoJanela;
	private String staTelef;
	private String sitFaseRea;
	private int numSeque;
	private String dhrManut;
	private String codUser;
	public long getCtlRtmot() {
		return ctlRtmot;
	}
	public void setCtlRtmot(long ctlRtmot) {
		this.ctlRtmot = ctlRtmot;
	}
	public long getCtlPtopd() {
		return ctlPtopd;
	}
	public void setCtlPtopd(long ctlPtopd) {
		this.ctlPtopd = ctlPtopd;
	}
	public String getDesEntidade() {
		return desEntidade;
	}
	public void setDesEntidade(String desEntidade) {
		this.desEntidade = desEntidade;
	}
	public String getCnpjEntidade() {
		return cnpjEntidade;
	}
	public void setCnpjEntidade(String cnpjEntidade) {
		this.cnpjEntidade = cnpjEntidade;
	}
	public String getDocumentoProprio() {
		return documentoProprio;
	}
	public void setDocumentoProprio(String documentoProprio) {
		this.documentoProprio = documentoProprio;
	}
	public String getCodigoExterno() {
		return codigoExterno;
	}
	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}
	public int getOrdDesti() {
		return ordDesti;
	}
	public void setOrdDesti(int ordDesti) {
		this.ordDesti = ordDesti;
	}
	public int getCtlParad() {
		return ctlParad;
	}
	public void setCtlParad(int ctlParad) {
		this.ctlParad = ctlParad;
	}
	public String getSigParad() {
		return sigParad;
	}
	public void setSigParad(String sigParad) {
		this.sigParad = sigParad;
	}
	public String getDhrPreviSis() {
		return dhrPreviSis;
	}
	public void setDhrPreviSis(String dhrPreviSis) {
		this.dhrPreviSis = dhrPreviSis;
	}
	public String getDhrEfetiRea() {
		return dhrEfetiRea;
	}
	public void setDhrEfetiRea(String dhrEfetiRea) {
		this.dhrEfetiRea = dhrEfetiRea;
	}
	public String getDhrPreviMot() {
		return dhrPreviMot;
	}
	public void setDhrPreviMot(String dhrPreviMot) {
		this.dhrPreviMot = dhrPreviMot;
	}
	public String getDhrTendeChg() {
		return dhrTendeChg;
	}
	public void setDhrTendeChg(String dhrTendeChg) {
		this.dhrTendeChg = dhrTendeChg;
	}
	public String getTipoJanela() {
		return tipoJanela;
	}
	public void setTipoJanela(String tipoJanela) {
		this.tipoJanela = tipoJanela;
	}
	public String getStaTelef() {
		return staTelef;
	}
	public void setStaTelef(String staTelef) {
		this.staTelef = staTelef;
	}
	public String getSitFaseRea() {
		return sitFaseRea;
	}
	public void setSitFaseRea(String sitFaseRea) {
		this.sitFaseRea = sitFaseRea;
	}
	public int getNumSeque() {
		return numSeque;
	}
	public void setNumSeque(int numSeque) {
		this.numSeque = numSeque;
	}
	public String getDhrManut() {
		return dhrManut;
	}
	public void setDhrManut(String dhrManut) {
		this.dhrManut = dhrManut;
	}
	public String getCodUser() {
		return codUser;
	}
	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	@Override
	public String toString() {
		return "RoteiroViagemModel [ctlRtmot=" + ctlRtmot + ", ctlPtopd=" + ctlPtopd + ", desEntidade=" + desEntidade
				+ ", cnpjEntidade=" + cnpjEntidade + ", documentoProprio=" + documentoProprio + ", codigoExterno="
				+ codigoExterno + ", ordDesti=" + ordDesti + ", ctlParad=" + ctlParad + ", sigParad=" + sigParad
				+ ", dhrPreviSis=" + dhrPreviSis + ", dhrEfetiRea=" + dhrEfetiRea + ", dhrPreviMot=" + dhrPreviMot
				+ ", dhrTendeChg=" + dhrTendeChg + ", tipoJanela=" + tipoJanela + ", staTelef=" + staTelef
				+ ", sitFaseRea=" + sitFaseRea + ", numSeque=" + numSeque + ", dhrManut=" + dhrManut + ", codUser="
				+ codUser + "]";
	}

	
	
	
	
}
