package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialSesionesDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialSesiones;

import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * HistorialSesiones entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see mx.gob.tabasco.saf.siafe.tesoreria.modelos.HistorialSesiones
 * @author MyEclipse Persistence Tools
 */

@Repository
public class HistorialSesionesDAO extends BaseHibernateDAO<HistorialSesiones>
		implements IHistorialSesionesDAO{
}
