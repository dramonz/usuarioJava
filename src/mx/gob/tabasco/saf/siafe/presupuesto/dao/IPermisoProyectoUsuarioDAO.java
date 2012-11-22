package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosProyectosUsuario;

public interface IPermisoProyectoUsuarioDAO extends
		IBaseHibernateDAO<PermisosProyectosUsuario> {
	/***
	 * obtiene los perimisos de los proyectos que el usuario no puede ver
	 * @param cveUsuario
	 * @return
	 */
	public List<PermisosProyectosUsuario> findByUsuario(Long cveUsuario);
	public PermisosProyectosUsuario findByUsuarioProyecto(Long cveUsuario, Long idProyecto);

}
