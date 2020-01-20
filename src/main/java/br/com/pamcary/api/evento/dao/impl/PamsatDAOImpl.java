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

import br.com.pamcary.api.evento.dao.PamsatDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.PamsatMapper;
import br.com.pamcary.api.evento.dao.model.PamsatModel;
import br.com.pamcary.api.evento.exception.ViagemException;

@Repository
public class PamsatDAOImpl extends JdbcDaoSupport implements PamsatDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(PamsatDAOImpl.class);

	private static final String SQL_QUERY_INF_ALTERA_STATUS_PLANO_KRONA = " SELECT ctl_alter_sta , NVL(ctl_plano_krona,'') AS ctl_plano_krona, NVL(sta_plano_krona,'') AS sta_plano_krona, TO_CHAR(dhr_alter,'DD/MM/YYYY HH24:MI:SS') as dhr_alter FROM INF_ALTERA_STATUS_PLANO_KRONA   WHERE CTL_PLVIA = ?   ORDER BY ctl_alter_sta DESC";

	@Autowired
	private OracleDataSourceConfig oracleDataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(this.oracleDataSource.oracleJndiDataSource());
	}

	@Override
	public List<PamsatModel> getByCtlPLvia(long ctlPlvia) {
		  LOGGER.debug("Executando metodo getByViagem...");
		    List<PamsatModel> lstPamsat = new ArrayList<>();
		    
		    try {
		      LOGGER.debug("SQL-> " + SQL_QUERY_INF_ALTERA_STATUS_PLANO_KRONA);
		      lstPamsat = getJdbcTemplate().query(SQL_QUERY_INF_ALTERA_STATUS_PLANO_KRONA, new Object[] {ctlPlvia }, new PamsatMapper());
		      
		      getJdbcTemplate().getDataSource().getConnection().close();
		    
		    }
		    catch (EmptyResultDataAccessException e) {
		      LOGGER.info("Informacao nao encontrada no Banco de Dados para ctl_plvia [" + ctlPlvia + "]");
		      LOGGER.info("=> " + e);
		      return null;
		      
		    }
		    catch (SQLException e) {
		      throw new ViagemException("Erro na execucao -> " + SQL_QUERY_INF_ALTERA_STATUS_PLANO_KRONA, e);
		      
		    } 
		    return lstPamsat;
	}

}
