package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IBaseHibernateDAO;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Data access object (DAO) for domain model
 * 
 * @author 
 */
@Repository
public abstract class BaseHibernateDAO<T>  extends HibernateDaoSupport implements IBaseHibernateDAO<T> {
	
	protected final Logger log = Logger.getLogger(this.getClass());

    @SuppressWarnings("rawtypes")
	private Class entityClass = null;

	
	@Autowired
	public void init(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public Session getCurrentSessionInstance() {
		//return getSession();
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	public HibernateTemplate getCurrentHibernateTemplate() {
		return this.getHibernateTemplate();
	}
	
    @SuppressWarnings("unchecked")
	@Transactional
	public T getActiveById(Class<T> entity, Long id) {
		log.debug("getActiveById ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity)
				.add(Restrictions.eq("id", id))
				.add(Restrictions.eq("activo", 1));
			
			return (T) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
		} catch (IncorrectResultSizeDataAccessException e) {
			log.error("getActiveById failed", e);
			throw e;
		} catch (DataAccessException e) {
			log.error("getActiveById failed", e);
			throw e;
		}
	}
	
	@Transactional
	public void delete(T entity) {
		log.debug("deleting ["+entity+"]  instance");
		try {
			getHibernateTemplate().delete(entity);
			getHibernateTemplate().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listAll(Class<T> entity) {
		log.debug("listAll ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity)
				.add(Restrictions.eq("activo", 1));
			
			return getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			log.error("listAll failed", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll(Class<T> entity) {
		log.debug("listAll ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity);
			
			return getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			log.error("listAll failed", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listAll(Class<T> entity, Long id) {
		log.debug("listAll ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity)
			.add(Restrictions.eq("id",id))
			.add(Restrictions.eq("activo", 1));
		
			return getHibernateTemplate().findByCriteria(criteria);
		}catch(DataAccessException e) {
			log.error("listAll failed", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> listByPage(Class<T> entity, int from, int limit) {
		log.debug("listByPage ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity)
				.add(Restrictions.eq("activo", 1));
			
			return getHibernateTemplate().findByCriteria(criteria, from, limit);
		} catch (DataAccessException e) {
			log.error("listByPage failed", e);
			throw e;
		}
	}
	
	@Transactional
	public T getByCve(Class<T> entity, Long cve) {
		log.debug("getByCve ["+entity+"]  instance");
		try {
			return getHibernateTemplate().get(entity, cve);
		} catch (DataAccessException e) {
			log.error("getByCve failed", e);
			throw e;
		}
	}

	@Transactional
    public void insert(T entity) {
		log.info("saving ["+getEntityClass()+"] instance");
    	try {
    		getHibernateTemplate().save(entity);
    		getHibernateTemplate().flush();
    		log.info("save successful");
    	} catch (RuntimeException re) {
    		log.error("save failed", re);
    	    throw re;
    	}
     }
	
	@Transactional
	public void update(T entity) {
		log.debug("update ["+entity+"]  instance");
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			getHibernateTemplate().flush();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	@Transactional
	public void ejecutarHQL(String sqlNativo){
		log.debug("ejecutarHQL ["+sqlNativo+"]  instance");
		try {
			getCurrentSessionInstance().createQuery(sqlNativo).executeUpdate();		
			log.debug("ejecutarHQL successful");
		} catch (RuntimeException re) {
			log.error("ejecutarHQL failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Long countActiveRecords(Class<T> entity) {
		log.debug("countActiveRecords ["+entity+"]  instance");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity)
				.add(Restrictions.eq("activo", 1)).setProjection(Projections.rowCount());
			
			return (Long) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
		} catch (IncorrectResultSizeDataAccessException e) {
			log.error("countActiveRecords failed", e);
			throw e;
		} catch (DataAccessException e) {
			log.error("countActiveRecords failed", e);
			throw e;
		}
	}
	
	@Transactional
	public Long findNextCve(Class<T> entity){
		log.debug("finding NextCve instance with entity: " +entity);
		try {
			String queryString = "select nvl(max(model.cve),0)+1 from "+entity.getName()+" as model";
			Query queryObject = getCurrentSessionInstance().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("failed finding NextCve instance with entity: "+entity, re);
			throw re;
		}
	}
	
	@Transactional
	public Long findNextId(Class<T> entity){
		log.debug("finding NextId instance with entity: " +entity);
		try {
			String queryString = "select nvl(max(model.id),0)+1 from "+entity.getName()+" as model";
			Query queryObject = getCurrentSessionInstance().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("failed finding NextId instance with entity: "+entity, re);
			throw re;
		}
	}
	
	/**
     * @param entityClass the entityClass to set
     */
	@SuppressWarnings("rawtypes")
    public void setEntityClass(Class myEntityName) {
    	this.entityClass = myEntityName;
    }

    /**
     * @return the entityClass
     */
    @SuppressWarnings("rawtypes")
	public Class getEntityClass() {
    	return entityClass;
    }

}
	
