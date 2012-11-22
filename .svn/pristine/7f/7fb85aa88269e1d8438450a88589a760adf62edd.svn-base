package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Puestos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.PuestoF2B;

public class PuestoHelper {
	
	public static List<PuestoF2B> convertListModelToListF2B(List<Puestos> puestos) {
		List<PuestoF2B> puestosF2B = new ArrayList<PuestoF2B>();
		for (Puestos puesto : puestos) {
			PuestoF2B puestoF2B = new PuestoF2B(puesto.getCve(), puesto.getNombrePuesto());
			puestosF2B.add(puestoF2B);
		}
		return puestosF2B;
	}
}
