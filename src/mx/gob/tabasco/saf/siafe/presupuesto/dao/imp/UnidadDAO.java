package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Unidades;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUnidadDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioSessionService;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.EjercicioUtilerias;

@Repository
public class UnidadDAO extends BaseHibernateDAO<Unidades> implements IUnidadDAO{
	
	@Resource
	private UsuarioSessionService usuarioSession;
	
	@SuppressWarnings("unchecked")
	public List<Unidades> listAllByPermisoUnidad(List<Long> idUnidades,Short ejercicio){
		DetachedCriteria criteria = DetachedCriteria.forClass(Unidades.class)
		.add(Restrictions.eq("activo",1))
		.addOrder( Order.asc("codigoUnidad") );		
		if(ejercicio!=null){
			criteria.add(Restrictions.eq("ejercicio",ejercicio));
		}else{
			criteria.add(Restrictions.eq("ejercicio",EjercicioUtilerias.getEjercicioActual().shortValue()));
		}
		
		if(!this.usuarioSession.isRol("ROLE_ADMIN")){
		
			if(idUnidades !=null){
				if(idUnidades.size()>0){
					criteria.add(Restrictions.in("id", idUnidades));
				}else{
					criteria.add(Restrictions.isNull("id"));
				}
			}
		}		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

}
