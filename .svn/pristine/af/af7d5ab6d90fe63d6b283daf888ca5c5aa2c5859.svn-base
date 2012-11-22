package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/asignarRolUsuario")
public class AsignarRolUsuarioControlador {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView agregarUsuario() {
		return new ModelAndView("usuario/asignarRolUsuario");
	}
	
	@RequestMapping(value = "/listarUsuarioRoles", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listarUsuarioRoles(@RequestParam(value = "cveUsuario",required=false)Long cveUsuario) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", this.usuarioServicio.listUsuariosRoles(cveUsuario));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listarUsuarioRoles");
			this.log.error("Ocurrió un error allistarUsuarioRoles: ", e);
		}

		return respuesta;
	}
	
	@RequestMapping(value = "/asignarRol", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> asignarRol(
			@RequestParam(value = "cveUsuario",required=false)Long cveUsuario,
			@RequestParam(value = "rol",required = false)String rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			this.usuarioServicio.asignarRol(cveUsuario, rol);
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al asignar el rol");
			this.log.error("Ocurrió un error al asignar el rol: ", e);
		}

		return respuesta;
	}
	
	@RequestMapping(value = "/eliminarRol", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> eliminarRol(
			@RequestParam(value = "cveUsuario",required=false)Long cveUsuario,
			@RequestParam(value = "rol",required = false)String rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			this.usuarioServicio.eliminarRol(cveUsuario, rol);
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al eliminar el rol");
			this.log.error("Ocurrió un error al eliminar el rol: ", e);
		}

		return respuesta;
	}
}
