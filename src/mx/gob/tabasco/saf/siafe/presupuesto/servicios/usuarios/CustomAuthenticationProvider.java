package mx.gob.tabasco.saf.siafe.presupuesto.servicios.usuarios;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.imp.UsuarioDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.MapaPeticionesServicio;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.PermisosRolesModuloServicio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UsuarioDAO dao;
	
	@Autowired
	private UserAssembler assembler;
	
	@Resource
	private MapaPeticionesServicio mapaPeticionesServicio;
	
	@Resource
	private PermisosRolesModuloServicio permisosRolesModuloServicio;
	

	@Transactional(readOnly = true)
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		String username = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());
		Usuarios userEntity = this.dao.getUsuarioByCredentials(username,password);
		
		this.permisosRolesModuloServicio.verificaPermisosModulo(userEntity);
		
		this.mapaPeticionesServicio.cargarPermisos();		
		return this.assembler.buildUserFromUserEntity(userEntity);
	}

	public boolean supports(Class<? extends Object> arg0) {
		return true;
	}
	
	
}