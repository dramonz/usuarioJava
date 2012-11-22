package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IPermisoProyectoUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosProyectosUsuario;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PermisoProyectoUsuarioDAO extends
		BaseHibernateDAO<PermisosProyectosUsuario> implements
		IPermisoProyectoUsuarioDAO {
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<PermisosProyectosUsuario> findByUsuario(Long cveUsuario) {
		List<PermisosProyectosUsuario> permisosProyectos;
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(PermisosProyectosUsuario.class).add(
							Restrictions.eq("id.cveUsuario", cveUsuario));

			permisosProyectos =  this.getHibernateTemplate()
			.findByCriteria(criteria);
		
			return permisosProyectos;
		} catch (Exception e) {
			log.error("Error Login ", e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PermisosProyectosUsuario findByUsuarioProyecto(Long cveUsuario, Long idProyecto) {
		DetachedCriteria criteria = DetachedCriteria
		.forClass(PermisosProyectosUsuario.class)
		.add(Restrictions.eq("id.cveUsuario", cveUsuario))
		.add(Restrictions.eq("id.idProyecto", idProyecto));

PermisosProyectosUsuario permisosProyecto = DataAccessUtils
		.uniqueResult(this.getHibernateTemplate().findByCriteria(
				criteria));

return permisosProyecto;
}
}