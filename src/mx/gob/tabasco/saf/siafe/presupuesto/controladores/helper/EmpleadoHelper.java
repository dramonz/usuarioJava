package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Empleados;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.EmpleadoF2B;

public class EmpleadoHelper {
	
	public static List<EmpleadoF2B> convertListModelToListF2B(List<Empleados> empleados) {
		List<EmpleadoF2B> empleadosF2B = new ArrayList<EmpleadoF2B>();
		for (Empleados empleado : empleados) {
			EmpleadoF2B empleadoF2B = new EmpleadoF2B();
			empleadoF2B.setCve(empleado.getCve());
			empleadoF2B.setNombre(empleado.getNombreCompleto());
			empleadoF2B.setArea(empleado.getAreas().getNombreArea());
			empleadoF2B.setPuesto(empleado.getPuestos().getNombrePuesto());
			empleadoF2B.setCorreoElectronico(empleado.getCorreoElectronico());
			empleadoF2B.setCveUnidad(Integer.valueOf(empleado.getUnidades().getCve().toString()));
			empleadoF2B.setIdUnidad(Integer.valueOf(empleado.getUnidades().getId().toString()));
			empleadoF2B.setUnidad(empleado.getUnidades().getNombreUnidad());
			empleadoF2B.setCveArea(Integer.valueOf(empleado.getAreas().getCve().toString()));
			empleadoF2B.setCvePuesto(Integer.valueOf(empleado.getPuestos().getCve().toString()));
			empleadoF2B.setActivo(empleado.getActivo());
			empleadoF2B.setCveJefe(empleado.getCveEmpleadoJefe());
			empleadosF2B.add(empleadoF2B);
		}
		return empleadosF2B;
	}
}
