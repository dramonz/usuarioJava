package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Modulos;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IModuloDAO;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ModuloDAO extends BaseHibernateDAO<Modulos> implements IModuloDAO{

	@SuppressWarnings("unchecked")
	 @Transactional  
	 public List<Modulos> findByUsuario(Long cveUsuario){
	  DetachedCriteria criteria = DetachedCriteria.forClass(Modulos.class);
	  criteria.setFetchMode("permisosUnidadesUsuario", FetchMode.JOIN);
	  criteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
		.createCriteria("permisosUnidadesUsuario")
		.add(Restrictions.eq("id.cveUsuario", cveUsuario));

	  List<Modulos> resultado = (List<Modulos>) getHibernateTemplate().findByCriteria(criteria);
	  return resultado;
	 }
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Modulos> findByUsuario(Long cveUsuario)
//			throws DataAccessException {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Modulos.class)
//				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
//				.createCriteria("permisosUnidadesUsuario")
//				.add(Restrictions.eq("id.cveUsuario", cveUsuario));
//		
//		return this.getHibernateTemplate().findByCriteria(criteria);
//	}
	

	@Override
	public List<Modulos> findByRol(String rol) throws DataAccessException {
		//@TODO
		return null;
	}

}
