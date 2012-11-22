package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Areas;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IAreaDAO;

@Service
public class AreaServicio implements IBaseService<Areas, Long>{
	
	@Resource
	private IAreaDAO dao;

	@Override
	public Areas getActiveById(Class<Areas> entity, Long id) {
		return dao.getActiveById(entity, id);
	}

	@Override
	public void delete(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Areas> listAll(Class<Areas> entity) {
		return this.dao.listAll(entity);
	}
	
	
	public List<Areas> findAll(Class<Areas> entity) {
		return this.dao.findAll(entity);
	}

	@Override
	public List<Areas> listAll(Class<Areas> entity, Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<Areas> listByPage(Class<Areas> entity, int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public Areas getByCve(Class<Areas> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Areas entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Areas> entity) {
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
