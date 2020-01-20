package br.com.pamcary.api.evento.controller.dto;



import java.util.List;

import br.com.pamcary.api.evento.dao.model.MotoristaViagemModel;
import br.com.pamcary.api.evento.dao.model.PamsatModel;
import br.com.pamcary.api.evento.dao.model.RoteiroViagemModel;
import br.com.pamcary.api.evento.dao.model.VeiculoViagemModel;

public class ViagemDTO {

	  private long ctlPlvia;
	  private int ctlOperatip;
	  private String desOperaTip;
	  private long ctlTrnsp;
	  private String nomTrnsp;
	  private int sitPlvia;
	  private String dhrPosicUlt;
	  private String desPracaUlt;
	  private double numLatitUlt;
	  private double numLongiUlt;
	  private String dhrInclu;
	  private String nomUserInc;
	  private int tipRastr;
	  private double vlrTotalEmb;
	  private int tipOperaVie;
	  private String dhrAtviePln;
	  private String codAtvieUsu;
	  private String dhrPosicPrm;
	  private double numLatitPrm;
	  private double numLongiPrm;
	  private String desPosicPrm;
	  private int qtdDistaTot;
	  private int numSinis;
	  private String semEventos;
	  private String desOperaVie;
	  private String desTipRast;
	  private String desPlvia;
	  private List<RoteiroViagemModel> eventos;
	  private List<MotoristaViagemModel> motoristas;
	  private List<VeiculoViagemModel> veiculos;
	  private String dispositivoCompl;
	  private String tecnologiaCompl;
	  private String tipoCompl;
	  private String modeloCompl;
	  private String classCompl;
	  private List<PamsatModel> pamsat;
	  
	public long getCtlPlvia() {
		return ctlPlvia;
	}
	public void setCtlPlvia(long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}
	public int getCtlOperatip() {
		return ctlOperatip;
	}
	public void setCtlOperatip(int ctlOperatip) {
		this.ctlOperatip = ctlOperatip;
	}
	public String getDesOperaTip() {
		return desOperaTip;
	}
	public void setDesOperaTip(String desOperaTip) {
		this.desOperaTip = desOperaTip;
	}
	public long getCtlTrnsp() {
		return ctlTrnsp;
	}
	public void setCtlTrnsp(long ctlTrnsp) {
		this.ctlTrnsp = ctlTrnsp;
	}
	public String getNomTrnsp() {
		return nomTrnsp;
	}
	public void setNomTrnsp(String nomTrnsp) {
		this.nomTrnsp = nomTrnsp;
	}
	public int getSitPlvia() {
		return sitPlvia;
	}
	public void setSitPlvia(int sitPlvia) {
		this.sitPlvia = sitPlvia;
	}
	public String getDhrPosicUlt() {
		return dhrPosicUlt;
	}
	public void setDhrPosicUlt(String dhrPosicUlt) {
		this.dhrPosicUlt = dhrPosicUlt;
	}
	public String getDesPracaUlt() {
		return desPracaUlt;
	}
	public void setDesPracaUlt(String desPracaUlt) {
		this.desPracaUlt = desPracaUlt;
	}
	public double getNumLatitUlt() {
		return numLatitUlt;
	}
	public void setNumLatitUlt(double numLatitUlt) {
		this.numLatitUlt = numLatitUlt;
	}
	public double getNumLongiUlt() {
		return numLongiUlt;
	}
	public void setNumLongiUlt(double numLongiUlt) {
		this.numLongiUlt = numLongiUlt;
	}
	public String getDhrInclu() {
		return dhrInclu;
	}
	public void setDhrInclu(String dhrInclu) {
		this.dhrInclu = dhrInclu;
	}
	public String getNomUserInc() {
		return nomUserInc;
	}
	public void setNomUserInc(String nomUserInc) {
		this.nomUserInc = nomUserInc;
	}
	public int getTipRastr() {
		return tipRastr;
	}
	public void setTipRastr(int tipRastr) {
		this.tipRastr = tipRastr;
	}
	public double getVlrTotalEmb() {
		return vlrTotalEmb;
	}
	public void setVlrTotalEmb(double vlrTotalEmb) {
		this.vlrTotalEmb = vlrTotalEmb;
	}
	public int getTipOperaVie() {
		return tipOperaVie;
	}
	public void setTipOperaVie(int tipOperaVie) {
		this.tipOperaVie = tipOperaVie;
	}
	public String getDhrAtviePln() {
		return dhrAtviePln;
	}
	public void setDhrAtviePln(String dhrAtviePln) {
		this.dhrAtviePln = dhrAtviePln;
	}
	public String getCodAtvieUsu() {
		return codAtvieUsu;
	}
	public void setCodAtvieUsu(String codAtvieUsu) {
		this.codAtvieUsu = codAtvieUsu;
	}
	public String getDhrPosicPrm() {
		return dhrPosicPrm;
	}
	public void setDhrPosicPrm(String dhrPosicPrm) {
		this.dhrPosicPrm = dhrPosicPrm;
	}
	public double getNumLatitPrm() {
		return numLatitPrm;
	}
	public void setNumLatitPrm(double numLatitPrm) {
		this.numLatitPrm = numLatitPrm;
	}
	public double getNumLongiPrm() {
		return numLongiPrm;
	}
	public void setNumLongiPrm(double numLongiPrm) {
		this.numLongiPrm = numLongiPrm;
	}
	public String getDesPosicPrm() {
		return desPosicPrm;
	}
	public void setDesPosicPrm(String desPosicPrm) {
		this.desPosicPrm = desPosicPrm;
	}
	public int getQtdDistaTot() {
		return qtdDistaTot;
	}
	public void setQtdDistaTot(int qtdDistaTot) {
		this.qtdDistaTot = qtdDistaTot;
	}
	public int getNumSinis() {
		return numSinis;
	}
	public void setNumSinis(int numSinis) {
		this.numSinis = numSinis;
	}
	public String getSemEventos() {
		return semEventos;
	}
	public void setSemEventos(String semEventos) {
		this.semEventos = semEventos;
	}
	public String getDesOperaVie() {
		return desOperaVie;
	}
	public void setDesOperaVie(String desOperaVie) {
		this.desOperaVie = desOperaVie;
	}
	public String getDesTipRast() {
		return desTipRast;
	}
	public void setDesTipRast(String desTipRast) {
		this.desTipRast = desTipRast;
	}
	public String getDesPlvia() {
		return desPlvia;
	}
	public void setDesPlvia(String desPlvia) {
		this.desPlvia = desPlvia;
	}
	public List<RoteiroViagemModel> getEventos() {
		return eventos;
	}
	public void setEventos(List<RoteiroViagemModel> eventos) {
		this.eventos = eventos;
	}
	public List<MotoristaViagemModel> getMotoristas() {
		return motoristas;
	}
	public void setMotoristas(List<MotoristaViagemModel> motoristas) {
		this.motoristas = motoristas;
	}
	public List<VeiculoViagemModel> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<VeiculoViagemModel> veiculos) {
		this.veiculos = veiculos;
	}
	public String getDispositivoCompl() {
		return dispositivoCompl;
	}
	public void setDispositivoCompl(String dispositivoCompl) {
		this.dispositivoCompl = dispositivoCompl;
	}
	public String getTecnologiaCompl() {
		return tecnologiaCompl;
	}
	public void setTecnologiaCompl(String tecnologiaCompl) {
		this.tecnologiaCompl = tecnologiaCompl;
	}
	public String getTipoCompl() {
		return tipoCompl;
	}
	public void setTipoCompl(String tipoCompl) {
		this.tipoCompl = tipoCompl;
	}
	public String getModeloCompl() {
		return modeloCompl;
	}
	public void setModeloCompl(String modeloCompl) {
		this.modeloCompl = modeloCompl;
	}
	public String getClassCompl() {
		return classCompl;
	}
	public void setClassCompl(String classCompl) {
		this.classCompl = classCompl;
	}
	public List<PamsatModel> getPamsat() {
		return pamsat;
	}
	public void setPamsat(List<PamsatModel> pamsat) {
		this.pamsat = pamsat;
	}
	@Override
	public String toString() {
		return "ViagemDTO [ctlPlvia=" + ctlPlvia + ", ctlOperatip=" + ctlOperatip + ", desOperaTip=" + desOperaTip
				+ ", ctlTrnsp=" + ctlTrnsp + ", nomTrnsp=" + nomTrnsp + ", sitPlvia=" + sitPlvia + ", dhrPosicUlt="
				+ dhrPosicUlt + ", desPracaUlt=" + desPracaUlt + ", numLatitUlt=" + numLatitUlt + ", numLongiUlt="
				+ numLongiUlt + ", dhrInclu=" + dhrInclu + ", nomUserInc=" + nomUserInc + ", tipRastr=" + tipRastr
				+ ", vlrTotalEmb=" + vlrTotalEmb + ", tipOperaVie=" + tipOperaVie + ", dhrAtviePln=" + dhrAtviePln
				+ ", codAtvieUsu=" + codAtvieUsu + ", dhrPosicPrm=" + dhrPosicPrm + ", numLatitPrm=" + numLatitPrm
				+ ", numLongiPrm=" + numLongiPrm + ", desPosicPrm=" + desPosicPrm + ", qtdDistaTot=" + qtdDistaTot
				+ ", numSinis=" + numSinis + ", semEventos=" + semEventos + ", desOperaVie=" + desOperaVie
				+ ", desTipRast=" + desTipRast + ", desPlvia=" + desPlvia + ", eventos=" + eventos + ", motoristas="
				+ motoristas + ", veiculos=" + veiculos + ", dispositivoCompl=" + dispositivoCompl
				+ ", tecnologiaCompl=" + tecnologiaCompl + ", tipoCompl=" + tipoCompl + ", modeloCompl=" + modeloCompl
				+ ", classCompl=" + classCompl + "]";
	}	

 
	  
}
