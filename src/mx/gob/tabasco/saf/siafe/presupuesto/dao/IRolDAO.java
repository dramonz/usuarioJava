package mx.gob.tabasco.saf.siafe.presupuesto.dao;
// default package

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;

/**
 * Interface for RolesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRolDAO extends IBaseHibernateDAO<Roles> {
	
	public Set<Roles> convertListToSet(List<String> roles);
	/**
	 * getByRol
	 * @param rol
	 * @return
	 */
	public Roles getByRol(String rol);
	
	/**
	 * 
	 * @param rol
	 * @return
	 * @throws DataAccessException
	 */
	public List<Roles> findByNombreRol(String rol) throws DataAccessException;
	
}