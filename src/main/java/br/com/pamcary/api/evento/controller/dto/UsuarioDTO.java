package br.com.pamcary.api.evento.controller.dto;

public class UsuarioDTO {
	private int ctlUser;
	private long ctlVincd;
	private String usrName;
	private String nomUser;
	private String codSenha;
	private long ctlVincdEmb;
	private int ctlOperaTip;
	private String desOperaTip;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String usrName, String codSenha, int ctlOperaTip) {
		this.usrName = usrName;
		this.codSenha = codSenha;
		this.ctlOperaTip = ctlOperaTip;
	}

	public int getCtlUser() {
		return this.ctlUser;
	}

	public void setCtlUser(int ctlUser) {
		this.ctlUser = ctlUser;
	}

	public long getCtlVincd() {
		return this.ctlVincd;
	}

	public void setCtlVincd(long ctlVincd) {
		this.ctlVincd = ctlVincd;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getCodSenha() {
		return this.codSenha;
	}

	public void setCodSenha(String codSenha) {
		this.codSenha = codSenha;
	}

	public long getCtlVincdEmb() {
		return this.ctlVincdEmb;
	}

	public void setCtlVincdEmb(long ctlVincdEmb) {
		this.ctlVincdEmb = ctlVincdEmb;
	}

	public int getCtlOperaTip() {
		return this.ctlOperaTip;
	}

	public void setCtlOperaTip(int ctlOperaTip) {
		this.ctlOperaTip = ctlOperaTip;
	}

	public String getDesOperaTip() {
		return this.desOperaTip;
	}

	public void setDesOperaTip(String desOperaTip) {
		this.desOperaTip = desOperaTip;
	}

	public String toString() {
		return "UsuarioDTO [ctlUser=" + this.ctlUser + ", ctlVincd=" + this.ctlVincd + ", usrName=" + this.usrName
				+ ", nomUser=" + this.nomUser + ", codSenha=" + this.codSenha + ", ctlVincdEmb=" + this.ctlVincdEmb
				+ ", ctlOperaTip=" + this.ctlOperaTip + ", desOperaTip=" + this.desOperaTip + "]";
	}
}
