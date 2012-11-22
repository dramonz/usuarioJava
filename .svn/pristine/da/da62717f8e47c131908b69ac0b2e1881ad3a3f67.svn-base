package mx.gob.tabasco.saf.siafe.presupuesto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CatalogosPeticiones;;

public interface ICatalogoPeticionDAO extends IBaseHibernateDAO<CatalogosPeticiones> {

	public List<CatalogosPeticiones> getUrlsPadres();
	
	public List<CatalogosPeticiones> getUrlsPadresByPermisosRol(List<Long> modulos);
	
	public List<CatalogosPeticiones>  findCatalogoPeticionByUrl(String url);
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws DataAccessException
	 */
	public List<CatalogosPeticiones> findByUrl(List<String> url) 
			throws DataAccessException;
	
	/**
	 * 
	 * @param claves
	 * @return
	 */
	public List<CatalogosPeticiones> findByCve(Long[] claves);
	
}
