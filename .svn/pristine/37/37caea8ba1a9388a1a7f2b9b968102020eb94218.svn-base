package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IPermisoUnidadUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.PermisosUnidadesUsuario;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

@Repository
public class PermisoUnidadUsuarioDAO extends
		BaseHibernateDAO<PermisosUnidadesUsuario> implements
		IPermisoUnidadUsuarioDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PermisosUnidadesUsuario> findByUsuario(Long cveUsuario) {
		List<PermisosUnidadesUsuario> permisosUnidades;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(
					PermisosUnidadesUsuario.class).add(
					Restrictions.eq("id.cveUsuario", cveUsuario));

			permisosUnidades = this.getHibernateTemplate().findByCriteria(
					criteria);

			return permisosUnidades;
		} catch (Exception e) {
			log.error("Error Login ", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PermisosUnidadesUsuario findByUsuarioUnidad(Long cveUsuario, Long idUnidad) {
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(PermisosUnidadesUsuario.class)
					.add(Restrictions.eq("id.cveUsuario", cveUsuario))
					.add(Restrictions.eq("id.idUnidad", idUnidad));

			PermisosUnidadesUsuario permisosUnidades = DataAccessUtils
					.uniqueResult(this.getHibernateTemplate().findByCriteria(
							criteria));

			return permisosUnidades;
		} catch (Exception e) {
			log.error("Error Login ", e);
			return null;
		}
	}

}
