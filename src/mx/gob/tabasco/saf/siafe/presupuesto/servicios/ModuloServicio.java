package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CustomUserDetails;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Modulos;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.constantes.Constantes;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.ModuloF2B;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper.ModuloHelper;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IModuloDAO;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuloServicio implements IBaseService<Modulos, Long>{
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private RolModuloServicio rolModuloServicio;
	
	@Resource
	private IModuloDAO dao;

	@Override
	public Modulos getActiveById(Class<Modulos> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Modulos> listAll(Class<Modulos> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<Modulos> listAll(Class<Modulos> entity, Long id) {
		return this.dao.listAll(entity, id);
	}
	

	public Set<Modulos> listAll() {
		Set<Modulos> modulos = new HashSet<Modulos>();
		for(Modulos modulo : this.listAll(Modulos.class)){
			modulos.add(modulo);
		}
		return modulos;
	}
	
	@Transactional(readOnly = true)
	public Set<Modulos> findAllModules(Class<RolesModulos> entity) {
		log.info("Getting Modudes..."+entity);
		Set<Modulos> modulos = new HashSet<Modulos>();
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
				.getContext().getAuthentication();
		Usuarios usuario = (Usuarios) user.getDetails();
		for (Roles roles : usuario.getRoles()) {
			if(roles.getRol().equals(Constantes.ROLE_ADMIN)){
				modulos = this.listAll();
				break;
			}else{
				List<RolesModulos> rolesModulos = this.rolModuloServicio.listarByRol(roles.getRol());
				for(RolesModulos rolModulo :rolesModulos){
					modulos.add(rolModulo.getModulos());
				}
			}
			
		}
		
		return modulos;
	}
	@Transactional
	public List<ModuloF2B> findAllModules() {
		return ModuloHelper.convertSetModelToListF2B(findAllModules(RolesModulos.class));
	}

	@Override
	public List<Modulos> listByPage(Class<Modulos> entity, int from, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulos getByCve(Class<Modulos> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Modulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Modulos> entity) {
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
