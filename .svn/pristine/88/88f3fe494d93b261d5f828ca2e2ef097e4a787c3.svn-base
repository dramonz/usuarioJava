package mx.gob.tabasco.saf.siafe.presupuesto.dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;

public interface IUsuarioDAO extends IBaseHibernateDAO<Usuarios>{
	
	/**
	 * obtiene una lista de usuarios dependiendo los parametros que se envien
	 * @param ids
	 * @param admin
	 * @param empleado
	 * @param usuario
	 * @return
	 */
	public List<Usuarios> listUsuariosByEmpleadoAndUsuario(List<Long> ids,boolean admin,String empleado,String usuario,Long cveEmpleado);
	public Usuarios getUsuarioByCredentials(String nombre, String password);
	public Usuarios getUserByName(String username);
	/**
	 * lista los usuarios que puede ver por las unidades que el usuario en sesion tiene permiso
	 * @param idUnidades
	 * @return
	 */
	public List<Usuarios> listByIdUnidadesPermitidas(List<Long> idUnidades,boolean admin);
	
	/**
	 * 
	 * @param nombreUsuario
	 * @return
	 * @throws DataAccessException
	 */
	public List<Usuarios> findByNombreUsuario(String nombreUsuario) throws DataAccessException;
	
}