package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.EventoModel;


public interface EventoDAO {
	
	public List<EventoModel> getByDocumentoProprio(String codDocum);
	
	public List<EventoModel> getByCtlPlvia(long ctlPlvia);
	
}
