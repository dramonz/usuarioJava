package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;


import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IEmpleadoDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioSessionService;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Empleados;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Empleados entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .Empleados
 * @author MyEclipse Persistence Tools
 */
@Repository
public class EmpleadoDAO extends BaseHibernateDAO<Empleados> implements IEmpleadoDAO {
	
	@Resource
	private UsuarioSessionService usuarioSession;
	
	@SuppressWarnings("unchecked")
	public List<Empleados> listaByIdUnidadesPermitidas(List<Long> idUnidades,String empleado,Long cveJefe){
		DetachedCriteria criteria = DetachedCriteria.forClass(Empleados.class);
		if(cveJefe!=null){
			criteria.add(Restrictions.eq("cve",cveJefe));
		}
		if(empleado!=null)
			if(!empleado.equalsIgnoreCase(""))
				criteria.add(Restrictions.like("nombreCompleto", empleado.toLowerCase().trim()+"%").ignoreCase());
		if(!this.usuarioSession.isRol("ROLE_ADMIN")){
			if(idUnidades !=null){
				if(idUnidades.size()>0){
					criteria.createCriteria("unidades").add(Restrictions.in("id", idUnidades));
				}else{
					criteria.createCriteria("unidades").add(Restrictions.isNull("id"));
				}
			}
		}
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
}