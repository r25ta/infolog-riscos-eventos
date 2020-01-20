package br.com.pamcary.api.evento.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.pamcary.api.evento.dao.UsuarioDAO;

@Component
public class UsuarioInfologRiscosService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioInfologRiscosService.class);
	
	@Autowired
	private UsuarioDAO oUsuarioDAO;
	
	
	public boolean isUsuarioOperacao(int ctlOperaTip) {
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String nomUser = auth.getName();
	    
	    if((nomUser.trim().isEmpty())){
	    	return false;
	    }

		
		LOGGER.info("Verificando se o usuário ["+nomUser+"] possui acesso a operação ["+ctlOperaTip+"]");
		return oUsuarioDAO.getUsuarioByOperacao(nomUser, ctlOperaTip)!=null ? true : false;
		
	}
}
