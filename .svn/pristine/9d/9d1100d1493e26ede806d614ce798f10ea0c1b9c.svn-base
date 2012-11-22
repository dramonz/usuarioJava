package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Modulos;

public interface IModuloDAO extends IBaseHibernateDAO<Modulos>{

	/**
	 * 
	 * @param cveUsuario
	 * @return
	 * @throws DataAccessException
	 */
	public List<Modulos> findByUsuario(Long cveUsuario) throws DataAccessException;
	
	/**
	 * 
	 * @param rol
	 * @return
	 * @throws DataAccessException
	 */
	public List<Modulos> findByRol(String rol) throws DataAccessException;
	
}
