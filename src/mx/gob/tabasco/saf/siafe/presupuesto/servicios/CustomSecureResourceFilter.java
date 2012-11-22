package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IMapaPeticionDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

/**
 * CustomSecureResourceFilter filter. @author Bogard Alexis Coronel
 */
public class CustomSecureResourceFilter implements
		FilterInvocationSecurityMetadataSource {

	protected final Logger log = Logger.getLogger(this.getClass());

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();

	static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Resource
	private IMapaPeticionDAO dao;

	// public CustomSecureResourceFilter() throws Exception{
	// loadSourceDefine();
	// }

	@Autowired
	protected void init() throws Exception {
		loadSourceDefine();
	}

	private void loadSourceDefine() {
		try {
			List<MapasPeticiones> mapaPeticion = dao
					.findAll(MapasPeticiones.class);
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
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
				resourceMap.put(url, atts);
			}
		} catch (Exception e) {
			log.error("Error al cargar permisos", e);
		}

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object filter)
			throws IllegalArgumentException {
		FilterInvocation filterInvocation = (FilterInvocation) filter;
		String url = filterInvocation.getRequestUrl();
		String newUrl = "";
		String resURL;
		String finalURL = "";
		int result;
		// get the roles for requested page from data base
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			resURL = ite.next();
			result = resURL.lastIndexOf("*");
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				finalURL = resURL;
				break;
			} else if (result != -1 && url.length() >= result) {
				newUrl = resURL.substring(0, result - 2);
				if(resURL.equals("/**")){
					finalURL = resURL;
				}else if (urlMatcher.pathMatchesUrl(url.substring(0, result - 2),
						newUrl)) {
					finalURL = resURL;
					break;
				}
			}

		}
		return resourceMap.get(finalURL);
	
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
