package br.com.pamcary.api.evento.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.ViagemModel;



public class ViagemMapper
  implements RowMapper<ViagemModel>
{
  public ViagemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
    ViagemModel oViagem = new ViagemModel();
    oViagem.setCtlPlvia(rs.getLong("ctl_plvia"));
    oViagem.setCtlOperatip(rs.getInt("ctl_opera_tip"));
    oViagem.setDesOperaTip(rs.getString("des_opera_tip"));
    oViagem.setCtlTrnsp(rs.getLong("ctl_trnsp"));
    oViagem.setNomTrnsp(rs.getString("nom_trnsp"));
    oViagem.setSitPlvia(rs.getInt("sit_plvia"));
    oViagem.setDesPlvia(rs.getString("des_plvia"));
    oViagem.setDhrPosicUlt(rs.getString("dhr_Posic_Ult"));
    oViagem.setDesPracaUlt(rs.getString("des_Praca_Ult"));
    oViagem.setNumLatitUlt(rs.getDouble("num_Latit_Ult"));
    oViagem.setNumLongiUlt(rs.getDouble("num_Longi_Ult"));
    oViagem.setDhrInclu(rs.getString("dhr_Inclu"));
    oViagem.setNomUserInc(rs.getString("nom_User_Inc"));
    oViagem.setTipRastr(rs.getInt("tip_Rastr"));
    oViagem.setDesTipRast(rs.getString("des_tip_rast"));
    oViagem.setVlrTotalEmb(rs.getDouble("vlr_Total_Emb"));
    oViagem.setTipOperaVie(rs.getInt("tip_Opera_Vie"));
    oViagem.setDesOperaVie(rs.getString("des_opera_vie"));
    oViagem.setDhrAtviePln(rs.getString("dhr_Atvie_Pln"));
    oViagem.setCodAtvieUsu(rs.getString("cod_Atvie_Usu"));
    oViagem.setDhrPosicPrm(rs.getString("dhr_Posic_Prm"));
    oViagem.setNumLatitPrm(rs.getDouble("num_Latit_Prm"));
    oViagem.setNumLongiPrm(rs.getDouble("num_Longi_Prm"));
    oViagem.setDesPosicPrm(rs.getString("des_event_Prm"));
    oViagem.setQtdDistaTot(rs.getInt("qtd_Dista_Tot"));
    oViagem.setNumSinis(rs.getInt("num_sinis"));
    oViagem.setDispositivoCompl(rs.getString("dispositivo_compl"));
    oViagem.setTecnologiaCompl(rs.getString("tecnologia_compl"));
    oViagem.setTipoCompl(rs.getString("tipo_compl"));
    oViagem.setModeloCompl(rs.getString("modelo_compl"));
    oViagem.setClassCompl(rs.getString("class_compl"));
    
    return oViagem;
  }
}
