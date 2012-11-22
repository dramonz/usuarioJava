package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.RolModuloF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IRolModuloDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.RolModuloHelper;

import org.springframework.stereotype.Service;

@Service
public class RolModuloServicio implements IBaseService<RolesModulos, Long>{
	
	@Resource
	private IRolModuloDAO dao;
	
	@Resource
	private ControlConsecutivosServicio controlConsecutivoServicio;
	
	/**
	 * obtiene la lista de roles modulos por rol
	 * @param rol
	 * @return
	 */
	public List<RolesModulos> listarByRol(String rol){
		return this.dao.getByRol(rol);
	}
	
	/**
	 * listByRol
	 * @param rol
	 * @return List<RolModuloF2B>
	 */
	public List<RolModuloF2B> listByRol(String rol){
		return RolModuloHelper.convertListEntityToF2B(this.dao.getByRol(rol));
	}

	@Override
	public RolesModulos getActiveById(Class<RolesModulos> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RolesModulos entity) {
		// TODO Auto-generated method stub
		this.dao.delete(entity);
	}

	@Override
	public void deleteHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolesModulos> listAll(Class<RolesModulos> entity) {
		return null;
	}

	@Override
	public List<RolesModulos> listAll(Class<RolesModulos> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<RolesModulos> listByPage(Class<RolesModulos> entity, int from,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesModulos getByCve(Class<RolesModulos> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(RolesModulos entity) {
		entity.setCve(this.findNextCve());
		this.dao.insert(entity);
	}

	@Override
	public void insertHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RolesModulos entity) {
		this.update(entity);
	}

	@Override
	public void updateHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<RolesModulos> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		return controlConsecutivoServicio.obtieneCVE("RolesModulos");
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
