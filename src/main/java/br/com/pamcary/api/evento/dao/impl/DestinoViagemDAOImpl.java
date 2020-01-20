package br.com.pamcary.api.evento.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.pamcary.api.evento.dao.DestinoViagemDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.DestinoViagemMapper;
import br.com.pamcary.api.evento.dao.model.DestinoViagemModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class DestinoViagemDAOImpl extends JdbcDaoSupport implements DestinoViagemDAO {
	private static Logger LOGGER = LoggerFactory.getLogger(DestinoViagemDAOImpl.class);

	private static final String SQL_DESTINATARIO_POR_VIAGEM = "select dpv.ctl_plvia       ,dpv.ctl_desti       ,fc_vinculado_nom_guerr(dpv.ctl_desti) as nom_desti       ,dpv.num_consi_mer       ,fc_vinculado_nom_guerr(dpv.num_consi_mer) as nom_consi_mer       ,TO_CHAR(dpv.dhr_plvia_ter,'DD/MM/YYYY HH24:MI:SS') AS dhr_plvia_ter       ,dpv.ord_desti       ,dpv.sit_plvia       , (select des_situa from situacao_plano_viagem where sit_plvia = dpv.sit_plvia ) as des_plvia       ,dpv.sig_ordem_eve       ,NVL(( SELECT CASE           WHEN dpv.sig_ordem_eve = 'C'              THEN 'CARGA'           WHEN dpv.sig_ordem_eve = 'DC'              THEN 'DESCARGA-CARGA'           WHEN dpv.sig_ordem_eve = 'D'             THEN 'DESCARGA'           WHEN dpv.sig_ordem_eve = 'CD'             THEN 'DESCARGA'           ELSE                'DESCARGA'         END       FROM dual ),'CARGA') as tipo_janela       ,dpv.ctl_rota_gri  from destinatario_plano_viagem dpv  where dpv.ctl_plvia = ?  order by dpv.ord_desti";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource((DataSource) this.oracleDataSource.oracleJndiDataSource());
	}

	public List<DestinoViagemModel> getByCtlPlvia(long ctlPlvia) {
		LOGGER.debug("Executando metodo getByCtlPlvia...");
		List<DestinoViagemModel> lstDestinos = new ArrayList<>();

		try {
			LOGGER.debug(
					"SQL->" + SQL_DESTINATARIO_POR_VIAGEM);
			lstDestinos = getJdbcTemplate().query( SQL_DESTINATARIO_POR_VIAGEM,	
														new Object[] { ctlPlvia }, 
														new DestinoViagemMapper());

			getJdbcTemplate().getDataSource().getConnection().close();

		} catch (Exception e) {
			throw new ViagemException(
					"Erro na execução -> " + SQL_DESTINATARIO_POR_VIAGEM+ " Causa do Erro -> " + e);
		}

		return lstDestinos;
	}
}
