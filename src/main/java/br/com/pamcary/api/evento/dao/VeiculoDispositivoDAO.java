package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.VeiculoDispositivoModel;

public interface VeiculoDispositivoDAO {

	public List<VeiculoDispositivoModel> getDispositivoVeiculoByCtlVeicu(long ctlVeicu);

}