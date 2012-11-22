package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IBaseHibernateDAO;


public interface IRolesModulosDAO extends IBaseHibernateDAO<RolesModulos> {
	
	public List<RolesModulos> obtenerListaRoles(Integer cveModulo);
}