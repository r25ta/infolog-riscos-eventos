package br.com.pamcary.api.evento.dao.model;



import java.io.Serializable;

public class VeiculoDispositivoModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ctlVeicu;
	private String tecnologia;
	private String idRastreador;

	public long getCtlVeicu() {
		return this.ctlVeicu;
	}

	public void setCtlVeicu(long ctlVeicu) {
		this.ctlVeicu = ctlVeicu;
	}

	public String getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getIdRastreador() {
		return this.idRastreador;
	}

	public void setIdRastreador(String idRastreador) {
		this.idRastreador = idRastreador;
	}

	public String toString() {
		return "VeiculoDispositivoModel [ctlVeicu=" + this.ctlVeicu + ", tecnologia=" + this.tecnologia
				+ ", idRastreador=" + this.idRastreador + "]";
	}
}
