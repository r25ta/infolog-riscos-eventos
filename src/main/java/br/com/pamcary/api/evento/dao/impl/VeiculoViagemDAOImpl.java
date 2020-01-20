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

import br.com.pamcary.api.evento.dao.VeiculoViagemDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.VeiculoViagemMapper;
import br.com.pamcary.api.evento.dao.model.VeiculoViagemModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class VeiculoViagemDAOImpl extends JdbcDaoSupport implements VeiculoViagemDAO {
	private static Logger LOGGER = LoggerFactory.getLogger(VeiculoViagemDAOImpl.class);

	private static final String SQL_VEICULO_VIAGEM_BY_CTL_PLVIA = " select V.CTL_VEICU                 ,NVL(V.COD_PLACA,'') AS VEICULO_PLACA                 ,NVL(V.NUM_RENAV, 0) AS VEICULO_RENAVAM                 ,NVL(V.NOM_MARCA_VEI,'') AS VEICULO_MARCA                 ,NVL(V.NOM_MODEL_VEI,'') AS VEICULO_MODELO                 ,NVL(V.NOM_COR_VEI,'') AS VEICULO_COR                 ,NVL(V.ANO_FABRC,'') AS VEICULO_ANO                 ,NVL(FC_VINCULADO_NOM_GUERR(DV.CTL_VINCD),'') AS VEICULO_VINCULO                 ,NVL(V.QTD_EIXO, 0) AS VEICULO_NUMERO_EIXOS                 ,NVL(DECODE(DV.TIP_DOCUM, 1, 'CNPJ', 2, 'CPF', 3, 'COD.EXTERNO'), 0) AS VEICULO_TIPO_DOC_PROPRIETARIO                 ,NVL(DV.COD_DOCUM,'') AS VEICULO_NUM_DOC_PROPRIETARIO                 ,NVL(VEV.DES_ENDER,'') AS END_VEICU_RUA                 ,NVL(VEV.DES_NUMER_END,'') AS END_VEICU_NUMERO                 ,NVL(VEV.DES_COMPL_END,'') AS END_VEICU_COMPLEMENTO                 ,NVL(VEV.DES_BAIRR_END,'') AS END_VEICU_BAIRRO                 ,NVL(VPR.NOM_LOCAL,'') AS END_VEICU_CIDADE                 ,NVL(VPR.SIG_UNFED,'') AS END_VEICU_UF                 ,NVL(VPR.NOM_PAIS,'') AS END_VEICU_PAIS                 ,NVL(VPR.COD_CEP,'00000000') AS END_VEICU_CEP                 ,NULL AS NUMERO_FROTA                 ,NVL(V.NOM_CATEG_VEI,'') AS TIPO   FROM SUPERVISOR.PLANO_VIAGEM PV   , SUPERVISOR.TINF_VEICU_PLANO_VIAGEM VPV   , PAMAIS_PRD.V_CRP_VEICULO V   , SUPERVISOR.TINF_VEICU_PROPR_VINCD IFPV   , SUPERVISOR.DOC_VINCULADO DV   , SUPERVISOR.ENDERECO_VINCULADO VEV   , PAMAIS_PRD.V_CRP_LOCALIDADE VPR  where pv.ctl_plvia = ?                 AND VPV.CTL_PLVIA(+) = PV.CTL_PLVIA                 AND V.CTL_VEICU(+) = VPV.CTL_VEICU                 AND V.CTL_VEICU = IFPV.CTL_VEICU(+)                 AND IFPV.CTL_VINCD = DV.CTL_VINCD(+)                 AND DV.CTL_VINCD = VEV.CTL_VINCD(+)                 AND VEV.COD_PRACA = VPR.CTL_LOCAL(+) ";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource((DataSource) this.oracleDataSource.oracleJndiDataSource());
	}

	public List<VeiculoViagemModel> getVeiculoViagemByCtlPlvia(long ctlPlvia) {
		LOGGER.debug("Executando metodo getVeiculoViagemByCtlPlvia...");

		List<VeiculoViagemModel> lstVeiculos = new ArrayList<>();

		try {
			LOGGER.debug("SQL-> "+SQL_VEICULO_VIAGEM_BY_CTL_PLVIA);
			lstVeiculos = getJdbcTemplate().query(SQL_VEICULO_VIAGEM_BY_CTL_PLVIA,
													new Object[] { Long.valueOf(ctlPlvia) }, 
													new VeiculoViagemMapper());

			getJdbcTemplate().getDataSource().getConnection().close();
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Veiculo nencontrado na viagem  [" + ctlPlvia + "]!");
			LOGGER.info("=> "  + e);
			return null;
		} catch (SQLException e) {
			throw new ViagemException("SQL -> " +SQL_VEICULO_VIAGEM_BY_CTL_PLVIA +  " Causa do Erro -> ", e);
		}

		return lstVeiculos;
	}
}
