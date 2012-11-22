package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


/**
 * Data access interface for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO<T> {
	
	@Transactional
	public T getActiveById(Class<T> entity, Long id);
	
	@Transactional
	public void delete(T entity);
	
	@Transactional
	public List<T> listAll(Class<T> entity);
	
	@Transactional
	public List<T> findAll(Class<T> entity);
	
	@Transactional
	public List<T> listAll(Class<T> entity, Long id);
	
	@Transactional
	public List<T> listByPage(Class<T> entity, int from, int limit);
	
	@Transactional
	public T getByCve(Class<T> entity, Long cve);
	
	@Transactional
	public void insert(T entity);
	
	@Transactional
	public void update(T entity);
	
	@Transactional
	public Long countActiveRecords(Class<T> entity);
	
	@Transactional
	public Long findNextCve(Class<T> entity);
	
	@Transactional
	public Long findNextId(Class<T> entity);
	
	@Transactional
	public void ejecutarHQL(String sqlNativo);
	
}