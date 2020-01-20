package br.com.pamcary.api.evento.dao.impl;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.pamcary.api.evento.dao.UsuarioDAO;
import br.com.pamcary.api.evento.dao.config.OracleDataSourceConfig;
import br.com.pamcary.api.evento.dao.mapper.UsuarioMapper;
import br.com.pamcary.api.evento.dao.model.UsuarioModel;
import br.com.pamcary.api.evento.exception.ViagemException;
import br.com.pamcary.api.evento.security.model.User;

@Repository
public class UsuarioDAOImpl extends JdbcDaoSupport implements UsuarioDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	private static final String SQL_BUSCA_USUARIO = " select ctl_user "+
													" ,usr_name "+
													" ,cod_senha " +
													" from usuario_internet " +
													" where usr_name = UPPER(?)";
	
	private static final String SQL_BUSCA_USUARIO_ATIVO_NA_OPERACAO = " select ui.ctl_user " + 
																		"      ,ui.ctl_vincd " + 
																		"      ,ui.usr_name " + 
																		"      ,ui.nom_user " + 
																		"      ,ui.cod_senha " + 
																		"      ,tp.ctl_vincd_emb " + 
																		"      ,tp.ctl_opera_tip " + 
																		"      ,tp.des_opera_tip " + 
																		" from usuario_internet ui " + 
																		"    ,relacionamento_vinculado rv " + 
																		"    ,tipo_operacao tp" +
																		" where ui.ctl_vincd = rv.ctl_vincd_rld " + 
																		"  and tp.ctl_vincd_emb = rv.ctl_vincd " + 
																		"  and rv.tip_relac = 4 " +
																		"  and ui.sta_senha = 'S' " +
																		"  and ui.usr_name = UPPER(?) " + 
																		"  and tp.ctl_opera_tip = ?";
	
	
	@Autowired
	private OracleDataSourceConfig oracleDataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(oracleDataSource.oracleJndiDataSource());
	}
	

	public User getUserByName(String userName) {
		LOGGER.debug("Executando metodo getUserByName...");
		
		UsuarioModel oUsuarioModel = null;
		
		try {
			LOGGER.debug("SQL-> " + SQL_BUSCA_USUARIO);
			oUsuarioModel = getJdbcTemplate().queryForObject(SQL_BUSCA_USUARIO, 
														new Object[] { userName }, 
														new UsuarioMapper());
				
			getJdbcTemplate().getDataSource().getConnection().close();					
		}catch (EmptyResultDataAccessException e) {
			LOGGER.info("Usuário ["+userName+"] não encontrado no Banco de Dados!");
			LOGGER.info("Erro => " + SQL_BUSCA_USUARIO + " => " + e);
			return null;

		
		}catch (SQLException e) {
			throw new ViagemException("Erro na execução! " + SQL_BUSCA_USUARIO +" Causa do Erro -> "+ e);
		}
		
		return new User(oUsuarioModel.getUsrName(), oUsuarioModel.getCodSenha(), "ADMIN");
		
	}
	
	@Override
	public UsuarioModel getUsuarioByOperacao(String nomUser, int ctlOperaTip) {
		LOGGER.debug("Executando metodo isUsuarioByOperacao...");
		UsuarioModel oUsuario = null;
		try {
			LOGGER.debug("SQL-> " + SQL_BUSCA_USUARIO_ATIVO_NA_OPERACAO);
			oUsuario = getJdbcTemplate().queryForObject(SQL_BUSCA_USUARIO_ATIVO_NA_OPERACAO, 
														new Object[] { 	nomUser,
																		ctlOperaTip 
																	}, 
														new UsuarioMapper());
				
			getJdbcTemplate().getDataSource().getConnection().close();					
		}catch (EmptyResultDataAccessException e) {
			LOGGER.info("Usuário ["+nomUser+"] não cadastrado na operação ["+ctlOperaTip+"]");
			LOGGER.info("=> " + e);
			return null;

		
		}catch (SQLException e) {
			throw new ViagemException("Erro na execução! " + SQL_BUSCA_USUARIO_ATIVO_NA_OPERACAO +" Causa do Erro -> "+ e);
		}
		
		return oUsuario;
	}
}
