package br.com.pamcary.api.evento.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.MotoristaViagemModel;

public class MotoristaViagemMapper implements RowMapper<MotoristaViagemModel>
{
	  public MotoristaViagemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	    MotoristaViagemModel oMotorista = new MotoristaViagemModel();
	    oMotorista.setNome(rs.getString("MOTORISTA_NOME"));
	    oMotorista.setCpf(rs.getString("MOTORISTA_DOCUMENTO"));
	    oMotorista.setRg(rs.getString("MOTORISTA_RG"));
	    oMotorista.setPamcard(rs.getString("MOTORISTA_NUMERO_PAMCARD"));
	    oMotorista.setDtNascimento(rs.getString("MOTORISTA_DATA_NASCIMENTO"));
	    oMotorista.setEstadoCivil(rs.getString("MOTORISTA_ESTADO_CIVIL"));
	    oMotorista.setCnhNumero(rs.getString("MOTORISTA_CNH_NUMERO"));
	    oMotorista.setCnhCategoria(rs.getString("MOTORISTA_CNH_CATEGORIA"));
	    oMotorista.setStatusReconsultaTelerisco(rs.getString("STATUS_CONSULTA_TELERISCO"));
	    oMotorista.setNumeroReconsultaTelerisco(rs.getString("NUMERO_CONSULTA_TELERISCO"));
	    oMotorista.setDtReconsultaTelerisco(rs.getString("DATA_CONSULTA_TELERISCO"));
	    oMotorista.setEndereco(rs.getString("END_RUA"));
	    oMotorista.setNumero(rs.getString("END_NUMERO"));
	    oMotorista.setComplemento(rs.getString("END_COMPLEMENTO"));
	    oMotorista.setBairro(rs.getString("END_BAIRRO"));
	    oMotorista.setCidade(rs.getString("END_CIDADE"));
	    oMotorista.setUf(rs.getString("END_UF"));
	    oMotorista.setPais(rs.getString("END_PAIS"));
	    oMotorista.setCep(rs.getString("END_CEP"));
	    oMotorista.setTelefoneFixo(rs.getString("TELEFONE_FIXO"));
	    oMotorista.setTelefoneCelular(rs.getString("TELEFONE_CELULAR"));

	    
	    return oMotorista;
	  }
}
