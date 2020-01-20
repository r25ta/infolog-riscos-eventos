package br.com.pamcary.api.evento.dao.model;

import java.io.Serializable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ctlUser;
    private long ctlVincd;
    private String usrName;
    private String nomUser;
    private String codSenha;
    private long ctlVincdEmb;
    private int ctlOperaTip;
    private String desOperaTip;
    
    
    
    
    
	public UsuarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public int getCtlUser() {
		return ctlUser;
	}
	public void setCtlUser(int ctlUser) {
		this.ctlUser = ctlUser;
	}
	public long getCtlVincd() {
		return ctlVincd;
	}
	public void setCtlVincd(long ctlVincd) {
		this.ctlVincd = ctlVincd;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getCodSenha() {
		return codSenha;
	}
	public void setCodSenha(String codSenha) {
		this.codSenha = new BCryptPasswordEncoder().encode(codSenha);
	}
	public long getCtlVincdEmb() {
		return ctlVincdEmb;
	}
	public void setCtlVincdEmb(long ctlVincdEmb) {
		this.ctlVincdEmb = ctlVincdEmb;
	}
	public int getCtlOperaTip() {
		return ctlOperaTip;
	}
	public void setCtlOperaTip(int ctlOperaTip) {
		this.ctlOperaTip = ctlOperaTip;
	}
	public String getDesOperaTip() {
		return desOperaTip;
	}
	public void setDesOperaTip(String desOperaTip) {
		this.desOperaTip = desOperaTip;
	}
	@Override
	public String toString() {
		return "UsuarioModel [ctlUser=" + ctlUser + ", ctlVincd=" + ctlVincd + ", usrName=" + usrName + ", nomUser="
				+ nomUser + ", codSenha=" + codSenha + ", ctlVincdEmb=" + ctlVincdEmb + ", ctlOperaTip=" + ctlOperaTip
				+ ", desOperaTip=" + desOperaTip + "]";
	}
    
    
    
}
