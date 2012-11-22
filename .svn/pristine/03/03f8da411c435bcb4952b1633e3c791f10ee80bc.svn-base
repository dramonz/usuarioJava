package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.EmpleadoServicio;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.TextoUtilerias;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/empleado")
public class EmpleadoControlador {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EmpleadoServicio empleadoServicio;
	
	@RequestMapping(value = "/listarEmpleado", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listEmpleado(
			@RequestParam(value = "empleado",required = false)String empleado,
			@RequestParam(value = "cveJefe",required = false)Long cveJefe
		) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", this.empleadoServicio.getEmpleados(TextoUtilerias.convertStringUT(empleado),cveJefe));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los empleados");
			this.log.error("Ocurrió un error al listar los empleados: ", e);
		}

		return respuesta;
	}
}
