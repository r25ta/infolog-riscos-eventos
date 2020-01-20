package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.RoteiroViagemModel;

public interface RoteiroViagemDAO {
	public List<RoteiroViagemModel> getByCtlPlvia(long ctlPlvia);
	public RoteiroViagemModel getByCtlRtmot(long ctlRtmot);
	public List<RoteiroViagemModel> getByEventosPorDestino(long ctlPlvia);
	
}
