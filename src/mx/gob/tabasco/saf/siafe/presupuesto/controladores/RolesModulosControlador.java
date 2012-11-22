package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.RolModuloServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/rolModulo")
public class RolesModulosControlador {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private RolModuloServicio rolModuloServicio;
	
	@RequestMapping(value = "/listByRol", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listByRol(@RequestParam(value = "rol",required=false)String rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);
		try {
			respuesta.put("data", this.rolModuloServicio.listByRol(rol));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los roles");
			log.error("Ocurrió un error al listar los roles: ", e);
		}

		return respuesta;
	}
	
}
