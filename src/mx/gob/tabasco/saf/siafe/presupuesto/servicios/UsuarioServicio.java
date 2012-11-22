package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.constantes.Constantes;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.UsuarioF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.UsuarioRolF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.UsuarioHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.UsuarioRolHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IDependenciaDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUsuarioDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUsuarioRolDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.FechaUtils;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Dependencias;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Empleados;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Unidades;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.UsuariosRoles;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio implements IBaseService<Usuarios, Long> {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private IUsuarioDAO dao;
	
	@Resource
	private IUsuarioRolDAO usuarioRolDAO;

	@Resource
	private IDependenciaDAO dependenciaDao;

	@Resource
	private ControlConsecutivosServicio controlConsecutivoServicio;
	
	@Resource
	private PermisoUnidadUsuarioServicio permisoUnidad;

		
	@Resource
	private UsuarioSessionService usuarioSession;
	
//	@Resource
//	private MailServicio mailService;

//	@Resource
//	private GeneradorContraseniaServicio crearContrasenia;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<UsuarioF2B> findByNombreUsuario(String nombreUsuario) {
		List<Usuarios> usuarios = this.dao.findByNombreUsuario(nombreUsuario);
		List<UsuarioF2B> usuariosF2B = new ArrayList<UsuarioF2B>();
		
		for (Usuarios usuario : usuarios) {
			UsuarioF2B usuarioF2B = new UsuarioF2B();
			usuarioF2B.setCve(usuario.getCve());
			usuarioF2B.setNombreUsuario(usuario.getNombreUsuario());
			usuariosF2B.add(usuarioF2B);
		}
		
		return usuariosF2B;
	}
	
	@Transactional(readOnly = true)
	public List<UsuarioF2B> editarConsulta(String empleado,String usuario,Long cveEmpleado){
		List<Usuarios> usuarios = this.dao.listUsuariosByEmpleadoAndUsuario(this.permisoUnidad.listIdUnidadPermiso(), this.usuarioSession.isRol(Constantes.ROLE_ADMIN), empleado, usuario,cveEmpleado);
		return UsuarioHelper.convertListModelToListF2B(usuarios);
		
//		ConsultaSQLNativo query = new ConsultaSQLNativo();
//		query.setSqlNativo(
//				consultas.sql.presupuesto.usuarios.getSqlConsultaUsuario(this.permisoUnidad.listIdUnidadPermiso(),this.usuarioSession.isRol("ROLE_ADMIN"),empleado))
//				.setColumnas(
//						"cve, nombreUsuario,contrasenia, activo,fechaInicio, fechaVencimiento, nombreCompleto,cveEmpleado");
//		return consultas.gestor.consultar(query).getHasMapResult();
	}
	
	public boolean existeUsuario(String user){
		Usuarios usuario = this.dao.getUserByName(user);
		if(usuario==null){
			return false;
		}else{
			return true;
		}		
	}
	
	/**
	 * Trae la lista de roles asociados al usuario
	 * @param cveUsuario
	 * @return List<UsuariosRoles>
	 */
	@Transactional(readOnly = true)
	public List<UsuarioRolF2B> listUsuariosRoles(Long cveUsuario){
		return UsuarioRolHelper.convertListModelToListF2B(this.usuarioRolDAO.listUsuariosRoles(cveUsuario));		
	}

	@Transactional
	public List<UsuarioF2B> findByIdDependencia(Long idDependencia) {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		Dependencias dependencia = this.dependenciaDao.getActiveById(
				Dependencias.class, idDependencia);
		
		for (Unidades unidad : dependencia.getUnidadeses()) {
			for (Empleados empleado : unidad.getEmpleadoses()) {
				for(Usuarios usuario : empleado.getUsuarioses()){
					usuarios.add(usuario);
				}
			}
		}
		return convertListModelToListF2B(usuarios);
	}
	@Transactional
	public List<UsuarioF2B> listAllByPermisoUnidad(){	
		List<Long> idUnidades = this.permisoUnidad.listIdUnidadPermiso();
		boolean admin = this.usuarioSession.isRol("ROLE_ADMIN");
		List<Usuarios> usuarios = this.dao.listByIdUnidadesPermitidas(idUnidades,admin);
		return this.convertListModelToListF2B(usuarios);
	}

	@Transactional
	public List<UsuarioF2B> findByTodasDependencias() {
		List<Usuarios> usuarios = listAll(Usuarios.class);
		
		return convertListModelToListF2B(usuarios);
	}
	private List<UsuarioF2B> convertListModelToListF2B(List<Usuarios> usuarios) {
		return UsuarioHelper.convertListModelToListF2B(usuarios);
	}

	@Override
	public Usuarios getActiveById(Class<Usuarios> entity, Long id) {
		return this.dao.getActiveById(entity, id);
	}

	@Override
	public void delete(Usuarios entity) {
		this.dao.delete(entity);

	}

	@Override
	public void deleteHistorico(Usuarios entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuarios> listAll(Class<Usuarios> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<Usuarios> listAll(Class<Usuarios> entity, Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<Usuarios> listByPage(Class<Usuarios> entity, int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public Usuarios getByCve(Class<Usuarios> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(Usuarios entity) {
		log.debug("insert a user with entity: " + entity);
		String contrasenia;
		contrasenia = entity.getContrasenia();
		contrasenia = passwordEncoder.encodePassword(contrasenia, Constantes.SALT);
		entity.setContrasenia(contrasenia);
		entity.setCve(this.dao.findNextCve(Usuarios.class));
		entity.setFechaRegistro(FechaUtils.convertDatetoLong(new Date()));
		entity.setHoraRegistro(FechaUtils.convertTimetoLong(new Date()));
		entity.setId(this.findNextId());
		this.dao.insert(entity);
	}

	@Override
	public void insertHistorico(Usuarios entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuarios entity) {
		log.debug("Update a user with entity: " + entity);
		entity.setFechaRegistro(FechaUtils.convertDatetoLong(new Date()));
		entity.setHoraRegistro(FechaUtils.convertTimetoLong(new Date()));
		this.dao.update(entity);
	}

	@Override
	public void updateHistorico(Usuarios entity) {

	}

	@Override
	public Long countActiveRecords(Class<Usuarios> entity) {

		return null;
	}

	@Override
	public Long findNextCve() {
		return controlConsecutivoServicio.obtieneCVE("Usuarios");
	}

	@Override
	public Long findNextId() {
		return controlConsecutivoServicio.obtieneID("Usuarios");
	}

	@Override
	public Long getCveUsuario() {
		return null;
	}

	public boolean agregarUsuario(String nombre, String contrasenia,
			String contrasenia2, Long fechaInicio, Long fechaVencimiento,
			boolean activo, Long nombreEmpleado) {
		boolean result = true;
		Empleados empleado = new Empleados();
		Usuarios usuario = new Usuarios();
		empleado.setCve(nombreEmpleado);
		if (activo) {
			usuario.setActivo(1);
		} else {
			usuario.setActivo(0);
		}
		usuario.setContrasenia(contrasenia);
		usuario.setEmpleados(empleado);
		usuario.setNombreUsuario(nombre);
		usuario.setFechaInicioVigencia(fechaInicio);
		usuario.setFechaVencimientoVigencia(fechaVencimiento);

		try {
			this.insert(usuario);
		} catch (Exception ex) {
			result = false;
			return result;
		}
		return result;
	}

	public boolean editarUsuario(String nombre, String contrasenia,
			Long fechaInicio, Long fechaVencimiento, boolean activo,
			Long nombreEmpleado, Long cve) {
		Usuarios usuario = this.getByCve(Usuarios.class, cve);
		Empleados empleado = new Empleados();
		empleado.setCve(nombreEmpleado);
		if (activo) {
			usuario.setActivo(1);
		} else {
			usuario.setActivo(0);
		}
		usuario.setCve(cve);
		usuario.setEmpleados(empleado);
		usuario.setNombreUsuario(nombre);
		usuario.setFechaInicioVigencia(fechaInicio);
		usuario.setFechaVencimientoVigencia(fechaVencimiento);
		if (contrasenia == "" || contrasenia == null) {
			Usuarios nuevousuario = new Usuarios();
			nuevousuario = this.getByCve(Usuarios.class, cve);
			usuario.setContrasenia(nuevousuario.getContrasenia());
		} else {
			usuario.setContrasenia(passwordEncoder.encodePassword(contrasenia,
					"P5e."));
		}
		this.update(usuario);
		return true;
	}
	
	@Transactional
	public void asignarRol(Long cveUsuario, String role){
		try {
			Usuarios usuario = this.getByCve(Usuarios.class,cveUsuario);
			Set<Roles> rolSet = usuario.getRoles();
			
			Roles rol = new Roles();
			rol.setRol(role);
			rolSet.add(rol);
			
			usuario.setRoles(rolSet);
			this.update(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error en asignarRol: ",e);
		}
	}

	public void eliminarRol(Long cveUsuario,String rol){
		UsuariosRoles usuarioRol = this.usuarioRolDAO.getByCveAndRol(cveUsuario, rol);
		this.usuarioRolDAO.delete(usuarioRol);
	}
	
//	public boolean recuperarContrasenia(String nombre) {
//		try {
//			Usuarios usuario = this.dao.getUserByName(nombre);
//			if (!usuario.equals(null)) {
//				String contrasenia = crearContrasenia.generarNueva(5);
//				String email = usuario.getEmpleados().getCorreoElectronico();
//				usuario.setContrasenia(passwordEncoder.encodePassword(
//						contrasenia, "P5e."));
//				this.update(usuario);
//				mailService.enviarMail("noReply@pse.mx", email,
//						"Recuperacion de contraseña",
//						"Su nueva contraseña es: " + contrasenia
//								+ " ,para el usuario: " + nombre);
//			}
//		} catch (Exception e) {
//			log.error("Recuperacion de contraseña falló: " + e);
//			mailService.enviarAlertaMail("Exception occurred" + e);
//			return false;
//		}
//		return true;
//	}

	public boolean restaurarContrasenia(String nombre,
			String anteriorContrasenia, String nuevaContrasenia,
			String confirmacionContrasenia) {
		boolean result = false;
		try {
			Usuarios usuario = this.dao.getUserByName(nombre);
			if (!usuario.equals(null)) {
				if (passwordEncoder.isPasswordValid(usuario.getContrasenia(),
						anteriorContrasenia, "P5e.")) {
					if (nuevaContrasenia.equals(confirmacionContrasenia)) {
						usuario.setContrasenia(passwordEncoder.encodePassword(
								nuevaContrasenia, "P5e."));
						this.update(usuario);
						result = true;
					}
				}
			}
		} catch (Exception e) {
			log.error("Restaurar contraseña falló " + e);
			return result;
		}
		return result;
	}
	
	
	public void activarUsuarios(List<UsuarioF2B> usuariosF2B){
		Usuarios usuario;
		for(UsuarioF2B usuarioF2B: usuariosF2B){
			usuario = getByCve(Usuarios.class, usuarioF2B.getCve());
			usuario.setNombreUsuario(usuarioF2B.getNombreUsuario());
			usuario.setActivo(usuarioF2B.getActivo());
			this.dao.update(usuario);
		}
	}
	public void desactivarUsuarios(List<UsuarioF2B> usuariosF2B){
		Usuarios usuario;
		for(UsuarioF2B usuarioF2B: usuariosF2B){
			usuario = getByCve(Usuarios.class, usuarioF2B.getCve());
			usuario.setNombreUsuario(usuarioF2B.getNombreUsuario());
			usuario.setActivo(usuarioF2B.getActivo());
			this.dao.update(usuario);
		}
	}
}
