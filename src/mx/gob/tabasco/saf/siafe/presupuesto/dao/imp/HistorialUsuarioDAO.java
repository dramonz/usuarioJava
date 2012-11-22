package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

// default package

import org.springframework.stereotype.Repository;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialUsuarios;

/**
 * A data access object (DAO) providing persistence and search support for
 * HistorialUsuario entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .HistorialUsuario
 * @author MyEclipse Persistence Tools
 */

@Repository
public class HistorialUsuarioDAO extends BaseHibernateDAO<HistorialUsuarios>
		implements IHistorialUsuarioDAO {
}