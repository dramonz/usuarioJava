package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.googlecode.genericdao.search.Search;

@Repository
public class RolesModulosDAO extends BaseHibernateDAO<RolesModulos> implements IRolesModulosDAO{
	/*
	 * obtenerListaRoles
	 * @param cveModulo
	 * Busca los Roles con permisos a el modulo especificado.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RolesModulos> obtenerListaRoles(Integer cveModulo) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(RolesModulos.class)
				.setFetchMode("roles", FetchMode.JOIN)
				.add(Restrictions.eq("modulos.cve", cveModulo.longValue()));
			
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
}