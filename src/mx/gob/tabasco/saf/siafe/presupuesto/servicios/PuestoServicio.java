package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Puestos;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IPuestoDAO;

@Service
public class PuestoServicio implements IBaseService<Puestos, Long>{
	
	@Resource
	private IPuestoDAO dao;

	@Override
	public Puestos getActiveById(Class<Puestos> entity, Long id) {
		return null;
	}

	@Override
	public void delete(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Puestos> listAll(Class<Puestos> entity) {
		return this.dao.listAll(entity);
	}
	
	public List<Puestos> findAll(Class<Puestos> entity) {
		return this.dao.findAll(entity);
	}

	@Override
	public List<Puestos> listAll(Class<Puestos> entity, Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<Puestos> listByPage(Class<Puestos> entity, int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public Puestos getByCve(Class<Puestos> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Puestos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Puestos> entity) {
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
