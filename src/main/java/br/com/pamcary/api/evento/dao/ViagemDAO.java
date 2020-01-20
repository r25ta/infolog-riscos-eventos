package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.ViagemModel;

public interface ViagemDAO {	
	public void ctlOperaTip(int ctlOperaTip);
	public List<ViagemModel> getByCtlPLvia(long ctlPLvia);
	public List<ViagemModel> getByCtlOperaTip(int ctlOperaTip);
	public List<ViagemModel> getByCodDocumentoProprio(String codDocum);
	
}
