package br.com.pamcary.api.evento.dao;

import java.util.List;

import br.com.pamcary.api.evento.dao.model.PamsatModel;

public interface PamsatDAO {
  public List<PamsatModel> getByCtlPLvia(long ctlPlvia);
}