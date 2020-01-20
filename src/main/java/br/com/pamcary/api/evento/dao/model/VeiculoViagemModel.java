package br.com.pamcary.api.evento.dao.model;



import java.io.Serializable;
import java.util.List;

public class VeiculoViagemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long ctlVeicu;
	private String placa;
	private String tipoVeiculo;
	private String renavam;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;
	private String vinculo;
	private String eixos;
	private String tipoDocProprietario;
	private String numDocProprietario;
	private String endProprietario;
	private String numeroProprietario;
	private String complementoProprietario;
	private String bairroProprietario;
	private String cidadeProprietario;
	private String ufProprietario;
	private String paisProprietario;
	private String cepProprietario;
	private String frota;
	private List<VeiculoDispositivoModel> dispositivos;

	public long getCtlVeicu() {
		return this.ctlVeicu;
	}

	public void setCtlVeicu(long ctlVeicu) {
		this.ctlVeicu = ctlVeicu;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVeiculo() {
		return this.tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getRenavam() {
		return this.renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getVinculo() {
		return this.vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getEixos() {
		return this.eixos;
	}

	public void setEixos(String eixos) {
		this.eixos = eixos;
	}

	public String getTipoDocProprietario() {
		return this.tipoDocProprietario;
	}

	public void setTipoDocProprietario(String tipoDocProprietario) {
		this.tipoDocProprietario = tipoDocProprietario;
	}

	public String getNumDocProprietario() {
		return this.numDocProprietario;
	}

	public void setNumDocProprietario(String numDocProprietario) {
		this.numDocProprietario = numDocProprietario;
	}

	public String getEndProprietario() {
		return this.endProprietario;
	}

	public void setEndProprietario(String endProprietario) {
		this.endProprietario = endProprietario;
	}

	public String getNumeroProprietario() {
		return this.numeroProprietario;
	}

	public void setNumeroProprietario(String numeroProprietario) {
		this.numeroProprietario = numeroProprietario;
	}

	public String getComplementoProprietario() {
		return this.complementoProprietario;
	}

	public void setComplementoProprietario(String complementoProprietario) {
		this.complementoProprietario = complementoProprietario;
	}

	public String getBairroProprietario() {
		return this.bairroProprietario;
	}

	public void setBairroProprietario(String bairroProprietario) {
		this.bairroProprietario = bairroProprietario;
	}

	public String getCidadeProprietario() {
		return this.cidadeProprietario;
	}

	public void setCidadeProprietario(String cidadeProprietario) {
		this.cidadeProprietario = cidadeProprietario;
	}

	public String getUfProprietario() {
		return this.ufProprietario;
	}

	public void setUfProprietario(String ufProprietario) {
		this.ufProprietario = ufProprietario;
	}

	public String getPaisProprietario() {
		return this.paisProprietario;
	}

	public void setPaisProprietario(String paisProprietario) {
		this.paisProprietario = paisProprietario;
	}

	public String getCepProprietario() {
		return this.cepProprietario;
	}

	public void setCepProprietario(String cepProprietario) {
		this.cepProprietario = cepProprietario;
	}

	public String getFrota() {
		return this.frota;
	}

	public void setFrota(String frota) {
		this.frota = frota;
	}

	public List<VeiculoDispositivoModel> getDispositivos() {
		return this.dispositivos;
	}

	public void setDispositivos(List<VeiculoDispositivoModel> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public String toString() {
		return "VeiculoViagemModel [ctlVeicu=" + this.ctlVeicu + ", placa=" + this.placa + ", tipoVeiculo="
				+ this.tipoVeiculo + ", renavam=" + this.renavam + ", marca=" + this.marca + ", modelo=" + this.modelo
				+ ", cor=" + this.cor + ", ano=" + this.ano + ", vinculo=" + this.vinculo + ", eixos=" + this.eixos
				+ ", tipoDocProprietario=" + this.tipoDocProprietario + ", numDocProprietario="
				+ this.numDocProprietario + ", endProprietario=" + this.endProprietario + ", numeroProprietario="
				+ this.numeroProprietario + ", complementoProprietario=" + this.complementoProprietario
				+ ", bairroProprietario=" + this.bairroProprietario + ", cidadeProprietario=" + this.cidadeProprietario
				+ ", ufProprietario=" + this.ufProprietario + ", paisProprietario=" + this.paisProprietario
				+ ", cepProprietario=" + this.cepProprietario + ", frota=" + this.frota + ", dispositivos="
				+ this.dispositivos + "]";
	}
}
