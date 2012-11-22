package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Unidades;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.UnidadF2B;

public class UnidadHelper {

	public static List<UnidadF2B> convertListModelToListF2B(
			List<Unidades> unidades) {
		List<UnidadF2B> unidadesF2B = new ArrayList<UnidadF2B>();
		for (Unidades unidad : unidades) {
			UnidadF2B unidadF2B = new UnidadF2B();
			unidadF2B.setCodigo(unidad.getCodigoUnidad());
			unidadF2B.setCve_unidad(unidad.getCve());
			unidadF2B.setId(unidad.getId());
			unidadF2B.setNombre(unidad.getDependencias().getCodigoDependencia()+unidad.getCodigoUnidad() + " - " + unidad.getNombreUnidad());
			unidadesF2B.add(unidadF2B);
		}
		return unidadesF2B;
	}
}
