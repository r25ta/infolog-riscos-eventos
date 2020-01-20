package br.com.pamcary.api.evento.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.VeiculoDispositivoModel;

public class VeiculoDispositivoMapper implements RowMapper<VeiculoDispositivoModel> {
	public VeiculoDispositivoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		VeiculoDispositivoModel oDispositivo = new VeiculoDispositivoModel();

		oDispositivo.setCtlVeicu(rs.getLong("CTL_VEICU"));
		oDispositivo.setTecnologia(rs.getString("TECNOLOGIA"));
		oDispositivo.setIdRastreador(rs.getString("ID_RASTREADOR"));

		return oDispositivo;
	}
}