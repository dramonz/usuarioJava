package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.RolHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.RolServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/rol")
public class RolesControlador {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private RolServicio rolServicio;

	@RequestMapping(value = "/listarRol", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listRol() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", RolHelper
					.convertListModelToListF2B(this.rolServicio
							.findAll(Roles.class)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los roles");
			this.log.error("Ocurrió un error al listar los roles: ", e);
		}

		return respuesta;
	}
	
	@RequestMapping(value = "/listarRolModulo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listRolModulo() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", RolHelper
					.convertListModelToListF2B(this.rolServicio
							.findAllRolesModulos(Roles.class)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los roles");
			this.log.error("Ocurrió un error al listar los roles: ", e);
		}

		return respuesta;
	}
	
}
