package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

// default package
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IMapaPeticionDAO;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * MapaPeticiones entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .MapaPeticiones
 * @author MyEclipse Persistence Tools
 */

@Repository
public class MapaPeticionDAO extends BaseHibernateDAO<MapasPeticiones> implements
		IMapaPeticionDAO {

	@Transactional
	@Override
	public Long findNextCve(Class<MapasPeticiones> entity){
		log.debug("finding NextCve instance with entity: " +entity);
		try {
			String queryString = "select nvl(max(model.cveMapaPeticion),0)+1 from "+entity.getName()+" as model";
			Query queryObject = getCurrentSessionInstance().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("failed finding NextCve instance with entity: "+entity, re);
			throw re;
		}
	}
	
	@Transactional
	@Override
	public MapasPeticiones findRolByUrl(String url) {
		log.debug("findRolByUrl instance with url: " + url);
		try {
			DetachedCriteria criteria = DetachedCriteria
			.forClass(MapasPeticiones.class).add(
					Restrictions.eq("url", url));

			@SuppressWarnings("unchecked")
			MapasPeticiones mapa = DataAccessUtils.uniqueResult(this
			.getHibernateTemplate().findByCriteria(criteria));
			return mapa;
			
		} catch (RuntimeException re) {
			log.error("failed findRolByUrl instance with url: " + url, re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapasPeticiones> getByRol(String rol) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MapasPeticiones.class)
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.ne("rol", "IS_AUTHENTICATED_FULLY"))
				.add(Restrictions.like("rol", "%" + rol + "%"));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MapasPeticiones getByRolAndUrl(String rol, String url) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MapasPeticiones.class)
				.add(Restrictions.eq("rol", rol))
				.add(Restrictions.eq("url", url));
		return DataAccessUtils.uniqueResult(
				this.getHibernateTemplate().findByCriteria(criteria));
	}
	
}