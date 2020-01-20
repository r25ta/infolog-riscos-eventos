package br.com.pamcary.api.evento.dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.pamcary.api.evento.dao.VeiculoDispositivoDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.VeiculoDispositivoMapper;
import br.com.pamcary.api.evento.dao.model.VeiculoDispositivoModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class VeiculoDispositivoDAOImpl extends JdbcDaoSupport implements VeiculoDispositivoDAO {
	private static Logger LOGGER = LoggerFactory.getLogger(VeiculoDispositivoDAOImpl.class);

	private static final String SQL_VEICULO_DISPOSITVO_BY_ID_VEICU = " SELECT   V.CTL_VEICU AS CTL_VEICU  ,NVL(VPT.NOM_FANTS,'TELEFONE') AS TECNOLOGIA                 ,NVL(D.COD_DISPO_RST,'') AS ID_RASTREADOR  FROM  SUPERVISOR.TINF_RELAC_VEICU_DISPO RVD  , PAMAIS_PRD.V_CRP_VEICULO V  , SUPERVISOR.TINF_DISPOSITIVO D  , SUPERVISOR.TINF_RELAC_PROVE_RASTR_DISPO PT  , PAMAIS_PRD.V_CRP_PROVEDOR_TECNOLOGIA VPT  WHERE V.CTL_VEICU =   ?             AND RVD.STA_ATIVO = 'S'                   AND V.CTL_VEICU = RVD.CTL_VEICU(+)                 AND RVD.CTL_DISPO_RST = D.CTL_DISPO_RST(+)                 AND D.CTL_DISPO_RST = PT.CTL_DISPO_RST(+)                 AND PT.CTL_PROVE_TEN = VPT.CTL_PROVE_TEN(+)";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource((DataSource) this.oracleDataSource.oracleJndiDataSource());
	}

	public List<VeiculoDispositivoModel> getDispositivoVeiculoByCtlVeicu(long ctlVeicu) {
		LOGGER.debug("Executando metodo getDispositivoVeiculoByCtlVeicu...");

		List<VeiculoDispositivoModel> lstDispositivos = new ArrayList<>();

		try {
			LOGGER.debug("SQL->  " + SQL_VEICULO_DISPOSITVO_BY_ID_VEICU);
			lstDispositivos = getJdbcTemplate().query(SQL_VEICULO_DISPOSITVO_BY_ID_VEICU, new Object[] { Long.valueOf(ctlVeicu) }, new VeiculoDispositivoMapper());

			getJdbcTemplate().getDataSource().getConnection().close();
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Dispositivo nencontrado para Veiculo [" + ctlVeicu + "]!");
			LOGGER.info("=> " + e);
			return null;
		} catch (SQLException e) {
			throw new ViagemException("Erro na execução ->" +SQL_VEICULO_DISPOSITVO_BY_ID_VEICU,	e);
		}

		return lstDispositivos;
	}
}