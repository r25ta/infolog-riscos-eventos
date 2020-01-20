package br.com.pamcary.api.evento.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.PamsatModel;

public class PamsatMapper implements RowMapper<PamsatModel> {
	@Override
	public PamsatModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PamsatModel oPamsat = new PamsatModel();

		oPamsat.setCtlAlterSta(rs.getLong("ctl_alter_sta"));
		oPamsat.setCtlViagemKrona(rs.getLong("ctl_plano_krona"));
		oPamsat.setDesPamsat(rs.getString("sta_plano_krona"));
		oPamsat.setDhrAlter(rs.getNString("dhr_alter"));
		    
		return oPamsat;
	}
}
