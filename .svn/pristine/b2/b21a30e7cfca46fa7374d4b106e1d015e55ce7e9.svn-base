package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Dependencias;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.DependenciaHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.DependenciaServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/dependencia")
public class DependenciaControlador {
	
	
	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private DependenciaServicio dependenciaServicio;

	@RequestMapping(value = "/listarDependencia", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listDependencia() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", DependenciaHelper
					.convertListModelToListF2B(this.dependenciaServicio
							.listAll(Dependencias.class)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar las dependencias");
			this.log.error("Ocurrió un error al listar las dependencias: ", e);
		}

		return respuesta;
	}
}
