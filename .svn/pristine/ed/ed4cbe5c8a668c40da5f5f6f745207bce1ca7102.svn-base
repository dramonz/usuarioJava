package mx.gob.tabasco.saf.siafe.presupuesto.servicios.usuarios;

import java.util.ArrayList;
import java.util.Collection;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CustomUserDetails;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("assembler")
public class UserAssembler {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Transactional(readOnly = true)
	CustomUserDetails buildUserFromUserEntity(Usuarios userEntity) {

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Roles role : userEntity.getRoles()) {
			authorities.add(new GrantedAuthorityImpl(role.getRol()));
		}

		CustomUserDetails user = new CustomUserDetails(userEntity.getNombreUsuario(),
				userEntity.getContrasenia(), userEntity, userEntity.getEmpleados().getNombreCompleto(), authorities);

		log.info("User Assembler " + user);
		return user;
	}
}
