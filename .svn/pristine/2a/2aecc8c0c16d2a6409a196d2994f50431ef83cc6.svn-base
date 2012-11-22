package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Dependencias;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.DependenciaF2B;

public class DependenciaHelper {

	public static List<DependenciaF2B> convertListModelToListF2B(
			List<Dependencias> dependencias) {
		List<DependenciaF2B> dependenciasF2B = new ArrayList<DependenciaF2B>();
		for (Dependencias dependencia : dependencias) {
			DependenciaF2B dependenciaF2B = new DependenciaF2B();
			dependenciaF2B.setCve(dependencia.getCve());
			dependenciaF2B.setCveSector(dependencia.getSectores().getCve());
			dependenciaF2B.setId(dependencia.getId());
			dependenciaF2B.setNombreDependencia(dependencia.getCodigoDependencia() + " - "
					+ dependencia.getNombreDependencia());
			dependenciasF2B.add(dependenciaF2B);
		}
		return dependenciasF2B;
	}
}
