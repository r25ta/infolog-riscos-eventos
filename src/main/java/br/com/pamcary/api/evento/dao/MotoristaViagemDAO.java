package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.MotoristaViagemModel;

public interface MotoristaViagemDAO {
	public List<MotoristaViagemModel> getMotoristaViagemByCtlPlvia(long ctlPlvia);
}