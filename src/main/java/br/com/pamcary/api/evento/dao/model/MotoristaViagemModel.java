package br.com.pamcary.api.evento.dao.model;



import java.io.Serializable;

public class MotoristaViagemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String rg;
	private String pamcard;
	private String dtNascimento;
	private String estadoCivil;
	private String cnhNumero;
	private String cnhCategoria;
	private String statusReconsultaTelerisco;
	private String numeroReconsultaTelerisco;
	private String dtReconsultaTelerisco;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private String cep;
	private String telefoneFixo;
	private String telefoneCelular;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPamcard() {
		return this.pamcard;
	}

	public void setPamcard(String pamcard) {
		this.pamcard = pamcard;
	}

	public String getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCnhNumero() {
		return this.cnhNumero;
	}

	public void setCnhNumero(String cnhNumero) {
		this.cnhNumero = cnhNumero;
	}

	public String getCnhCategoria() {
		return this.cnhCategoria;
	}

	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}

	public String getStatusReconsultaTelerisco() {
		return this.statusReconsultaTelerisco;
	}

	public void setStatusReconsultaTelerisco(String statusReconsultaTelerisco) {
		this.statusReconsultaTelerisco = statusReconsultaTelerisco;
	}

	public String getNumeroReconsultaTelerisco() {
		return this.numeroReconsultaTelerisco;
	}

	public void setNumeroReconsultaTelerisco(String numeroReconsultaTelerisco) {
		this.numeroReconsultaTelerisco = numeroReconsultaTelerisco;
	}

	public String getDtReconsultaTelerisco() {
		return this.dtReconsultaTelerisco;
	}

	public void setDtReconsultaTelerisco(String dtReconsultaTelerisco) {
		this.dtReconsultaTelerisco = dtReconsultaTelerisco;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefoneFixo() {
		return this.telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String toString() {
		return "MotoristaViagemModel [nome=" + this.nome + ", cpf=" + this.cpf + ", rg=" + this.rg + ", pamcard="
				+ this.pamcard + ", dtNascimento=" + this.dtNascimento + ", estadoCivil=" + this.estadoCivil
				+ ", cnhNumero=" + this.cnhNumero + ", cnhCategoria=" + this.cnhCategoria
				+ ", statusReconsultaTelerisco=" + this.statusReconsultaTelerisco + ", numeroReconsultaTelerisco="
				+ this.numeroReconsultaTelerisco + ", dtReconsultaTelerisco=" + this.dtReconsultaTelerisco
				+ ", endereco=" + this.endereco + ", numero=" + this.numero + ", complemento=" + this.complemento
				+ ", bairro=" + this.bairro + ", cidade=" + this.cidade + ", uf=" + this.uf + ", pais=" + this.pais
				+ ", cep=" + this.cep + ", telefoneFixo=" + this.telefoneFixo + ", telefoneCelular="
				+ this.telefoneCelular + "]";
	}
}
