package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialUsuarioDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialUsuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.FechaUtils;

public class HistorialUsuarioServicio implements IBaseService<HistorialUsuarios, Long>{

	@Resource
	private	IHistorialUsuarioDAO dao;
	
	@Override
	public HistorialUsuarios getActiveById(Class<HistorialUsuarios> entity,
			Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(HistorialUsuarios entity) {		
		
	}

	@Override
	public void deleteHistorico(HistorialUsuarios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistorialUsuarios> listAll(Class<HistorialUsuarios> entity) {		
		return this.dao.listAll(entity);
	}

	@Override
	public List<HistorialUsuarios> listAll(Class<HistorialUsuarios> entity,
			Long id) {		
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<HistorialUsuarios> listByPage(Class<HistorialUsuarios> entity,
			int from, int limit) {
		return this.listByPage(entity, from, limit);
	}

	@Override
	public HistorialUsuarios getByCve(Class<HistorialUsuarios> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(HistorialUsuarios entity) {
		entity.setCve(this.dao.findNextCve(HistorialUsuarios.class));
		entity.setFechaRegistro(FechaUtils.convertDatetoLong(new Date()));
		this.dao.insert(entity);
		
	}

	@Override
	public void insertHistorico(HistorialUsuarios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HistorialUsuarios entity) {
		this.dao.update(entity);		
	}

	@Override
	public void updateHistorico(HistorialUsuarios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<HistorialUsuarios> entity) {
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
