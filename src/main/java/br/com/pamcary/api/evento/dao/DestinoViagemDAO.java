package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.DestinoViagemModel;


public interface DestinoViagemDAO {
	public List<DestinoViagemModel> getByCtlPlvia(long ctlPlvia);
}
