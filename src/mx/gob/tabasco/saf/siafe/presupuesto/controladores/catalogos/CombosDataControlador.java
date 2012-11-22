package mx.gob.tabasco.saf.siafe.presupuesto.controladores.catalogos;

import java.util.HashMap;
import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.EjercicioServicio;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioServicio;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioSessionService;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.ConsultasUtileria;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultaSQLNativo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/combos/data/")
public class CombosDataControlador {

	@Resource
	ConsultasUtileria consultas;
	
	@Resource
	UsuarioSessionService usuarioSession;
	
	@Resource
	private UsuarioServicio usuarioServicio;

	@Resource
	private EjercicioServicio ejercicioServicio;
	
	@RequestMapping(value = "ejercicios")
	public @ResponseBody
	HashMap<String, Object> listejercicio() {		
		HashMap<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("data", this.ejercicioServicio.listEjercicioActualSiguietne());
		respuesta.put("success",true);
		return respuesta;

	}
	
	@RequestMapping(value = "listUsuarios")
	public @ResponseBody
	HashMap<String, Object> listUsuarios(
			@RequestParam(value = "ejercicio", required = false) Long ejercicio) {
		
		HashMap<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("data", this.usuarioServicio.listAllByPermisoUnidad());
		respuesta.put("success",true);
		return respuesta;

	}
	
//	@RequestMapping(value = "dependencias")
//	public @ResponseBody
//	HashMap<String, Object> lista_dependencias(
//			@RequestParam(value = "ejercicio", required = false) Long ejercicio) {
//
//		ejercicio = validaEjercicio(ejercicio);
//		String sql_nativo = String.format(consultas.sql.catalogos.combosdata.dependencias, ejercicio);
//		
//		ConsultaSQLNativo query = new ConsultaSQLNativo();
//
//		query.setSqlNativo( sql_nativo ).setColumnas("id, codigo, nombre, id_sector");
//
//		return this.makeResponceQuery(query);
//
//	}

	@RequestMapping(value = "unidades")
	public @ResponseBody
	HashMap<String, Object> lista_unidades(
			@RequestParam(value = "ejercicio", required = false) Long ejercicio) {
		
		ejercicio = validaEjercicio(ejercicio);
		
		String sql_nativo;
		if (usuarioSession.getRol().compareToIgnoreCase("ROLE_ADMIN") == 0) {			
			sql_nativo = String.format(consultas.sql.catalogos.combosdata.unidades, ejercicio);
		} else {
			sql_nativo = "SELECT " +
								"	UNIDADES.CVE_UNIDAD, " +
								"	UNIDADES.ID, " +
								"	UNIDADES.CODIGO_UNIDAD AS CODIGO, " +
								"	UNIDADES.CODIGO_UNIDAD || ' - ' || UNIDADES.NOMBRE_UNIDAD AS NOMBRE, " +
								"	DEPENDENCIAS.ID AS ID_DEPENDENCIA, " +
								"	UNIDADES_GRUPOS.CODIGO_GRUPO " +
								"FROM  " +
								"	UNIDADES_GRUPOS " +
								"	LEFT JOIN UNIDADES ON (UNIDADES.CODIGO_UNIDAD = UNIDADES_GRUPOS.CODIGO_UNIDAD) " +
								"	LEFT JOIN DEPENDENCIAS ON (DEPENDENCIAS.CVE_DEPENDENCIA = UNIDADES.CVE_DEPENDENCIA) " +
								"WHERE " +
								"	CODIGO_GRUPO = '%s' " +
								"	AND UNIDADES.EJERCICIO = %d " +
								"	AND UNIDADES.ACTIVO = 1 " +
								"	ORDER BY NOMBRE ASC";
			sql_nativo = String.format(sql_nativo, usuarioSession.getGrupoUnidades(), ejercicio);
		}
		
		ConsultaSQLNativo query = new ConsultaSQLNativo();
		query.setSqlNativo( sql_nativo )
				.setColumnas(
						"cve_unidad, id, codigo, nombre, id_dependencia, codigo_grupo");
		return this.makeResponceQuery(query);

	}


	private @ResponseBody
	HashMap<String, Object> makeResponceQuery(ConsultaSQLNativo query) {
		HashMap<String, Object> responce = new HashMap<String, Object>();

		responce.put("data", consultas.gestor.consultar(query)
				.getHasMapResult());

		return responce;
	}
	
	private Long validaEjercicio(Long ejercicio){
		if (ejercicio != null){
			
			if (ejercicio > 0){
				return ejercicio;
			}
		}
		
		return 2012L;
		
	}

}
