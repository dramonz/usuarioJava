package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.RolModuloF2B;

public class RolModuloHelper {

	public static List<RolModuloF2B> convertListEntityToF2B(List<RolesModulos> rolesModulos){
		List<RolModuloF2B> rolesmodulosf2b = new ArrayList<RolModuloF2B>();
		for(RolesModulos rolmodulo : rolesModulos){
			RolModuloF2B rolmodulof2b = new RolModuloF2B();
			rolmodulof2b.setCve(rolmodulo.getCve());
			rolmodulof2b.setCveModulo(rolmodulo.getModulos().getCve());
			rolmodulof2b.setRol(rolmodulo.getRoles().getRol());
			rolesmodulosf2b.add(rolmodulof2b);
		}
		return rolesmodulosf2b;
	}
	
}
