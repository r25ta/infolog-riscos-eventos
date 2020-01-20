package br.com.pamcary.api.evento.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.pamcary.api.evento.dao.model.UsuarioModel;

public class UsuarioMapper implements RowMapper<UsuarioModel> {

	@Override
	public UsuarioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioModel oUsuario = new UsuarioModel();
		
		oUsuario.setCtlUser(rs.getInt("ctl_user"));
		oUsuario.setUsrName(rs.getString("usr_name"));
		oUsuario.setCodSenha(rs.getString("cod_senha"));
		
		return oUsuario;
	}

}
