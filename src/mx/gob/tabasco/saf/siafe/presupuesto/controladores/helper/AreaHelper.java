package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Areas;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.AreaF2B;

public class AreaHelper {

	public static List<AreaF2B> convertListModelToListF2B(List<Areas> areas) {
		List<AreaF2B> areasF2B = new ArrayList<AreaF2B>();
		for (Areas area : areas) {
			AreaF2B areaF2B = new AreaF2B(area.getCve(), area.getNombreArea());
			areasF2B.add(areaF2B);
		}
		return areasF2B;
	}
}
