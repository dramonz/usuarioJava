package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioSessionService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author José Luis Landero
 *
 */
@Controller
@RequestMapping(value = "/usuario")
public class CredencialUsuarioControlador {

	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UsuarioSessionService usuarioSessionService;
	
	@RequestMapping(value = "/editar-credenciales", method = RequestMethod.GET)
	public String showEditarCredencialesView() {
		return "usuario/editar-credenciales";
	}
	
	@RequestMapping(value = "/actualizar-credenciales", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateCredenciales(
			@RequestParam String currentPassword, 
			@RequestParam String newPassword) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);
		
		try {
			this.usuarioSessionService.updateCredenciales(currentPassword, newPassword);
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", e.getMessage());
			this.log.error("Error al actualizar las credenciales del usuario", e);
		}
		
		return respuesta;
	}
	
}
