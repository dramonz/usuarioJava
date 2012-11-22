package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CustomUserDetails;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.constantes.Constantes;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUsuarioDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.excepciones.PasswordDontMatchException;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.ConsultasUtileria;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioSessionService {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
//	@Resource
//	DependenciaServicio dependenciaS;
	
	@Resource
	ConsultasUtileria consultas;
	
	@Resource
	private IUsuarioDAO usuarioDao;
	
	@Resource
	private PasswordEncoder passwordEncoder;
	
	public boolean isRol(String rol) {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		boolean result = false;
		//log.info("Getting Rol "+  rol);
		for(Roles roles :usuario.getRoles()){
			if(roles.getRol().equals(rol)){
				result = true;
				break;
			}
		}
		log.info("Getting Rol "+  rol +": "+ result);
		return result;
	}
	
	public String getRol() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		log.info("Getting Roles");
		List<Roles> rol = new ArrayList<Roles>();
		for(Roles roles :usuario.getRoles()){
			rol.add(roles);
		}
		return rol.get(0).getRol();
	}
	
	
	public String getGrupoUnidades() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		
//		String codigo_unidad = usuario.getEmpleados().getUnidades().getCodigo();
//		String codigo_dependencia = usuario.getEmpleados().getUnidades().getDependencias().getCodigo();
		
		String query_codigo_grupo = "select codigo_grupo from unidades_grupos where codigo_dependencia = '%s' AND codigo_unidad = '%s'";
		
//		query_codigo_grupo = String.format(query_codigo_grupo, codigo_dependencia, codigo_unidad);
		
		
		String codigo_grupo = (String) consultas.gestor.traerUnValor(query_codigo_grupo);
		
		
		
		log.info("Getting CODIGO_UNIDAD");
		
		
		return codigo_grupo;
	}

	
	
	
	public Long getCveUsuario() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		log.info("Getting Cve Usuarios");
		return usuario.getCve();
	}

	
	public Long getIdDependencia() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		log.info("Getting IdDependencia");
		return null;
	}

	
	public Long getCveDependencia() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
//		log.info("Getting Cve Dependencias "+usuario.getEmpleados().getUnidades().getDependencias().getCve());
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombreUsuario() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		return ((Usuarios) user.getDetails()).getNombreUsuario();
	}
	
	/**
	 * 
	 * @return
	 */
	public Usuarios getUsuario() {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		return (Usuarios) user.getDetails();
	}
	
	/**
	 * 
	 * @param currentPassword
	 * @param newPassword
	 */
	@Transactional
	public void updateCredenciales(String currentPassword, String newPassword) {
		Usuarios usuario = this.getUsuario();
		
		if (!usuario.getContrasenia().equals(passwordEncoder.encodePassword(
				currentPassword, Constantes.SALT))) {
			throw new PasswordDontMatchException(
					"La contraseña proporcionada no coincide con su contraseña actual");
		}
		
		usuario.setContrasenia(passwordEncoder.encodePassword(newPassword, Constantes.SALT));
		this.usuarioDao.update(usuario);
		
		this.getCustomUserDetails().setCredentials(usuario.getContrasenia());
	}

	/**
	 * 
	 * @return
	 */
	private CustomUserDetails getCustomUserDetails() {
		return (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
	}
	
}
