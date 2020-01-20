package br.com.pamcary.api.evento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.pamcary.api.evento.dao.RoteiroViagemDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.RoteiroViagemMapper;
import br.com.pamcary.api.evento.dao.model.RoteiroViagemModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository 
public class RoteiroViagemDAOImpl extends JdbcDaoSupport implements RoteiroViagemDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(RoteiroViagemDAOImpl.class);
	
	private static final String SQL_ROTEIRO_VIAGEM = " SELECT rm.ctl_rtmot " + 
														" ,rm.ctl_ptopd " + 
														" ,FC_VINCULADO_NOM_GUERR(rm.ctl_ptopd) as des_entidade " + 
														" ,FC_RELATORIO_DOC_VINCULADO(rm.ctl_ptopd) as cnpj_entidade " + 
														" ,( SELECT dfc.cod_docum_fis  " + 
														"         FROM RELAC_PLVIA_DOCUMENTO rpd, " + 
														"          DOCUMENTO_FISCAL_CLIENTE dfc " + 
														"          WHERE dfc.tip_docum_fis = 7 " + 
														"            AND rpd.ord_desti = 0 " + 
														"            AND rpd.ctl_plvia =rm.ctl_plvia " + 
														"            AND rpd.ctl_desti = rm.ctl_ptopd " + 
														"            AND rpd.ctl_docum_cli = dfc.ctl_docum_cli " + 
														"        ) as documento_proprio " + 
														" ,( SELECT rvc.cod_clien_ext " + 
														"          FROM REF_VINCULADO_CLIENTE rvc " + 
														"          WHERE rvc.ctl_vincd = (SELECT tp.ctl_vincd_emb  " + 
														"                                  FROM TIPO_OPERACAO tp,  " + 
														"                                        PLANO_VIAGEM pv " + 
														"                                  WHERE pv.ctl_plvia = rm.ctl_plvia " + 
														"                                    AND pv.ctl_opera_tip = tp.ctl_opera_tip) " + 
														"                                    AND rvc.ctl_vincd_rld= rm.ctl_ptopd) as codigo_externo " + 
														"      ,rm.ord_desti as ord_desti " + 
														"      ,rm.ctl_parad as ctl_parad " + 
														"      ,tp.sig_parad as sig_parad " + 
														"      ,TO_CHAR(rm.dhr_previ_sis,'DD/MM/YYYY HH24:MI:SS') AS dhr_previ_sis " + 
														"      ,TO_CHAR(rm.dhr_efeti_rea,'DD/MM/YYYY HH24:MI:SS') AS dhr_efeti_rea  " + 
														"      ,NVL(( " + 
														"        SELECT CASE " + 
														"          WHEN sig_ordem_eve = 'C'  " + 
														"            THEN 'CARGA' " + 
														"          WHEN sig_ordem_eve = 'DC'  " + 
														"            THEN 'DESCARGA-CARGA' " + 
														"          WHEN sig_ordem_eve = 'D' " + 
														"            THEN 'DESCARGA' " + 
														"          WHEN sig_ordem_eve = 'CD' " + 
														"            THEN 'DESCARGA' " + 
														"          ELSE   " + 
														"            'DESCARGA' " + 
														"        END " + 
														"      FROM DESTINATARIO_PLANO_VIAGEM  " + 
														"        WHERE ctl_plvia = rm.ctl_plvia  " + 
														"          AND ctl_desti = rm.ctl_ptopd  " + 
														"          AND ord_desti = rm.ord_desti " + 
														"      ),'CARGA') as tipo_janela" +
														"      ,rm.sta_telef " + 
														"      ,rm.sit_fase_rea " + 
														"      ,rm.num_seque " + 
														"      ,TO_CHAR(rm.dhr_previ_mot,'DD/MM/YYYY HH24:MI:SS') AS dhr_previ_mot" + 
														"      ,TO_CHAR(rm.dhr_tende_chg,'DD/MM/YYYY HH24:MI:SS') AS dhr_tende_chg  "+ 
														"      ,TO_CHAR(rm.dhr_manut,'DD/MM/YYYY HH24:MI:SS') AS dhr_manut " + 
														"      ,rm.cod_user " + 
														" FROM ROTEIRO_MOTORISTA rm" + 
														"   ,TIPO_PARADA tp " + 
														" WHERE tp.ctl_parad = rm.ctl_parad ";
	
	
	private static final String WHERE_EVENTOS_REALIZADOS_POR_VIAGEM = "  AND rm.ctl_plvia = ? " +  
																	" AND rm.sit_fase_rea IN('R','T') ";  
	
	private static final String ORDER_BY_EVENTOS_ASC = " ORDER BY rm.ord_desti, rm.dhr_previ_sis";
	
	@Autowired
	private OracleDataSourceConfig oracleDataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(oracleDataSource.oracleJndiDataSource());
	}
	
	
	@Override
	public List<RoteiroViagemModel> getByCtlPlvia(long ctlPlvia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoteiroViagemModel getByCtlRtmot(long ctlPlvia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoteiroViagemModel> getByEventosPorDestino(long ctlPlvia) {
		LOGGER.debug("Executando metodo getByEventosPorDestino...");
		List<RoteiroViagemModel> lstRoteiros = new ArrayList<RoteiroViagemModel>();
		
		try{
			LOGGER.debug("SQL-> " + SQL_ROTEIRO_VIAGEM + WHERE_EVENTOS_REALIZADOS_POR_VIAGEM + ORDER_BY_EVENTOS_ASC);
			lstRoteiros = getJdbcTemplate().query(SQL_ROTEIRO_VIAGEM + WHERE_EVENTOS_REALIZADOS_POR_VIAGEM + ORDER_BY_EVENTOS_ASC, 
													new Object[] {	ctlPlvia }, 
													new RoteiroViagemMapper());
			
			getJdbcTemplate().getDataSource().getConnection().close();		
			
			
		}catch(Exception e){
			throw new ViagemException("Erro na execução! " + SQL_ROTEIRO_VIAGEM + WHERE_EVENTOS_REALIZADOS_POR_VIAGEM + ORDER_BY_EVENTOS_ASC +" Causa do Erro -> ",e);
		
		}
		return lstRoteiros;
	}

}