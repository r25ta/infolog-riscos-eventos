package br.com.pamcary.api.evento.dao.model;




import java.io.Serializable;

public class EventoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ctlPlvia;
	private String nomEntidade;
	private String cnpjEntidade;
	private String documentoProprio;
	private String codigoExterno;
	private Long ctlPtopd;
	private int ordDesti;
	private int ctlParad;
	private String sigParad;
	private String dhrPreviSis;
	private String dhrEfetiRea;
	private String tipoJanela;
	public Long getCtlPlvia() {
		return ctlPlvia;
	}
	public void setCtlPlvia(Long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}
	public String getNomEntidade() {
		return nomEntidade;
	}
	public void setNomEntidade(String nomEntidade) {
		this.nomEntidade = nomEntidade;
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
	public Long getCtlPtopd() {
		return ctlPtopd;
	}
	public void setCtlPtopd(Long ctlPtopd) {
		this.ctlPtopd = ctlPtopd;
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
	public String getTipoJanela() {
		return tipoJanela;
	}
	public void setTipoJanela(String tipoJanela) {
		this.tipoJanela = tipoJanela;
	}
	@Override
	public String toString() {
		return "EventoEntity [ctlPlvia=" + ctlPlvia + ", nomEntidade=" + nomEntidade + ", cnpjEntidade=" + cnpjEntidade
				+ ", documentoProprio=" + documentoProprio + ", codigoExterno=" + codigoExterno + ", ctlPtopd="
				+ ctlPtopd + ", ordDesti=" + ordDesti + ", ctlParad=" + ctlParad + ", sigParad=" + sigParad
				+ ", dhrPreviSis=" + dhrPreviSis + ", dhrEfetiRea=" + dhrEfetiRea + ", tipoJanela=" + tipoJanela + "]";
	}
	
	
	

}
