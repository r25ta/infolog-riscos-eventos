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

import br.com.pamcary.api.evento.dao.MotoristaViagemDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.MotoristaViagemMapper;
import br.com.pamcary.api.evento.dao.model.MotoristaViagemModel;
import br.com.pamcary.api.evento.exception.ViagemException;


@Repository
public class MotoristaViagemDAOImpl extends JdbcDaoSupport implements MotoristaViagemDAO {
	private static Logger LOGGER = LoggerFactory.getLogger(MotoristaViagemDAOImpl.class);

	private static final String SQL_MOTORISTA_VIAGEM_BY_CTL_PLVIA = " SELECT  VMOT.NOM_MOTORISTA AS MOTORISTA_NOME ,VMOT.COD_DOCUM_MOT AS MOTORISTA_DOCUMENTO ,NVL((SELECT COD_DOCUM_PES FROM PAMAIS_PRD.TCRP_DOCUMENTO_PESSOA \t\tWHERE TIP_DOCUM_PES = 12 AND CTL_PESSO = MPV.CTL_MOTOT),'') AS MOTORISTA_RG  ,NVL(PV.NUM_PCARD,'') AS MOTORISTA_NUMERO_PAMCARD  ,NVL(VMOT.DAT_NASCI,'') AS MOTORISTA_DATA_NASCIMENTO  ,VMOT.DES_ESTAD_CIV AS MOTORISTA_ESTADO_CIVIL  ,VMOT.COD_DOCUM_CNH AS MOTORISTA_CNH_NUMERO  ,VMOT.COD_CATEG_CNH AS MOTORISTA_CNH_CATEGORIA  ,FC_RECONSULTA_STATUS_TELERISCO(PV.CTL_PLVIA) AS STATUS_CONSULTA_TELERISCO  ,FC_RECONSULTA_PROTO_TELERISCO(PV.CTL_PLVIA) AS NUMERO_CONSULTA_TELERISCO  ,FC_RECONSULTA_DATA_TELERISCO(PV.CTL_PLVIA) AS DATA_CONSULTA_TELERISCO  ,NVL((SELECT DES_LOGRA FROM PAMAIS_PRD.TCRP_ENDERECO_PESSOA WHERE CTL_PESSO = MPV.CTL_MOTOT AND NUM_ENDER_PES = 1),'') AS END_RUA  ,NVL((SELECT COD_NUMER_LGR FROM PAMAIS_PRD.TCRP_ENDERECO_PESSOA WHERE CTL_PESSO = MPV.CTL_MOTOT AND NUM_ENDER_PES = 1),'') AS END_NUMERO  ,NVL((SELECT DES_COMPL FROM PAMAIS_PRD.TCRP_ENDERECO_PESSOA WHERE CTL_PESSO = MPV.CTL_MOTOT AND NUM_ENDER_PES = 1),'') AS END_COMPLEMENTO  ,NVL((SELECT NOM_BAIRR FROM PAMAIS_PRD.TCRP_ENDERECO_PESSOA WHERE CTL_PESSO = MPV.CTL_MOTOT AND NUM_ENDER_PES = 1),'') AS END_BAIRRO  ,NVL((SELECT L.NOM_LOCAL FROM PAMAIS_PRD.V_CRP_LOCALIDADE L, PAMAIS_PRD.TCRP_ENDERECO_PESSOA E      \tWHERE E.CTL_PESSO = MPV.CTL_MOTOT AND E.CTL_LOCAL = L.CTL_LOCAL AND NUM_ENDER_PES = 1),'') AS END_CIDADE  ,NVL((SELECT L.SIG_UNFED FROM PAMAIS_PRD.V_CRP_LOCALIDADE L, PAMAIS_PRD.TCRP_ENDERECO_PESSOA E \t    WHERE E.CTL_PESSO = MPV.CTL_MOTOT AND E.CTL_LOCAL = L.CTL_LOCAL AND NUM_ENDER_PES = 1),'') AS END_UF ,NVL((SELECT L.NOM_PAIS FROM PAMAIS_PRD.V_CRP_LOCALIDADE L, PAMAIS_PRD.TCRP_ENDERECO_PESSOA E \t\tWHERE E.CTL_PESSO = MPV.CTL_MOTOT AND E.CTL_LOCAL = L.CTL_LOCAL AND NUM_ENDER_PES = 1),'') AS END_PAIS  ,NVL((SELECT COD_CEP FROM PAMAIS_PRD.TCRP_ENDERECO_PESSOA WHERE CTL_PESSO = MPV.CTL_MOTOT AND NUM_ENDER_PES = 1),'') AS END_CEP  ,NVL((SELECT NUM_DDD || '-' || COD_TELEF FROM PAMAIS_PRD.TCRP_TELEFONE_CONTATO \t    WHERE NUM_TELEF_PES = 1 AND CTL_PESSO = MPV.CTL_MOTOT AND ROWNUM <= 1),'') AS TELEFONE_FIXO  ,NVL(CV.DES_COMUN_VIN,'') AS TELEFONE_CELULAR  FROM SUPERVISOR.PLANO_VIAGEM PV  , SUPERVISOR.TINF_MOTORISTA_PLANO_VIAGEM MPV  , PAMAIS_PRD.V_CRP_MOTORISTA VMOT  , SUPERVISOR.ENDERECO_VINCULADO EV  , SUPERVISOR.TCOMUNICACAO_VINCULADO CV  WHERE pv.ctl_plvia = ?  AND MPV.CTL_PLVIA(+) = PV.CTL_PLVIA  AND VMOT.CTL_MOTOT(+) = MPV.CTL_MOTOT  AND MPV.CTL_MOTOT = EV.CTL_VINCD(+)  AND MPV.CTL_MOTOT = CV.CTL_VINCD(+)";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource((DataSource) this.oracleDataSource.oracleJndiDataSource());
	}

	public List<MotoristaViagemModel> getMotoristaViagemByCtlPlvia(long ctlPlvia) {
		LOGGER.debug("Executando metodo getMotoristaViagemByCtlPlvia...");

		List<MotoristaViagemModel> lstVeiculos = new ArrayList<>();

		try {
			LOGGER.debug("SQL-> " + SQL_MOTORISTA_VIAGEM_BY_CTL_PLVIA);
			lstVeiculos = getJdbcTemplate().query(SQL_MOTORISTA_VIAGEM_BY_CTL_PLVIA,
					new Object[] { ctlPlvia },new MotoristaViagemMapper());

			getJdbcTemplate().getDataSource().getConnection().close();
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Motorista nencontrado na viagem  [" + ctlPlvia + "]!");
			LOGGER.info("=> " + e);
			return null;
		} catch (SQLException e) {
			throw new ViagemException(
					"Erro na execução -> " + SQL_MOTORISTA_VIAGEM_BY_CTL_PLVIA + " Causa do Erro -> ",	e);
		}

		return lstVeiculos;
	}
}
