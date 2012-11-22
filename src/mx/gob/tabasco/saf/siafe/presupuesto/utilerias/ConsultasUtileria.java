package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;


import javax.annotation.Resource;



import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.ConsultasGestor;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.ConsultasSQL;

import org.springframework.stereotype.Repository;

@Repository
public class ConsultasUtileria {
	
	
	@Resource
	public ConsultasGestor gestor;
	
	
	public ConsultasSQL sql = new ConsultasSQL();
	
}
