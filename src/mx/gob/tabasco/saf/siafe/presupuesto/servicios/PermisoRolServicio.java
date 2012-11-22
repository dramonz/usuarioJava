package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CatalogosPeticiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.NodoF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.ICatalogoPeticionDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IMapaPeticionDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IRolModuloDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author José Luis Landero
 *
 */
@Service
public class PermisoRolServicio {
	
	@Resource
	private ICatalogoPeticionDAO catalogoPeticionDao;
	
	@Resource
	private IMapaPeticionDAO mapaPeticionDao;
	
	@Resource
	private IRolModuloDAO rolModuloDao;
	
	@Resource
	private MapaPeticionesServicio mapaPeticionServicion;
	
	/**
	 * 
	 * @param rol
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<NodoF2B> getPermisosByRol(String rol) {
		return this.getArbolPermisos(this.getCatalogosPeticionesByRol(rol));
	}
	
	/**
	 * 
	 * @param rol
	 * @return
	 */
	@Transactional(readOnly = true)
	private List<CatalogosPeticiones> getCatalogosPeticionesByRol(String rol) {
		List<MapasPeticiones> mapasPeticiones = this.mapaPeticionDao.getByRol(rol);
		List<String> urls = new ArrayList<String>();
		List<CatalogosPeticiones> catalogosPeticiones = new ArrayList<CatalogosPeticiones>();
		for (MapasPeticiones mapaPeticion : mapasPeticiones) {
			if ((urls.size()/500) == 1) {
				catalogosPeticiones.addAll(this.catalogoPeticionDao.findByUrl(urls));
				urls.clear();
			}
			
			urls.add(mapaPeticion.getUrl());
		}
		
		if (urls.size() != 0) {
			catalogosPeticiones.addAll(this.catalogoPeticionDao.findByUrl(urls));
		}
		
		return catalogosPeticiones;
	}
	
	/**
	 * 
	 * @param rol
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<NodoF2B> getAllPermisosByRol(String rol) {
		List<CatalogosPeticiones> catalogosPeticiones = this.getCatalogosPeticionesByRol(rol);
		List<Long> permisosOtorgados = new ArrayList<Long>();
		for (CatalogosPeticiones peticion : catalogosPeticiones) {
			permisosOtorgados.add(peticion.getCve());
		}
		
		
		List<RolesModulos> permisoModulos = this.rolModuloDao.getByRol(rol);
		List<Long> modulos = new ArrayList<Long>();
		for (RolesModulos permisoModulo : permisoModulos) {
			modulos.add(permisoModulo.getModulos().getCve());
		}
		
		List<NodoF2B> nodos = new ArrayList<NodoF2B>();
		List<CatalogosPeticiones> permisos = this.catalogoPeticionDao.getUrlsPadresByPermisosRol(modulos);
		for (CatalogosPeticiones permiso : permisos) {
			NodoF2B nodo = new NodoF2B();
			nodo.setLeaf(false);
			nodo.setId(permiso.getCve());
			nodo.setText(permiso.getModulos().getNombre() + ": " + permiso.getDescripcion());
			
			if (permisosOtorgados.contains(permiso.getCve())) {
				nodo.setChecked(true);
			} else {
				nodo.setChecked(false);
			}
			
			if (permiso.getCatalogosPeticioneses().size() > 0) {
				nodo.setExpanded(true);
				nodo.setChildren(this.getHijosNodoModulo(permiso, permisosOtorgados));
			} else {
				if (permiso.getCatalogosPeticioneses().size() == 0) {
					nodo.setLeaf(true);
				}
			}
			
			nodos.add(nodo);
		}
		
		return nodos;
	}
	
	/**
	 * 
	 * @param rol
	 * @param cveCatalogoPeticion
	 */
	@Transactional
	public void deletePermisos(String rol, Long[] cveCatalogoPeticion) {
		List<CatalogosPeticiones> catalogosPeticiones = this.catalogoPeticionDao
				.findByCve(cveCatalogoPeticion);
		for (CatalogosPeticiones catalogoPeticion : catalogosPeticiones) {
			this.mapaPeticionServicion.eliminarPermisosRol(catalogoPeticion.getUrl(), rol);
		}
	}
	
	/**
	 * 
	 * @param padre
	 * @param permisosOtorgados
	 * @return
	 */
	@Transactional(readOnly = true)
	private List<NodoF2B> getHijosNodoModulo(CatalogosPeticiones padre, List<Long> permisosOtorgados) {
		List<NodoF2B> nodos =  new ArrayList<NodoF2B>();
		for (CatalogosPeticiones url : padre.getCatalogosPeticioneses()) {
			NodoF2B nodoHijo = new NodoF2B();
			nodoHijo.setText(url.getDescripcion());
			nodoHijo.setId(url.getCve());
			if(url.getCatalogosPeticioneses().size() > 0){
				nodoHijo.setExpanded(true);
				nodoHijo.setLeaf(false);
				nodoHijo.setChildren(this.getHijosNodoModulo(url, permisosOtorgados));
			} else {
				if(url.getCatalogosPeticioneses().size() == 0){
					nodoHijo.setLeaf(true);
					nodoHijo.setChildren(null);
				}
			}
			
			if (permisosOtorgados.contains(url.getCve())) {
				nodoHijo.setChecked(true);
			} else {
				nodoHijo.setChecked(false);
			}
			
			nodos.add(nodoHijo);
		}
		
		return nodos;
	}
	
	/**
	 * 
	 * @param catalogosPeticiones
	 * @return
	 */
	private List<NodoF2B> getArbolPermisos(
			List<CatalogosPeticiones> catalogosPeticiones) {
		List<NodoF2B> nodos = new ArrayList<NodoF2B>();
		for (CatalogosPeticiones catalogoPeticion : catalogosPeticiones) {
			NodoF2B nodo = new NodoF2B();
			nodo.setLeaf(true);
			nodo.setId(catalogoPeticion.getCve());
			nodo.setText(catalogoPeticion.getDescripcion());
			nodo.setChecked(false);
			nodo.setChildren(null);
			nodo.setExpanded(false);
			nodos.add(nodo);
		}
		
		return nodos;
	}
	
}