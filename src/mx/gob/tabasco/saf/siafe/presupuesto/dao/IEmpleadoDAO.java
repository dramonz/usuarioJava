package mx.gob.tabasco.saf.siafe.presupuesto.dao;
// default package

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Empleados;

/**
 * Interface for EmpleadosDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEmpleadoDAO extends IBaseHibernateDAO<Empleados>{
	/**
	 * Lista los empleados solo con las unidades que tiene permitodo ver el usuario en sesion
	 * @param idUnidades
	 * @return
	 */
	public List<Empleados> listaByIdUnidadesPermitidas(List<Long> idUnidades,String empleado,Long cveJefe);
}