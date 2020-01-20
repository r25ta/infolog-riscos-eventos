package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.VeiculoViagemModel;

public interface VeiculoViagemDAO {

	List<VeiculoViagemModel> getVeiculoViagemByCtlPlvia(long ctlPlvia);

}