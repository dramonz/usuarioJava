package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

// default package

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IRolDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for Roles
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see .Roles
 * @author MyEclipse Persistence Tools
 */
@Repository
public class RolDAO extends BaseHibernateDAO<Roles> implements IRolDAO {

	@Override
	public Set<Roles> convertListToSet(List<String> roles) {
		Set<Roles> rolesSet = new HashSet<Roles>();
		for (String rol : roles) {
			Roles r = new Roles();
			r.setRol(rol);
			rolesSet.add(r);
		}
		if (rolesSet.size() > 0) {
			return rolesSet;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Roles getByRol(String rol) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Roles.class)
			.add(Restrictions.eq("rol", rol));			
		return DataAccessUtils.uniqueResult(this.getHibernateTemplate().findByCriteria(criteria));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> findByNombreRol(String rol) throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Roles.class)
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.ne("rol", "IS_AUTHENTICATED_FULLY"))
				.add(Restrictions.ilike("rol", rol + "%"))
				.add(Restrictions.isNotEmpty("rolesModuloses"));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	

}