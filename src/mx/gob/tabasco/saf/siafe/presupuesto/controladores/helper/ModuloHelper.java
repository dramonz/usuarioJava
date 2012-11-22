package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Modulos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.ModuloF2B;

public class ModuloHelper {
	protected static final Logger log = Logger.getLogger(Modulos.class);
	public static List<ModuloF2B> convertSetModelToListF2B(Set<Modulos> modulos) {
		List<ModuloF2B> modulosF2B = new ArrayList<ModuloF2B>();
		for (Modulos modulo : modulos) {
			log.debug("Modulo cve: "+modulo.getCve());
			ModuloF2B rolF2B = new ModuloF2B(modulo.getCve(),
					modulo.getNombre(), modulo.getDescripcion());
			modulosF2B.add(rolF2B);
		}
		return modulosF2B;
	}
}
