package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Unidades;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IUnidadDAO;

@Service
public class UnidadServicio implements IBaseService<Unidades, Long>{

	@Resource
	private IUnidadDAO dao;
	
	@Resource
	private PermisoUnidadUsuarioServicio permisoUnidad;
	
	
	public List<Unidades> listAllByPermisoUnidad(Class<Unidades> entity,Short ejercicio) {
		return this.dao.listAllByPermisoUnidad(this.permisoUnidad.listIdUnidadPermiso(),ejercicio);
	}
	
	@Override
	public Unidades getActiveById(Class<Unidades> entity, Long id) {
		return this.dao.getActiveById(entity, id);
	}

	@Override
	public void delete(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Unidades> listAll(Class<Unidades> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<Unidades> listAll(Class<Unidades> entity, Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<Unidades> listByPage(Class<Unidades> entity, int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public Unidades getByCve(Class<Unidades> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Unidades entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Unidades> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
