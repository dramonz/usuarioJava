package mx.gob.tabasco.saf.siafe.presupuesto.dao;

// default package

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.MapasPeticiones;

/**
 * Interface for MapaPeticionesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMapaPeticionDAO extends IBaseHibernateDAO<MapasPeticiones> {
	
	public MapasPeticiones findRolByUrl(String url);
	
	public List<MapasPeticiones> getByRol(String rol);
	
	public MapasPeticiones getByRolAndUrl(String rol, String url);
	
}