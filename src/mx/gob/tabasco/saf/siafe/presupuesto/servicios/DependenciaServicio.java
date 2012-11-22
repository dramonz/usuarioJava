package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Dependencias;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IDependenciaDAO;

@Service
public class DependenciaServicio implements IBaseService<Dependencias, Long> {

	@Resource
	private IDependenciaDAO dao;
	
	@Override
	public Dependencias getActiveById(Class<Dependencias> entity, Long id) {
		return this.dao.getActiveById(entity, id);
	}

	@Override
	public void delete(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dependencias> listAll(Class<Dependencias> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<Dependencias> listAll(Class<Dependencias> entity, Long id) {
		return this.listAll(entity, id);
	}

	@Override
	public List<Dependencias> listByPage(Class<Dependencias> entity, int from,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dependencias getByCve(Class<Dependencias> entity, Long cve) {
		return this.getByCve(entity, cve);
	}

	@Override
	public void insert(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Dependencias entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Dependencias> entity) {
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
