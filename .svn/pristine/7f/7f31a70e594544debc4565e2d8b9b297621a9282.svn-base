package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Puestos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.PuestoHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.PuestoServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/puesto")
public class PuestoControlador {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private PuestoServicio puestoServicio;

	@RequestMapping(value = "/listarPuesto", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listPuesto() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", PuestoHelper
					.convertListModelToListF2B(this.puestoServicio
							.findAll(Puestos.class)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar los puestos");
			this.log.error("Ocurrió un error al listar los puestos: ", e);
		}

		return respuesta;
	}
}
