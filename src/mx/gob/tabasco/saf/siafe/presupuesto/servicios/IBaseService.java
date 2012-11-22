package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.io.Serializable;
import java.util.List;


public interface IBaseService<T, PK extends Serializable> {
	
	public T getActiveById(Class<T> entity, Long id);
	
	public void delete(T entity);

	public void deleteHistorico(T entity);
	
	public List<T> listAll(Class<T> entity);
	
	public List<T> listAll(Class<T> entity, Long id);
	
	public List<T> listByPage(Class<T> entity, int from, int limit);
	
	public T getByCve(Class<T> entity, Long cve);
	
	public void insert(T entity);
	
	public void insertHistorico(T entity);
	
	public void update(T entity);
	
	public void updateHistorico(T entity);
	
	public Long countActiveRecords(Class<T> entity);
	
	public Long findNextCve();
	
	public Long findNextId();
	
	public Long getCveUsuario();

}