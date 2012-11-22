package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CatalogosPeticiones;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.NodoF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.ICatalogoPeticionDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.ConsultasUtileria;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultaSQLNativo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TreeServicio {

	@Resource
	ConsultasUtileria consultas;
	
	@Resource
	private ICatalogoPeticionDAO catalogoPeticionDao;

	@Transactional
	public List<Map<String, Object>> optenerTreePermisos(){
		List<Map<String, Object>> respuesta = new ArrayList<Map<String,Object>>();
		
		List<CatalogosPeticiones> urlsPadres = this.catalogoPeticionDao.getUrlsPadres();
		for (CatalogosPeticiones padre : urlsPadres) {
			Map<String, Object> nodo = new HashMap<String, Object>();
			nodo.put("text", padre.getModulos().getNombre() + ": " + padre.getDescripcion());
			nodo.put("id", padre.getCve());
			nodo.put("checked", false);
			nodo.put("expanded", true);
			nodo.put("leaf", false);
			List<Map<String, Object>> hijos = new ArrayList<Map<String,Object>>();
			for (CatalogosPeticiones hijo : padre.getCatalogosPeticioneses()) {
				Map<String, Object> nodoHijo = new HashMap<String, Object>();
				nodoHijo.put("text", hijo.getDescripcion());
				nodoHijo.put("id", hijo.getCve());
				nodoHijo.put("leaf", true);
				nodoHijo.put("checked", false);
				hijos.add(nodoHijo);
			}
			nodo.put("children", hijos);
			respuesta.add(nodo);
		}
		
		return respuesta;
	}
	
	@Transactional(readOnly = true)
	public List<NodoF2B> getNodosModulos() {
		List<NodoF2B> nodos = new ArrayList<NodoF2B>();
		List<CatalogosPeticiones> urls = this.catalogoPeticionDao.getUrlsPadres();
		
		for (CatalogosPeticiones urlPadre : urls) {
			NodoF2B nodoPadre = new NodoF2B();
			nodoPadre.setText(urlPadre.getModulos().getNombre() + ": " + urlPadre.getDescripcion());
			nodoPadre.setId(urlPadre.getCve());
			if(urlPadre.getCatalogosPeticioneses().size() > 0){
				nodoPadre.setExpanded(true);
				nodoPadre.setChildren(this.getHijosNodoModulo(urlPadre));
			}else
			if(urlPadre.getCatalogosPeticioneses().size() == 0){
				nodoPadre.setLeaf(true);
				nodoPadre.setChecked(false);
			}
			
			nodos.add(nodoPadre);
		}
		
		return nodos;
	}
	
	private List<NodoF2B> getHijosNodoModulo(CatalogosPeticiones padre) {
		if (padre.getCatalogosPeticioneses().size() == 0) {
			return null;
		}
		
		List<NodoF2B> nodos =  new ArrayList<NodoF2B>();
		for (CatalogosPeticiones url : padre.getCatalogosPeticioneses()) {
			NodoF2B nodoHijo = new NodoF2B();
			nodoHijo.setText(url.getDescripcion());
			nodoHijo.setId(url.getCve());
			if(url.getCatalogosPeticioneses().size() > 0){
				nodoHijo.setExpanded(true);
				nodoHijo.setChildren(this.getHijosNodoModulo(url));
			}else
			if(url.getCatalogosPeticioneses().size() == 0){
				nodoHijo.setLeaf(true);
				nodoHijo.setChecked(false);
			}
			
			nodos.add(nodoHijo);
		}
		return nodos;
	}
	
	public List<HashMap<String, Object>> optieneTreeByCveUsuario(Long cveUsuario){

		List<HashMap<String, Object>> responseTree = new ArrayList<HashMap<String, Object>>();
		
		ConsultaSQLNativo query = new ConsultaSQLNativo();
		query.setSqlNativo( consultas.sql.presupuesto.usuarios.getSqlConsultaTreeByCveUsuario(cveUsuario))
		.setColumnas("cve,url,cvePadre,modulo,descripcion");
		
		List<HashMap<String, Object>> catalogoPeticiones = consultas.gestor.consultar(query).getHasMapResult();
		catalogoPeticiones.size();

		for (HashMap<String, Object> hash : catalogoPeticiones) {
			HashMap<String, Object> responseLinea = new HashMap<String, Object>();
			responseLinea.put("text", hash.get("modulo"));
			responseLinea.put("id",hash.get("cve"));		
			
			query.setSqlNativo(  consultas.sql.presupuesto.usuarios.getSqlConsultaTreeByCveUsuario(cveUsuario)+" and cve_padre!=1")
			.setColumnas("cve,url,cvePadre,modulo,descripcion");
			List<HashMap<String, Object>> peticiones = consultas.gestor.consultar(query).getHasMapResult();
			
			if(peticiones.size()==0){
				responseLinea.put("checked", false);
				responseLinea.put("leaf", true);
			}else{
				
				List<HashMap<String, Object>> nodo = new ArrayList<HashMap<String, Object>>();
				for (HashMap<String, Object> hashj : peticiones) {
					HashMap<String, Object> linea = new HashMap<String, Object>();
					linea.put("text",hashj.get("modulo"));
					linea.put("id", hashj.get("cve"));
					linea.put("hrefTarget","content-frame");
					linea.put("href",( "Namespace.namespace" + hashj.get("url"))); //preguntar
					linea.put("checked", false);
					linea.put("leaf", true);
					nodo.add(linea);
				}
				responseLinea.put("children",nodo);
				responseLinea.put("expandable", true);
				responseLinea.put("expanded",true);
				responseLinea.put("hrefTarget","content-frame");
				responseLinea.put("href",( "Namespace.namespace" + hash.get("url")));
				responseLinea.put("cls", "proyectos-tree-icon");
				responseLinea.put("leaf", false);
				responseTree.add(responseLinea);
			}
		}
		
		return responseTree;
		
	}
	
}
