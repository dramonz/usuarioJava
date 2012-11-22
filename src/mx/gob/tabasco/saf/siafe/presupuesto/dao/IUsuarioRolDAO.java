package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.UsuariosRoles;

public interface IUsuarioRolDAO extends IBaseHibernateDAO<UsuariosRoles>{
	/**
	 * Trae la lista de roles asociados al usuario
	 * @param cveUsuario
	 * @return List<UsuariosRoles>
	 */
	public List<UsuariosRoles> listUsuariosRoles(Long cveUsuario);
	/**
	 * Trae la relacion de UsuariosRoles
	 * @param cveUsuario
	 * @param rol
	 * @return
	 */
	public UsuariosRoles getByCveAndRol(Long cveUsuario,String rol);
}
