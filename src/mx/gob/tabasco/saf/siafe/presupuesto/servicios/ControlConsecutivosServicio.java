package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IEmpleadoDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialSesionesDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialUsuarioDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IMapaPeticionDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IRolModuloDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Empleados;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialSesiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialUsuarios;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class ControlConsecutivosServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3249664682506635276L;

	protected final Logger log = Logger
			.getLogger(ControlConsecutivosServicio.class);

	@Resource
	private IEmpleadoDAO daoEmpleado;

	@Resource
	private IHistorialSesionesDAO daoHistorialSesiones;

	@Resource
	private IHistorialUsuarioDAO daoHistorialUsuario;

	@Resource
	private IMapaPeticionDAO daoMapaPeticion;
	
	@Resource
	private IUsuarioDAO daoUsuario;
	
	@Resource
	private IRolModuloDAO daoRolModulo;

	private Map<Object, Object> entities = new HashMap<Object, Object>();

	private Map<Object, Object> entitiesId = new HashMap<Object, Object>();

	@Autowired
	protected void init() {
		this.cargaCVE();
		this.cargaID();

	}

	private void cargaCVE() {
		try {
			log.info(" ENTRO A cargaCVE-----------------------------");

			entities.put("Empleados", daoEmpleado.findNextCve(Empleados.class));

			entities.put("HistorialSesiones",
					daoHistorialSesiones.findNextCve(HistorialSesiones.class));
			entities.put("HistorialUsuarios",
					daoHistorialUsuario.findNextCve(HistorialUsuarios.class));
			entities.put("MapasPeticiones", 
					daoMapaPeticion.findNextCve(MapasPeticiones.class));
			entities.put("Usuarios", daoUsuario.findNextCve(Usuarios.class));
			entities.put("RolesModulos", daoRolModulo.findNextCve(RolesModulos.class));

			log.info("MAPA CVE's " + entities);
		} catch (Exception e) {

			log.error("FALLO LA CARGA DE MAPA CVE's " + e);

		}

	}

	private void cargaID() {
		try {
			log.info(" ENTRO A cargaID-----------------------------");
			entitiesId.put("Usuarios", daoUsuario.findNextId(Usuarios.class));

			log.info("MAPA ID's " + entitiesId);
		} catch (Exception e) {

			log.error("FALLO LA CARGA DE MAPA ID's " + e);

		}
	}

	public synchronized Long obtieneCVE(String entity) {

		Long cve = (Long) entities.get(entity);
		log.info("obtieneCVE................... " + cve + " de la entidad: "
				+ entity);
		if (cve != null) {
			incrementaCVE(entity, cve);
			return cve;
		} else {
			entities.put(entity, 1);
			return 1L;
		}
	}

	private void incrementaCVE(String entity, Long cve) {
		Long cveNuevo = cve + 1;
		entities.put(entity, cveNuevo);
		log.info("incrementaCVE................... " + entities.get(entity));
	}

	public synchronized Long obtieneID(String entity) {
		Long id = (Long) entitiesId.get(entity);
		log.info("obtieneID................... " + id + " de la entidad: "
				+ entity);
		if (id != null) {
			incrementaID(entity, id);
			return id;
		} else {
			entitiesId.put(entity, 1);
			return 1L;
		}
	}

	private void incrementaID(String entity, Long id) {
		Long idNuevo = id + 1;
		entitiesId.put(entity, idNuevo);
		log.info("incrementaID................... " + entitiesId.get(entity));

	}

	public Map<Object, Object> getEntities() {
		return entities;
	}

	public void setEntities(Map<Object, Object> entities) {
		this.entities = entities;
	}

	public Map<Object, Object> getEntitiesId() {
		return entitiesId;
	}

	public void setEntitiesId(Map<Object, Object> entitiesId) {
		this.entitiesId = entitiesId;
	}

}
