package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Unidades;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.UnidadHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UnidadServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/unidad")
public class UnidadControlador {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UnidadServicio unidadServicio;

	@RequestMapping(value = "/listarUnidad", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listUnidad(@RequestParam(value = "ejercicio",required=false)Short ejercicio) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", UnidadHelper
					.convertListModelToListF2B(this.unidadServicio
							.listAllByPermisoUnidad(Unidades.class,ejercicio)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar las areas");
			this.log.error("Ocurrió un error al listar las areas: ", e);
		}

		return respuesta;
	}

}
