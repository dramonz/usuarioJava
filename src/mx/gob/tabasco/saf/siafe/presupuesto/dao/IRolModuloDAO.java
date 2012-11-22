package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;

public interface IRolModuloDAO extends IBaseHibernateDAO<RolesModulos>{
	/**
	 * getByRol
	 * @param rol
	 * @return List<RolesModulos>
	 */
	public List<RolesModulos> getByRol(String rol);
	
	public List<RolesModulos> findeByNombreRol(String nombreRol);
	
	public List<Roles> getByRolModulo(String rol);
	public List<RolesModulos> getByRolModuloRoles(Long cve);
	
}
