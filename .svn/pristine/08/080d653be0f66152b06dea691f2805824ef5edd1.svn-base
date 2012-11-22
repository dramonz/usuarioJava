package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.UsuariosRoles;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUsuarioRolDAO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRolDAO extends BaseHibernateDAO<UsuariosRoles> implements IUsuarioRolDAO{
	
	@SuppressWarnings("unchecked")
	public List<UsuariosRoles> listUsuariosRoles(Long cveUsuario){
		DetachedCriteria criteria = DetachedCriteria.forClass(UsuariosRoles.class)
		.add(Restrictions.eq("id.cveUsuario", cveUsuario));		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public UsuariosRoles getByCveAndRol(Long cveUsuario,String rol){
		DetachedCriteria criteria = DetachedCriteria.forClass(UsuariosRoles.class)
		.add(Restrictions.eq("id.cveUsuario", cveUsuario))
		.add(Restrictions.eq("id.rol", rol));		
		return DataAccessUtils.uniqueResult(this.getHibernateTemplate().findByCriteria(criteria));
	}

}
