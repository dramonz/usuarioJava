package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.HistorialSesionesServicio;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;


public class SessionListenerControlador implements LogoutHandler{

	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	HistorialSesionesServicio hServicio;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) {
		try {			 		        
			log.info("Update el fin Historial de session ");
			hServicio.updateSesion();	
			
		} catch (Exception e) {
			log.error("Error al hacer update el Historial de session: ", e);
		}
		
	}

}
