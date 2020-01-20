package br.com.pamcary.api.evento.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.DestinoViagemModel;

public class DestinoViagemMapper implements RowMapper<DestinoViagemModel> {

	public DestinoViagemModel mapRow(ResultSet rs, int rowNum) throws SQLException{
		DestinoViagemModel oDestinatario = new DestinoViagemModel();
		
		oDestinatario.setCtlDesti(rs.getLong("ctl_desti"));
		oDestinatario.setNomDesti(rs.getString("nom_desti"));
		oDestinatario.setNumConsiMer(rs.getLong("num_consi_mer"));
		oDestinatario.setNomConsiMer(rs.getString("nom_consi_mer"));
		oDestinatario.setDhrPlviaTer(rs.getString("dhr_plvia_ter"));
		oDestinatario.setOrdDesti(rs.getInt("ord_desti"));
		oDestinatario.setSitPlvia(rs.getInt("sit_plvia"));
		oDestinatario.setDesPlvia(rs.getString("des_plvia"));
		oDestinatario.setSigOrdemEve(rs.getString("sig_ordem_eve"));
		oDestinatario.setTipoJanela(rs.getString("tipo_janela"));
		oDestinatario.setCtlRotaGri(rs.getLong("ctl_rota_gri"));		 
		
		return oDestinatario;
		
	}
	
}
