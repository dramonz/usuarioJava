package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;

import java.util.HashMap;

import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultaSQLNativo;

public class ExtjsUtilerias {

	
	public ExtjsUtilerias(){
		
	}
	

//	public HashMap<String, Object> hashMapToGrid( Long cve, String query, String columnas) {
//		
//		String sql_nativo = String.format(query, cve);
//		
//		ConsultaSQLNativo consultaSqlNativo = new ConsultaSQLNativo();
//		
//		consultaSqlNativo.setSqlNativo(sql_nativo)
//			.setColumnas(columnas);
//		
//		
//		//consultas.gestor.consultar(consultaSqlNativo);
//		
//		HashMap<String, Object> respuesta = new HashMap<String, Object>();
//		respuesta.put("data", consultaSqlNativo.getHasMapResult());
//		respuesta.put("success", true);
//		
//
//		return respuesta;
//
//	}	
	
//
//	public HashMap<String, Object> hashMapToGridLineasAccion( Long cveProyecto) {
//		
//		String sql_nativo = String.format("select cve_pled, desc_pled, pagina_pled, parrafo_pled, codigo_pled, pled.id  from lineas_acciones left join pled using (cve_pled) where cve_proyecto = %d  AND lineas_acciones.activo = 1", cveProyecto);
//		
//		ConsultaSQLNativo consultaSqlNativo = new ConsultaSQLNativo();
//		
//		consultaSqlNativo.setSqlNativo(sql_nativo)
//			.setColumnas("cvePled, descPled, paginaPled, parrafoPled, codigoPled, id");
//		
//		
//		HashMap<String, Object> respuestaLineaAccion = new HashMap<String, Object>();
//		respuestaLineaAccion.put("data", consultaSqlNativo.getHasMapResult());
//		respuestaLineaAccion.put("success", true);
//		
//
//		return respuestaLineaAccion;
//	}
	
	
//	public HashMap<String, Object> hashMapToGridBeneficiarios( Long cveProyecto) {
//		
//		String sql_nativo = String.format("select cve_tipo_beneficiario, cve_beneficiario, num_beneficiario, desc_beneficiario  from beneficiarios left join tipos_beneficiarios using (cve_tipo_beneficiario)  where cve_proyecto = %d AND beneficiarios.activo = 1", cveProyecto);
//		
//		ConsultaSQLNativo consultaSqlNativo = new ConsultaSQLNativo();
//		
//		consultaSqlNativo.setSqlNativo(sql_nativo)
//			.setColumnas("cveTBeneficiario, cveBeneficiario, cantBeneficiario, descBeneficiario");
//		
//		
//		//consultas.gestor.consultar(consultaSqlNativo);
//		
//		HashMap<String, Object> respuestaBeneficiarios = new HashMap<String, Object>();
//		respuestaBeneficiarios.put("data", consultaSqlNativo.getHasMapResult());
//		respuestaBeneficiarios.put("success", true);
//
//		return respuestaBeneficiarios;
//
//	}	
	
	
	public HashMap<String, Object> hashMapToGridArchivos( Long cveProyecto) {

		String sql_nativo = String.format("select archivos.id, cve_archivo, cve_proyecto_archivo, nombre_archivo, path_archivo from proyectos_archivos left join archivos using (cve_archivo) where cve_proyecto = %d AND proyectos_archivos.activo = 1", cveProyecto);
		
		ConsultaSQLNativo consultaSqlNativo = new ConsultaSQLNativo();
		
		consultaSqlNativo.setSqlNativo(sql_nativo)
			.setColumnas("id, cveArchivo, cveProyectoArchivo, nombreArchivo, pathArchivo");
		
		
		//consultas.gestor.consultar(consultaSqlNativo);
				
		HashMap<String, Object> respuestaArchivo = new HashMap<String, Object>();
		respuestaArchivo.put("data", consultaSqlNativo.getHasMapResult());
		respuestaArchivo.put("success", true);
		
		return respuestaArchivo;
		
	}
	
	
	public HashMap<String, Object> hashMapToGridPrioridades(Long cveDependencia) {

		String sql_nativo = String.format("select proyectos_calificadores.prioridad_num ,dependencias.nombre_dependencia, proyectos_programaciones.id as id_programacion, proyectos_calificadores.id as id_calificador, proyectos.nombre_proyecto, proyectos_programaciones.inversion_programada, proyectos.id as id_proyecto, proyectos.num_proyecto, dependencias.id as id_dependencia, proyectos_calificadores.prioridad_num from proyectos left join proyectos_programaciones using (cve_proyecto) left join proyectos_calificadores using (cve_proyecto) left join unidades using (cve_unidad) left join dependencias using (cve_dependencia) where cve_dependencia= %d and proyectos.activo=1 order by proyectos_calificadores.prioridad_num",cveDependencia);
		
		ConsultaSQLNativo consultaSqlNativo = new ConsultaSQLNativo();
		
		consultaSqlNativo.setSqlNativo(sql_nativo)
			.setColumnas("filaNum, nombreDependencia, idProgramacion, idCalificador, nombreProyecto, inversionProgramada, idProyecto ,numProyecto, idDependencia, prioridadNum");
		
		//consultas.gestor.consultar(consultaSqlNativo);
		
		HashMap<String, Object> respuestaPrioridades = new HashMap<String, Object>();
		respuestaPrioridades.put("data", consultaSqlNativo.getHasMapResult());
		respuestaPrioridades.put("success", true);
		
		return respuestaPrioridades;
	}
	
	
	

	
}
