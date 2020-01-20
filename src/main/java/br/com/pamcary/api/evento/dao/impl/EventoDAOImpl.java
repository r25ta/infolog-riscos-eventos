package br.com.pamcary.api.evento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.newrelic.api.agent.Trace;

import br.com.pamcary.api.evento.dao.EventoDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.EventoMapper;
import br.com.pamcary.api.evento.dao.model.EventoModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class EventoDAOImpl extends JdbcDaoSupport implements EventoDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EventoDAOImpl.class);
	
	private static String SQL_GET_EVENTOS = " SELECT rm.ctl_plvia as ctl_plvia " 
			+ "      ,FC_VINCULADO_NOM_GUERR(rm.ctl_ptopd) as entidade "
			+ "      ,FC_RELATORIO_DOC_VINCULADO(rm.ctl_ptopd) as cnpj_entidade" 
			+ "      ,( SELECT dfc.cod_docum_fis "
			+ "         FROM RELAC_PLVIA_DOCUMENTO rpd, " 
			+ "          DOCUMENTO_FISCAL_CLIENTE dfc "
			+ "          WHERE dfc.tip_docum_fis = 7 " 
			+ "            AND rpd.ord_desti = 0 "
			+ "            AND rpd.ctl_plvia =rm.ctl_plvia " 
			+ "            AND rpd.ctl_desti = rm.ctl_ptopd "
			+ "            AND rpd.ctl_docum_cli = dfc.ctl_docum_cli " 
			+ "        ) as documento_proprio "
			+ "      ,( SELECT rvc.cod_clien_ext" 
			+ "          FROM REF_VINCULADO_CLIENTE rvc"
			+ "          WHERE rvc.ctl_vincd = (SELECT tp.ctl_vincd_emb "
			+ "                                  FROM TIPO_OPERACAO tp, "
			+ "                                        PLANO_VIAGEM pv"
			+ "                                  WHERE pv.ctl_plvia = rm.ctl_plvia"
			+ "                                    AND pv.ctl_opera_tip = tp.ctl_opera_tip)"
			+ "                                    AND rvc.ctl_vincd_rld= rm.ctl_ptopd) as codigo_externo"
			+ "      ,rm.ctl_ptopd as ctl_ptopd" 
			+ "      ,rm.ord_desti as ord_desti"
			+ "      ,rm.ctl_parad as ctl_parad" 
			+ "      ,tp.sig_parad as sig_parad"
			+ "      ,TO_CHAR(rm.dhr_previ_sis,'DD/MM/YYYY HH24:MI:SS') as dhr_previ_sis"
			+ "      ,TO_CHAR(rm.dhr_efeti_rea,'DD/MM/YYYY HH24:MI:SS') as dhr_efeti_rea" 
			+ "      ,NVL(( "
			+ "        SELECT CASE " 
			+ "          WHEN sig_ordem_eve = 'C' " 
			+ "            THEN 'CARGA' "
			+ "          WHEN sig_ordem_eve = 'DC' " 
			+ "            THEN 'DESCARGA-CARGA' "
			+ "          WHEN sig_ordem_eve = 'D' " 
			+ "            THEN 'DESCARGA' "
			+ "          WHEN sig_ordem_eve = 'CD' " 
			+ "            THEN 'DESCARGA' " 
			+ "          ELSE   "
			+ "            'DESCARGA' " 
			+ "        END " 
			+ "      FROM DESTINATARIO_PLANO_VIAGEM "
			+ "        WHERE ctl_plvia = rm.ctl_plvia " 
			+ "          AND ctl_desti = rm.ctl_ptopd "
			+ "          AND ord_desti = rm.ord_desti " 
			+ "      ),'CARGA') as tipo_janela "
			+ "FROM ROTEIRO_MOTORISTA rm, " 
			+ "     TIPO_PARADA tp " 
			+ "WHERE tp.ctl_parad = rm.ctl_parad "
			+ "  AND rm.sit_fase_rea IN('R','T') "; 

	private static String WHERE_BY_CTL_PLVIA = "  AND rm.ctl_plvia = ? ";

	private static String WHERE_BY_COD_DOCUM_FIS = "  AND rm.ctl_plvia = ? ";
	
	private static String ORDER_BY = " ORDER BY rm.ord_desti, rm.dhr_previ_sis ";

	
	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(oracleDataSource.oracleJndiDataSource());
	}
	
	@Trace
	public List<EventoModel> getByCtlPlvia(long ctlPlvia) {
		LOGGER.debug("Executando metodo getByCtlPlvia...");
		List<EventoModel> lstEventos = new ArrayList<EventoModel>();
		
		try{
			LOGGER.debug("SQL-> " + SQL_GET_EVENTOS + WHERE_BY_CTL_PLVIA + ORDER_BY);
			lstEventos = getJdbcTemplate().query(SQL_GET_EVENTOS + WHERE_BY_CTL_PLVIA + ORDER_BY,new Object[] {ctlPlvia}, new EventoMapper());
			
			getJdbcTemplate().getDataSource().getConnection().close();		
			
			
		}catch(Exception e){
			throw new ViagemException("Erro na execução! " + SQL_GET_EVENTOS + WHERE_BY_CTL_PLVIA + ORDER_BY + " Causa do Erro -> "+ e);
			
		}
		return lstEventos;
	}
	
	
	@Trace
	public List<EventoModel> getByDocumentoProprio(String codDocum){
		LOGGER.debug("Executando metodo getByDocumentoProprio " + codDocum +"...");

		List<EventoModel> lstEventos = new ArrayList<EventoModel>();

		try{
			LOGGER.debug("SQL ->" + SQL_GET_EVENTOS + WHERE_BY_COD_DOCUM_FIS + ORDER_BY);
			lstEventos = getJdbcTemplate().query(SQL_GET_EVENTOS + WHERE_BY_COD_DOCUM_FIS + ORDER_BY,new Object[] {"%"+ codDocum +"%" }, new EventoMapper());

			getJdbcTemplate().getDataSource().getConnection().close();
			
		}catch(Exception e){
			throw new ViagemException("Erro na execução! " + SQL_GET_EVENTOS + WHERE_BY_COD_DOCUM_FIS + ORDER_BY + " Causa do Erro -> "+ e);

		}
		
		return lstEventos;
	}
	
}