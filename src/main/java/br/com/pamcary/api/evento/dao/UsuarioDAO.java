package br.com.pamcary.api.evento.dao;

import br.com.pamcary.api.evento.dao.model.UsuarioModel;
import br.com.pamcary.api.evento.security.model.User;

public interface UsuarioDAO {

	public UsuarioModel getUsuarioByOperacao(String nomUser, int ctlOperaTip);
	
	public User getUserByName(String userName);

}