package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IPermisoProyectoUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosProyectosUsuario;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosProyectosUsuarioId;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermisoProyectoUsuarioServicio implements
		IBaseService<PermisosProyectosUsuario, Long> {

	@Resource
	IPermisoProyectoUsuarioDAO dao;
	
	@Resource
	UsuarioSessionService usuarioSession;
	
	/**
	 * Lista los id de los proyecto que el usuario no tiene permisos
	 * @return Arreglo de ids de proyectos
	 */
	public List<Long> listIdProyectosNoPermitidos(){
		List<PermisosProyectosUsuario> listaPermisos = this.dao.findByUsuario(this.getCveUsuario());
		List<Long> idProyectos = new ArrayList<Long>();
		for(PermisosProyectosUsuario p:listaPermisos){
			idProyectos.add(p.getId().getIdProyecto());
		}
		return idProyectos;
	}

	@Transactional
	public void insertPermisoProyecto(Long cveUsuario, Long... idProyecto) {
		List<Long> proyectosProcesados = new ArrayList<Long>();
		Usuarios usuario = new Usuarios();
		usuario.setCve(cveUsuario);
		for (Long idProy : idProyecto) {
			if (proyectosProcesados.contains(idProy)) {
				continue;
			}
			
			proyectosProcesados.add(idProy);
			PermisosProyectosUsuario permisoProy = new PermisosProyectosUsuario();
			PermisosProyectosUsuarioId pe = new PermisosProyectosUsuarioId();
			pe.setCveUsuario(cveUsuario);
			pe.setIdProyecto(idProy);
			permisoProy.setId(pe);
			permisoProy.setUsuarios(usuario);
			insert(permisoProy);
		}
	}

	public void updatePermisoProyecto(Long cveUsuario, Long... idProyecto) {
		Usuarios usuario = new Usuarios();
		usuario.setCve(cveUsuario);
		List<PermisosProyectosUsuario> listaPermisos = this.dao
				.findByUsuario(cveUsuario);
		for (PermisosProyectosUsuario permiso : listaPermisos) {
			delete(permiso);
		}
		for (Long idProy : idProyecto) {
			PermisosProyectosUsuario permisoProy = new PermisosProyectosUsuario();
			PermisosProyectosUsuarioId pe = new PermisosProyectosUsuarioId();
			pe.setCveUsuario(cveUsuario);
			pe.setIdProyecto(idProy);
			permisoProy.setId(pe);
			permisoProy.setUsuarios(usuario);
			insert(permisoProy);
		}
	}

	@Transactional
	public void deletePermisoProyecto(Long cveUsuario, Long... idProyecto) {
		List<Long> proyectosProcesados = new ArrayList<Long>();
		for (Long proyecto : idProyecto) {
			if (proyectosProcesados.contains(proyecto)) {
				continue;
			}
			
			proyectosProcesados.add(proyecto);
			PermisosProyectosUsuario permiso = this.dao.findByUsuarioProyecto(
					cveUsuario, proyecto);
			this.dao.delete(permiso);
		}
	}

	@Override
	public PermisosProyectosUsuario getActiveById(
			Class<PermisosProyectosUsuario> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PermisosProyectosUsuario entity) {
		this.dao.delete(entity);
	}

	@Override
	public void deleteHistorico(PermisosProyectosUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PermisosProyectosUsuario> listAll(
			Class<PermisosProyectosUsuario> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosProyectosUsuario> listAll(
			Class<PermisosProyectosUsuario> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosProyectosUsuario> listByPage(
			Class<PermisosProyectosUsuario> entity, int from, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermisosProyectosUsuario getByCve(
			Class<PermisosProyectosUsuario> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PermisosProyectosUsuario entity) {
		this.dao.insert(entity);

	}

	@Override
	public void insertHistorico(PermisosProyectosUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PermisosProyectosUsuario entity) {
		this.dao.update(entity);

	}

	@Override
	public void updateHistorico(PermisosProyectosUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long countActiveRecords(Class<PermisosProyectosUsuario> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return this.usuarioSession.getCveUsuario();
	}

}
