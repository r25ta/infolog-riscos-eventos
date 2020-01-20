package br.com.pamcary.api.evento.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.VeiculoViagemModel;


public class VeiculoViagemMapper
  implements RowMapper<VeiculoViagemModel>
{
  public VeiculoViagemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
    VeiculoViagemModel oVeiculo = new VeiculoViagemModel();
    
    oVeiculo.setCtlVeicu(rs.getLong("CTL_VEICU"));
    oVeiculo.setPlaca(rs.getString("VEICULO_PLACA"));
    oVeiculo.setTipoVeiculo(rs.getString("TIPO"));
    oVeiculo.setRenavam(rs.getString("VEICULO_RENAVAM"));
    oVeiculo.setMarca(rs.getString("VEICULO_MARCA"));
    oVeiculo.setModelo(rs.getString("VEICULO_MODELO"));
    oVeiculo.setCor(rs.getString("VEICULO_COR"));
    oVeiculo.setAno(rs.getString("VEICULO_ANO"));
    oVeiculo.setVinculo(rs.getString("VEICULO_VINCULO"));
    oVeiculo.setEixos(rs.getString("VEICULO_NUMERO_EIXOS"));
    oVeiculo.setTipoDocProprietario(rs.getString("VEICULO_TIPO_DOC_PROPRIETARIO"));
    oVeiculo.setNumDocProprietario(rs.getString("VEICULO_NUM_DOC_PROPRIETARIO"));
    oVeiculo.setEndProprietario(rs.getString("END_VEICU_RUA"));
    oVeiculo.setNumeroProprietario(rs.getString("END_VEICU_NUMERO"));
    oVeiculo.setComplementoProprietario(rs.getString("END_VEICU_COMPLEMENTO"));
    oVeiculo.setBairroProprietario(rs.getString("END_VEICU_BAIRRO"));
    oVeiculo.setCidadeProprietario(rs.getString("END_VEICU_CIDADE"));
    oVeiculo.setUfProprietario(rs.getString("END_VEICU_UF"));
    oVeiculo.setPaisProprietario(rs.getString("END_VEICU_PAIS"));
    oVeiculo.setCepProprietario(rs.getString("END_VEICU_CEP"));
    oVeiculo.setFrota(rs.getString("NUMERO_FROTA"));
    
    return oVeiculo;
  }
}
