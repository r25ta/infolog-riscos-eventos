package br.com.pamcary.api.evento.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.pamcary.api.evento.dao.ViagemDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.ViagemMapper;
import br.com.pamcary.api.evento.dao.model.ViagemModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class ViagemDAOImpl extends JdbcDaoSupport implements ViagemDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ViagemDAOImpl.class);

	private static final String SQL_QUERY_PLANO_VIAGEM = " select " + " pv.ctl_plvia " 
			+ " ,pv.ctl_opera_tip " + " , (select des_opera_tip " + " from tipo_operacao "
			+ " where ctl_opera_tip = pv.ctl_opera_tip) as des_opera_tip " + " ,pv.ctl_trnsp "
			+ " ,FC_VINCULADO_NOM_GUERR(pv.ctl_trnsp) as nom_trnsp " + " ,pv.sit_plvia "
			+ " , (select des_situa from situacao_plano_viagem where sit_plvia = pv.sit_plvia ) as des_plvia "
			+ " ,TO_CHAR(pv.dhr_Posic_Ult,'DD/MM/YYYY HH24:MI:SS') AS dhr_Posic_Ult " + " ,pv.des_Praca_Ult " + " ,pv.num_Latit_Ult " + " ,pv.num_Longi_Ult "
			+ " ,TO_CHAR(pv.dhr_Inclu,'DD/MM/YYYY HH24:MI:SS') AS dhr_Inclu " + " ,pv.nom_User_Inc " + " ,pv.tip_Rastr "
			+ " , (select case  when pv.tip_rastr = 1 then 'RASTREADO' else 'NÃO RASTREADO' end from dual ) as des_tip_rast "
			+ " ,pv.vlr_Total_Emb " + " ,pv.tip_Opera_Vie " + " ,(select des_opera_vie " + " from tipo_operacao_viagem "
			+ " where tip_opera_vie = pv.tip_opera_vie) as des_opera_vie " + " ,TO_CHAR(pv.dhr_Atvie_Pln,'DD/MM/YYYY HH24:MI:SS') AS dhr_Atvie_Pln  "
			+ " ,pv.cod_Atvie_Usu " + " ,TO_CHAR(pv.dhr_Posic_Prm,'DD/MM/YYYY HH24:MI:SS') AS dhr_Posic_Prm " + " ,pv.num_Latit_Prm ,pv.num_Longi_Prm "
			+ " ,pv.des_event_Prm " + " ,pv.qtd_Dista_Tot " + " ,pv.num_sinis "
			+ " ,NVL(FC_DADOS_DISPO_COMPL(pv.ctl_plvia,1),'') AS dispositivo_compl  "
			+ " ,NVL(FC_DADOS_DISPO_COMPL(pv.ctl_plvia,2),'') AS tecnologia_compl  "
			+ " ,NVL(FC_DADOS_DISPO_COMPL(pv.ctl_plvia,3),'') AS tipo_compl  "
			+ " ,NVL(FC_DADOS_DISPO_COMPL(pv.ctl_plvia,4),'') AS modelo_compl  "
			+ " ,NVL(FC_DADOS_DISPO_COMPL(pv.ctl_plvia,5),'') AS class_compl ";

	private static final String FILTRO_TIPO_OPERACAO = "and pv.ctl_opera_tip = ?";
	
	private static final String FROM_PLANO_VIAGEM_WHERE_BY_CTL_PLVIA = " from plano_viagem pv "
			+ " where pv.ctl_plvia = ? "
			+ " and pv.sit_plvia <> 10 ";

	private static final String FROM_PLANO_VIAGEM_WHERE_BY_DOCUMENTO_PROPRIO = " from plano_viagem pv "
			+ "    ,relac_plvia_documento rpd " + "    ,documento_fiscal_cliente dfc "
			+ " where pv.ctl_plvia = rpd.ctl_plvia "
			+ " and pv.sit_plvia <> 10  "
			+  "  and dfc.tip_docum_fis = 7 " + "  and rpd.ord_desti = 0 "
			+ "  and dfc.ctl_docum_cli = rpd.ctl_docum_cli " + "  and dfc.cod_docum_fis = ?";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(oracleDataSource.oracleJndiDataSource());
	}
		
	private Integer ctlOperaTip;

	public Integer getCtlOperaTip() {
		return ctlOperaTip;
	}

	@Override
	public void ctlOperaTip(int ctlOperaTip) {
		this.setCtlOperaTip(ctlOperaTip);
	}

	public void setCtlOperaTip(int ctlOperaTip) {
		this.ctlOperaTip = ctlOperaTip;
	}

	@Override
	public List<ViagemModel> getByCtlPLvia(long ctlPlvia) {
		LOGGER.debug("Executando metodo getByViagem...");
		List<ViagemModel> lstViagens = new ArrayList<>();
		
		try{
			LOGGER.debug("SQL-> " + SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_CTL_PLVIA + FILTRO_TIPO_OPERACAO);
			lstViagens = getJdbcTemplate().query(SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_CTL_PLVIA + FILTRO_TIPO_OPERACAO, 
													new Object[] {	ctlPlvia,
																	this.getCtlOperaTip() }, 
													new ViagemMapper());
			
			getJdbcTemplate().getDataSource().getConnection().close();		
			
		
		}catch(EmptyResultDataAccessException e) {
			LOGGER.info("Viagem não encontrada no Banco de Dados para ctl plvia ["+ctlPlvia+"] e operação ["+this.getCtlOperaTip()+"]");
			LOGGER.info("=> " + e);
			return null;

		}catch(SQLException e){
			throw new ViagemException("Erro na execução! " + SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_CTL_PLVIA + FILTRO_TIPO_OPERACAO +" Causa do Erro -> ",e);
			
		}
		
		return lstViagens;
	}

	@Override
	public List<ViagemModel> getByCodDocumentoProprio(String codDocum) {
		LOGGER.debug("Executando metodo getByDocumentoProprio...");
		
		List<ViagemModel> lstViagens = new ArrayList<>();
			
			
		try {
			LOGGER.debug("SQL-> " + SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_DOCUMENTO_PROPRIO + FILTRO_TIPO_OPERACAO);
			lstViagens = (List<ViagemModel>) getJdbcTemplate().query(SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_DOCUMENTO_PROPRIO + FILTRO_TIPO_OPERACAO,
															new Object[] {	codDocum, 
																			this.getCtlOperaTip()
																		 },
															new ViagemMapper());
			
			getJdbcTemplate().getDataSource().getConnection().close();
		
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Viagem não encontrada no Banco de Dados para documento proprio ["+codDocum+"] e operação ["+this.getCtlOperaTip()+"]");
			LOGGER.info("=> " + e);
			return null;
			
		}catch (SQLException e) {
			throw new ViagemException("Erro na execução! " + SQL_QUERY_PLANO_VIAGEM + FROM_PLANO_VIAGEM_WHERE_BY_DOCUMENTO_PROPRIO + FILTRO_TIPO_OPERACAO + " Causa do Erro -> ",e);
			
		}		
		return lstViagens;
	}
	
	@Override
	public List<ViagemModel> getByCtlOperaTip(int ctlOperaTip) {
		//
		return null;
	}




}