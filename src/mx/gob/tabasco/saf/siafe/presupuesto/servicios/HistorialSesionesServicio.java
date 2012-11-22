package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mx.gob.tabasco.saf.siafe.presupuesto.constantes.Constantes;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IHistorialSesionesDAO;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.CustomUserDetails;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.HistorialSesiones;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.FechaUtils;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("historyService")
public class HistorialSesionesServicio implements
		IBaseService<HistorialSesiones, Long>{

	protected final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	IHistorialSesionesDAO dao;
	
	@Resource
	private ControlConsecutivoServicioWeb controlConsecutivoServicioWeb;
	
	@Resource
	UsuarioSessionService usuarioSessionService;

	@Override
	public HistorialSesiones getActiveById(Class<HistorialSesiones> entity,
			Long id) {
		return null;
	}

	@Override
	public void delete(HistorialSesiones entity) {
		this.dao.delete(entity);
	}

	@Override
	public void deleteHistorico(HistorialSesiones entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HistorialSesiones> listAll(Class<HistorialSesiones> entity) {
		return this.dao.listAll(entity);
	}

	@Override
	public List<HistorialSesiones> listAll(Class<HistorialSesiones> entity,
			Long id) {
		return this.dao.listAll(entity, id);
	}

	@Override
	public List<HistorialSesiones> listByPage(Class<HistorialSesiones> entity,
			int from, int limit) {
		return this.dao.listByPage(entity, from, limit);
	}

	@Override
	public HistorialSesiones getByCve(Class<HistorialSesiones> entity, Long cve) {
		return this.dao.getByCve(entity, cve);
	}

	@Override
	public void insert(HistorialSesiones entity) {		
		entity.setCve(this.findNextCve());
		entity.setFechaInicio(FechaUtils.convertDatetoLong(new Date()));
		entity.setHoraInicio(FechaUtils.convertTimetoLong(new Date()));
		entity.setFechaRegistro(FechaUtils.convertDatetoLong(new Date()));
		entity.setHoraRegistro(FechaUtils.convertTimetoLong(new Date()));
		entity.setActivo(Constantes.ACTIVO);
		entity.setId(this.findNextId());
		entity.setFechaCierre(0L);
		entity.setHoraCierre(0L);
		this.dao.insert(entity);
	}
	
	public void insertSesion(HistorialSesiones entity, HttpServletRequest request) {
		try{
			log.info("begin insertSesion.................");
			
			CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication();
			
			String remoteAddress = request.getRemoteHost();
			String localAddress = request.getLocalAddr();
			entity.setIpCliente(remoteAddress);
			entity.setIpServidor(localAddress);
			Usuarios u = new Usuarios();
			u.setCve(usuarioSessionService.getCveUsuario());
			entity.setUsuarios(u);
			user.setHistorialSession(entity);
			entity.setCveModulo(Constantes.numeroModulo.longValue());
			this.insert(entity);
			log.info("success insertSesion.................");
			
		}catch (Exception e) {
			log.error("Error Insertar session : ", e);
		}
	}

	@Override
	public void insertHistorico(HistorialSesiones entity) {
		// TODO Auto-generated method stub

	}

	public void update(HistorialSesiones entity) {
		
	}
	
	public void updateSesion() {
		try{
			log.info("begin updateSesion.................");
			
			CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication();
			HistorialSesiones entity = user.getHistorialSession();
			entity.setFechaCierre(Long.valueOf(FechaUtils.convertDatetoLong(new Date()).toString()));
			entity.setHoraCierre(Long.valueOf(FechaUtils.convertTimetoLong(new Date()).toString()));
			
			this.dao.update(entity);
			
			log.info("success updateSesion.................");
			
			
		}catch (Exception e) {
			log.error("Error Update session : "+e);
		}

	}

	@Override
	public void updateHistorico(HistorialSesiones entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long countActiveRecords(Class<HistorialSesiones> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		return controlConsecutivoServicioWeb.obtieneCVE("HistorialSesiones");
	}

	@Override
	public Long findNextId() {
		// TODO Auto-generated method stub
		return controlConsecutivoServicioWeb.obtieneID("HistorialSesiones");
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return this.usuarioSessionService.getCveUsuario();
	}

}
