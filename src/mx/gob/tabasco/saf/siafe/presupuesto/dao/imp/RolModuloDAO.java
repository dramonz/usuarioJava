package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IRolModuloDAO;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RolModuloDAO extends BaseHibernateDAO<RolesModulos> implements IRolModuloDAO{

	
	@SuppressWarnings("unchecked")
	public List<RolesModulos> getByRol(String rol){
		DetachedCriteria criteria = DetachedCriteria.forClass(RolesModulos.class)
		.add(Restrictions.eq("roles.rol", rol))
		.setFetchMode("modulos", FetchMode.JOIN);
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolesModulos> findeByNombreRol(String nombreRol) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RolesModulos.class)
				.add(Restrictions.ilike("roles.rol", nombreRol + "%"));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	 public List<Roles> getByRolModulo(String cve) {
	  // TODO Auto-generated method stub
	  DetachedCriteria criteria = DetachedCriteria.forClass(RolesModulos.class)
//	   .add(Restrictions.eq("roles.rol", rol));
	  .add(Restrictions.eq("modulos.cve", cve));
	  return this.getHibernateTemplate().findByCriteria(criteria);
	 }
	
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<RolesModulos> getByRolModuloRoles(Long cve) {
	  // TODO Auto-generated method stub
	  DetachedCriteria criteria = DetachedCriteria.forClass(RolesModulos.class)
	  .setFetchMode("roles",FetchMode.JOIN)
//	   .add(Restrictions.eq("roles.rol", rol));
	  .add(Restrictions.eq("modulos.cve", cve));

	  return this.getHibernateTemplate().findByCriteria(criteria);
	 }
}
