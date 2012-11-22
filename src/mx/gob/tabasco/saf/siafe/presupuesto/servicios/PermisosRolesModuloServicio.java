package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.List;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.RolesModulos;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.constantes.Constantes;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.imp.IRolesModulosDAO;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermisosRolesModuloServicio implements IBaseService<RolesModulos, Long> {

	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	IRolesModulosDAO rolesModulosDAO;
	
	@Override
	public Long countActiveRecords(Class<RolesModulos> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
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
	public RolesModulos getActiveById(Class<RolesModulos> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesModulos getByCve(Class<RolesModulos> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolesModulos> listAll(Class<RolesModulos> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolesModulos> listAll(Class<RolesModulos> entity) {
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
	public void update(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(RolesModulos entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public void verificaPermisosModulo(Usuarios entity){
		List<RolesModulos> rolesModulos = rolesModulosDAO.obtenerListaRoles(Constantes.numeroModulo);
		boolean continua = false;
		
		try {
			for (RolesModulos rolesModulos2 : rolesModulos) {
				for (Roles roles : entity.getRoles()) {
					if (rolesModulos2.getRoles().getRol().equals(roles.getRol()) ){
						continua = true;
					}
				}
			}
			 if(!continua){
						 throw new  AuthenticationException("Usuario / No tiene privilegios sobre Usuarios");
			 }
		} catch (Exception e) {
			log.error("Ocurrio un error al verificar permisos del modulo");
			throw new AuthenticationServiceException("Usuario / No tiene privilegios sobre Usuarios");
		}
	}
	
	
}
