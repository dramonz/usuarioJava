package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IPermisoUnidadUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosUnidadesUsuario;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosUnidadesUsuarioId;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermisoUnidadUsuarioServicio implements
		IBaseService<PermisosUnidadesUsuario, Long> {

	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	IPermisoUnidadUsuarioDAO dao;
	
	@Resource
	UsuarioSessionService usuarioSession;
	
	/**
	 * Lista los id de las unidades que el usuario tiene permitido ver
	 * @return Arreglo de ids de unidades
	 */
	public List<Long> listIdUnidadPermiso(){		
		List<PermisosUnidadesUsuario> listaPermisos = this.dao.findByUsuario(this.getCveUsuario());
		List<Long> idUnidades = new ArrayList<Long>();
		for(PermisosUnidadesUsuario p:listaPermisos){
			idUnidades.add(p.getId().getIdUnidad());
		}
		return idUnidades;
	}

	@Transactional
 	public void insertPermisoUnidad(Long cveUsuario, Long... idUnidad) {
		try {
			for (Long idUnit : idUnidad) {
				PermisosUnidadesUsuario permisoUnidad = new PermisosUnidadesUsuario();
				PermisosUnidadesUsuarioId permiso = new PermisosUnidadesUsuarioId();
				permiso.setCveUsuario(cveUsuario);
				//SE ENCUENTRA ESTATICO EL VALOR DEL MODULO SI ESTE SE REQUIERE GENERAR LA ASIGNACION DE FORMA 
				//DINAMICA LAS UNIDADES POR MODULO 
				permiso.setCveModulo(1L);
				permiso.setIdUnidad(idUnit);
				permisoUnidad.setId(permiso);			
				this.insert(permisoUnidad);
			}
		
		}catch (RuntimeException re){
			log.error("Error al insertar perimisos a unidades: ",re);
			throw re;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error al insertar perimisos a unidades: ",e);
		}
	}

	@Transactional
	public void updatePermisoUnidad(Long cveUsuario, Long... idUnidad) {
		try {
			List<PermisosUnidadesUsuario> listaPermisos = this.dao
					.findByUsuario(cveUsuario);
			for (PermisosUnidadesUsuario permiso : listaPermisos) {
				this.delete(permiso);
			}
			for (Long idUnit : idUnidad) {
				PermisosUnidadesUsuario permisoUnidad = new PermisosUnidadesUsuario();
				PermisosUnidadesUsuarioId permiso = new PermisosUnidadesUsuarioId();
				permiso.setCveUsuario(cveUsuario);
				//SE ENCUENTRA ESTATICO EL VALOR DEL MODULO SI ESTE SE REQUIERE GENERAR LA ASIGNACION DE FORMA 
				//DINAMICA LAS UNIDADES POR MODULO 
				permiso.setIdUnidad(idUnit);	
				permiso.setCveModulo(1L);
				permisoUnidad.setId(permiso);
				this.insert(permisoUnidad);
			}
		}catch (RuntimeException re){
			log.error("Error al actualizar perimisos a unidades: ",re);
			throw re;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error al actualizar perimisos a unidades: ",e);
		}
	}

	/**
	 * Deletes all the unit permission 
	 * of the user selected
	 * 
	 * @param Long cveUsuario
	 * @param idUnidad
	 */
	public void deletePermisoUnidad(Long cveUsuario, Long... idUnidad) {
		for (Long unidad : idUnidad) {
			PermisosUnidadesUsuario permiso = this.dao.findByUsuarioUnidad(
					cveUsuario, unidad);
			this.dao.delete(permiso);
		}
	}

	@Override
	public PermisosUnidadesUsuario getActiveById(
			Class<PermisosUnidadesUsuario> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PermisosUnidadesUsuario entity) {
		this.dao.delete(entity);

	}

	@Override
	public void deleteHistorico(PermisosUnidadesUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PermisosUnidadesUsuario> listAll(Class<PermisosUnidadesUsuario> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosUnidadesUsuario> listAll(
			Class<PermisosUnidadesUsuario> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosUnidadesUsuario> listByPage(
			Class<PermisosUnidadesUsuario> entity, int from, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermisosUnidadesUsuario getByCve(Class<PermisosUnidadesUsuario> entity,
			Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PermisosUnidadesUsuario entity) {
		this.dao.insert(entity);

	}

	@Override
	public void insertHistorico(PermisosUnidadesUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PermisosUnidadesUsuario entity) {
		this.dao.update(entity);

	}

	@Override
	public void updateHistorico(PermisosUnidadesUsuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long countActiveRecords(Class<PermisosUnidadesUsuario> entity) {
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
		return usuarioSession.getCveUsuario();
	}

}
