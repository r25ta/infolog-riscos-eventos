package br.com.pamcary.api.evento.dao.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.RoteiroViagemModel;

public class RoteiroViagemMapper implements RowMapper<RoteiroViagemModel> {
	public RoteiroViagemModel mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		RoteiroViagemModel oRoteiro = new RoteiroViagemModel();
		
		oRoteiro.setCtlRtmot(rs.getLong("ctl_rtmot"));
		oRoteiro.setCtlPtopd(rs.getLong("ctl_ptopd"));
		oRoteiro.setDesEntidade(rs.getString("des_entidade"));
		oRoteiro.setCnpjEntidade(rs.getString("cnpj_entidade"));
		oRoteiro.setDocumentoProprio(rs.getString("documento_proprio"));
		oRoteiro.setCodigoExterno(rs.getString("codigo_externo"));
		oRoteiro.setOrdDesti(rs.getInt("ord_desti"));
		oRoteiro.setCtlParad(rs.getInt("ctl_parad"));
		oRoteiro.setSigParad(rs.getString("sig_parad")); 
		oRoteiro.setDhrPreviSis(rs.getString("dhr_previ_sis"));
		oRoteiro.setDhrEfetiRea(rs.getString("dhr_efeti_rea"));
		oRoteiro.setDhrPreviMot(rs.getString("dhr_previ_mot"));
		oRoteiro.setDhrTendeChg(rs.getString("dhr_tende_chg"));
		oRoteiro.setTipoJanela(rs.getString("tipo_janela"));
		oRoteiro.setStaTelef(rs.getString("sta_telef"));
		oRoteiro.setSitFaseRea(rs.getString("sit_fase_rea"));
		oRoteiro.setNumSeque(rs.getInt("num_seque"));
		oRoteiro.setDhrManut(rs.getString("dhr_manut"));
		oRoteiro.setCodUser(rs.getString("cod_user"));
		
		return oRoteiro;
		
	}
}
