package br.com.pamcary.api.evento.dao.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newrelic.api.agent.Trace;

import br.com.pamcary.api.evento.dao.model.EventoModel;

public class EventoMapper implements RowMapper<EventoModel> {

	
	@Trace
	public EventoModel mapRow(ResultSet rs, int rowNum) throws SQLException{

		EventoModel oEvento = new EventoModel();
		
		oEvento.setCtlPlvia(rs.getLong("ctl_plvia"));
		oEvento.setNomEntidade(rs.getString("entidade"));
		oEvento.setCnpjEntidade(rs.getString("cnpj_entidade"));			
		oEvento.setDocumentoProprio(rs.getString("documento_proprio"));
		oEvento.setCodigoExterno(rs.getString("codigo_externo"));
		oEvento.setCtlPtopd(rs.getLong("ctl_ptopd"));
		oEvento.setOrdDesti(rs.getInt("ord_desti"));
		oEvento.setCtlParad(rs.getInt("ctl_parad"));
		oEvento.setSigParad(rs.getString("sig_parad"));
		oEvento.setDhrPreviSis(rs.getString("dhr_previ_sis"));
		oEvento.setDhrEfetiRea(rs.getString("dhr_efeti_rea"));
		oEvento.setTipoJanela(rs.getString("tipo_janela"));
		
		return oEvento;
	}
	
}

