
package br.com.pamcary.api.evento.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.pamcary.api.evento.dao.UsuarioDAO;
import br.com.pamcary.api.evento.exception.BadRequestAlertException;
import br.com.pamcary.api.evento.security.model.User;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

	
	private final UsuarioDAO oUsuarioDAO;
	
	@Autowired
	public UserDetailsServiceImp(UsuarioDAO usuarioDAO){
		this.oUsuarioDAO = usuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if((username.trim().isEmpty()) && (username!=null)) {
			throw new BadRequestAlertException("Preencher Login no header!");
		}
		
		User oUser = Optional.ofNullable(oUsuarioDAO.getUserByName(username)).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!")) ;
		
		List<GrantedAuthority> authLstAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		
		return new org.springframework.security.core.userdetails.User(oUser.getUsername(), oUser.getPassword(), authLstAdmin);

	}
	
}
