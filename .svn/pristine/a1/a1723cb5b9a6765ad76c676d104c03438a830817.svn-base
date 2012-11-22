package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.ModuloServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/modulo")
public class ModuloControlador {
	
protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ModuloServicio moduloServicio;

	@RequestMapping(value = "/listarModulos", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listRol() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", this.moduloServicio
							.findAllModules());
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los módulos");
			this.log.error("Ocurrió un error al listar los módulos: ", e);
		}

		return respuesta;
	}

}
