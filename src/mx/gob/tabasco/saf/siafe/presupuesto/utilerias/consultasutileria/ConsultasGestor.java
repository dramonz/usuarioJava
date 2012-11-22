package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.imp.BaseHibernateDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultaSQLNativo;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ConsultasGestor extends BaseHibernateDAO<Object>{

	protected final Logger log = Logger.getLogger(this.getClass());

	@Transactional
	public void ejecutar(String sqlNativo){
		 try {
			getCurrentSessionInstance().createSQLQuery(sqlNativo).executeUpdate();
		} catch (HibernateException e) {
			log.error("Error en el metodo ejecutar: ",e);
		}			
	}
	
	@Transactional
	public void ejecutarHQL(String sqlNativo){
		 try {
			 getCurrentSessionInstance().createQuery(sqlNativo).executeUpdate();
		} catch (HibernateException e) {
			log.error("Error en el metodo ejecutarHQL: ",e);
		}			
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> consultarHQL(String sqlNativo , Class<T> entidad){
		 try {
			 List<T> lista = (List<T>) getCurrentSessionInstance().createQuery(sqlNativo).list();
			 
			 return lista;
			 
		} catch (HibernateException e) {
			log.error("Error en el metodo consultarHQL: ",e);
			throw e;
			
		}	
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ConsultaSQLNativo consultar(ConsultaSQLNativo consultaSqlNativo){
		try {
			consultaSqlNativo.setResult( (List<Object>) getCurrentSessionInstance().createSQLQuery(consultaSqlNativo.getSqlNativo()).list()  );			
			return consultaSqlNativo;
		} catch (HibernateException e) {
			log.error("Error en el metodo ConsultaSQLNativo consultar: ",e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> consultar(ConsultaSQLNativo consultaSqlNativo, Class<T> entidad){
		try {
			List<T> lista = (List<T>) getCurrentSessionInstance().createSQLQuery(consultaSqlNativo.getSqlNativo()).addEntity(entidad).list();
			return lista;
		} catch (HibernateException e) {
			log.error("Error en el metodo List<T> consultar: ",e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> consultar(String sql_nativo, Class<T> entidad){
		try {
			List<T> lista = (List<T>) getCurrentSessionInstance().createSQLQuery( sql_nativo ).addEntity(entidad).list();
			return lista;
		} catch (HibernateException e) {
			log.error("Error en el metodo List<T> consultar: ",e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public ConsultaSQLNativo consultarConPaginacion(ConsultaSQLNativo consultaSqlNativo){
		try {
			consultaSqlNativo.setResult( (
					List<Object>) getCurrentSessionInstance().createSQLQuery(consultaSqlNativo.getSqlNativo())
					.setMaxResults(consultaSqlNativo.getResultadoMaximo())
					.setFirstResult(consultaSqlNativo.getPrimerResultado())
					.list()  );			
			return consultaSqlNativo;
		} catch (HibernateException e) {
			log.error("Error en el metodo ConsultaSQLNativo consultarConPaginacion: ",e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> consultarConPaginacion(ConsultaSQLNativo consultaSqlNativo, Class<T> entidad){
		try {
			List<T> lista =  (List<T>) getCurrentSessionInstance().createSQLQuery(
						consultaSqlNativo.getSqlNativo())
						.addEntity(entidad)
						.setMaxResults(consultaSqlNativo.getResultadoMaximo())
						.setFirstResult(consultaSqlNativo.getPrimerResultado())
						.list();
			return lista;
		} catch (HibernateException e) {
			log.error("Error en el metodo List<T> consultarConPaginacion: ",e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Object traerUnValor(String sql_nativo){
		List<Object> valor = new ArrayList<Object>();
		log.info("Comienza traerUnValor con los valores: "+sql_nativo);
		try {
			valor = getCurrentSessionInstance().createSQLQuery(sql_nativo).list();
			if(valor != null){
				if(valor.size()!=0){
					Object valorSalida = valor.get(0);
					log.info("valor de traer un valor-> "+valor.size());
					return valorSalida;
				}else{
					log.info("valor de traer un valor-> "+0);
					return 0;
				}
				
			}
			else{
				log.info("valor de traer un valor-> nulo");
				return null;
			}
		} catch (HibernateException e) {
			log.error("Error en el metodo traerUnValor: ",e);
			throw e;
		}
	}
	
	
//	@Autowired
//	public void init(SessionFactory sessionFactory) {
//		super.setSessionFactory(sessionFactory);
//	}
//	
//	public Session getCurrentSessionInstance() {
//		//return getSession();
//		return getHibernateTemplate().getSessionFactory().getCurrentSession();
//	}


}
