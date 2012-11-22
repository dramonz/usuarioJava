package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CatalogosPeticiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.MapaPeticionF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.ICatalogoPeticionDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IMapaPeticionDAO;
//import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.ConsultasUtileria;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MapaPeticionesServicio implements
		IBaseService<MapasPeticiones, Long> {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private IMapaPeticionDAO dao;

	@Resource
	private ICatalogoPeticionDAO daoCatalogoPeticion;

//	@Resource
//	private ConsultasUtileria consultas;

	@Resource
	private ControlConsecutivosServicio controlConsecutivoServicio;

	@Transactional(readOnly = true)
	public List<MapaPeticionF2B> getByRol(String rol) {
		List<MapaPeticionF2B> mapaPeticiones = new ArrayList<MapaPeticionF2B>();
		List<MapasPeticiones> peticiones = this.dao.getByRol(rol);

		for (MapasPeticiones peticion : peticiones) {
			MapaPeticionF2B mapaPeticion = new MapaPeticionF2B();
			List<CatalogosPeticiones> list = this.daoCatalogoPeticion.findCatalogoPeticionByUrl(peticion.getUrl());
			mapaPeticion.setDescripcion(list.size()>0?list.get(0).getDescripcion():"Sin descripción");
			mapaPeticion.setRol(peticion.getRol());
			mapaPeticion.setUrl(peticion.getUrl());
			mapaPeticiones.add(mapaPeticion);
		}

		return mapaPeticiones;
	}

	@Override
	public MapasPeticiones getActiveById(Class<MapasPeticiones> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(MapasPeticiones entity) {
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = null;
		String roles = null;
		String[] arregloRoles = null;
		int ultimoCaracter = 0;
		String url = entity.getUrl();
		String rol = entity.getRol();
		MapasPeticiones map = this.dao.findRolByUrl(url);
		if (map != null) {
			roles = map.getRol();
			if (roles.indexOf(rol) != -1) {
				arregloRoles = roles.split(",");
				if (arregloRoles.length > 1) {
					roles = "";
					for (String role : arregloRoles) {
						if (!role.equals(rol)) {
							roles += role + ",";
							ca = new SecurityConfig(role);
							atts.add(ca);
						}
					}
					ultimoCaracter = roles.lastIndexOf(",");
					rol = roles.substring(0, ultimoCaracter);

					CustomSecureResourceFilter.resourceMap.put(url, atts);
					map.setRol(rol);
					this.dao.update(map);
				} else {
					if (CustomSecureResourceFilter.resourceMap.containsKey(url)) {
						CustomSecureResourceFilter.resourceMap.remove(url);
					}
					this.dao.delete(map);
				}
			}
		}
	}

	@Override
	public void deleteHistorico(MapasPeticiones entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MapasPeticiones> listAll(Class<MapasPeticiones> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<MapasPeticiones> listAll(Class<MapasPeticiones> entity, Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<MapasPeticiones> listByPage(Class<MapasPeticiones> entity,
			int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public MapasPeticiones getByCve(Class<MapasPeticiones> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MapasPeticiones entity) {
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = null;
		String[] arregloRoles = null;
		String url = entity.getUrl();
		String rol = entity.getRol();
		String roles = null;
		MapasPeticiones map = this.dao.findRolByUrl(url);

		if (map != null) {
			roles = map.getRol();
			if (roles.indexOf(rol) != -1) {
				rol = roles;
			} else {
				rol = roles + "," + rol;
				map.setRol(rol);
				this.dao.update(map);
			}
		} else {
			entity.setCveMapaPeticion(this.findNextCve());
			this.dao.insert(entity);
		}
		arregloRoles = rol.split(",");
		for (String role : arregloRoles) {
			ca = new SecurityConfig(role.trim());
			atts.add(ca);
		}
		CustomSecureResourceFilter.resourceMap.put(url, atts);
	}

	@Override
	public void insertHistorico(MapasPeticiones entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MapasPeticiones entity) {
		this.dao.update(entity);
	}

	@Override
	public void updateHistorico(MapasPeticiones entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long countActiveRecords(Class<MapasPeticiones> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		return this.controlConsecutivoServicio.obtieneCVE("MapasPeticiones");
	}

	@Override
	public Long findNextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void agregarPermisosRol(String rol, Long[] cveCatPeticion) {
		for (int i = 0; i < cveCatPeticion.length; i++) {
			CatalogosPeticiones catalogoPeticion = this.daoCatalogoPeticion
					.getByCve(CatalogosPeticiones.class, cveCatPeticion[i]);
			
			if (catalogoPeticion.getUrl().indexOf("*") != -1) {
				continue;
			}
			
			boolean existe = this.dao.getByRolAndUrl(rol,
					catalogoPeticion.getUrl()) != null;

			if (!existe) {
				MapasPeticiones mapaPeticion = new MapasPeticiones();
				mapaPeticion.setRol(rol);
				mapaPeticion.setUrl(catalogoPeticion.getUrl());

				this.insert(mapaPeticion);
			}
		}
	}

	@Transactional
	public void eliminarPermisosRol(String url, String rol) {
		MapasPeticiones mapaPeticion = new MapasPeticiones();
		mapaPeticion.setRol(rol);
		mapaPeticion.setUrl(url);

		this.delete(mapaPeticion);
	}
	
	public void cargarPermisos(){
		  try {
		   List<MapasPeticiones> mapaPeticion = this.dao
		     .findAll(MapasPeticiones.class);
		   ConfigAttribute ca;
		   String[] arregloRoles = null;
		   for (MapasPeticiones mapa : mapaPeticion) {
		    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		    String url = mapa.getUrl();
		    String rol = mapa.getRol();
		    arregloRoles = rol.split(",");
		    for (String role : arregloRoles) {
		     ca = new SecurityConfig(role.trim());
		     atts.add(ca);
		    }
		    CustomSecureResourceFilter.resourceMap.put(url, atts); 
		   }
		   log.info("Permisos cargados con Éxito");
		  } catch (Exception e) {
		   log.error("Error al cargar permisos", e);
		  }
		 }

}
