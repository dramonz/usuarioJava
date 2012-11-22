package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Areas;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.AreaHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.AreaServicio;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/area")
public class AreaControlador {

	protected final Logger log = Logger.getLogger(this.getClass());

	@Resource
	private AreaServicio areaServicio;

	@RequestMapping(value = "/listarArea", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listArea() {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", true);

		try {
			respuesta.put("data", AreaHelper
					.convertListModelToListF2B(this.areaServicio
							.findAll(Areas.class)));
		} catch (Exception e) {
			respuesta.put("success", false);
			respuesta.put("msg", "Ocurrió un error al listar las areas");
			this.log.error("Ocurrió un error al listar las areas: ", e);
		}

		return respuesta;
	}

}
