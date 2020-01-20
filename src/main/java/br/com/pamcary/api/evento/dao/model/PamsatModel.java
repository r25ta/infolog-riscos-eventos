package br.com.pamcary.api.evento.dao.model;

import java.io.Serializable;

public class PamsatModel implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ctlAlterSta;
	  private long ctlViagemKrona;
	  private String desPamsat; 
	  private String dhrAlter;
	  
	public long getCtlAlterSta() {
		return ctlAlterSta;
	}
	public void setCtlAlterSta(long ctlAlterSta) {
		this.ctlAlterSta = ctlAlterSta;
	}
	public long getCtlViagemKrona() {
		return ctlViagemKrona;
	}
	public void setCtlViagemKrona(long ctlViagemKrona) {
		this.ctlViagemKrona = ctlViagemKrona;
	}
	public String getDesPamsat() {
		return desPamsat;
	}
	public void setDesPamsat(String desPamsat) {
		this.desPamsat = desPamsat;
	}
	public String getDhrAlter() {
		return dhrAlter;
	}
	public void setDhrAlter(String dhrAlter) {
		this.dhrAlter = dhrAlter;
	}
	@Override
	public String toString() {
		return "PamsatModel [ctlAlterSta=" + ctlAlterSta + ", ctlViagemKrona=" + ctlViagemKrona + ", desPamsat="
				+ desPamsat + ", dhrAlter=" + dhrAlter + "]";
	}
	  
	  
}
