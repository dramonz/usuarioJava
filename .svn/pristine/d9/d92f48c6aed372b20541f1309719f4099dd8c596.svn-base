package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.UsuariosRoles;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.UsuarioRolF2B;

public class UsuarioRolHelper {

	public static List<UsuarioRolF2B> convertListModelToListF2B(List<UsuariosRoles> usuariosRoles){
		List<UsuarioRolF2B> usuarioRolF2Bs = new ArrayList<UsuarioRolF2B>();
		for(UsuariosRoles usuarioRol:usuariosRoles){
			UsuarioRolF2B usuarioRolF2B = new UsuarioRolF2B();
			usuarioRolF2B.setActivo(usuarioRol.getActivo());
			usuarioRolF2B.setCveEmpleado(usuarioRol.getUsuarios().getEmpleados().getCve());
			usuarioRolF2B.setCveUsuario(usuarioRol.getUsuarios().getCve());
			usuarioRolF2B.setDescripcionRol(usuarioRol.getRoles().getDescripcion());
			usuarioRolF2B.setId(usuarioRol.getId_1());
			usuarioRolF2B.setNombreEmpleado(usuarioRol.getUsuarios().getEmpleados().getNombreCompleto());
			usuarioRolF2B.setNombreUsuario(usuarioRol.getUsuarios().getNombreUsuario());
			usuarioRolF2B.setRol(usuarioRol.getRoles().getRol());
			usuarioRolF2Bs.add(usuarioRolF2B);			
		}
		return usuarioRolF2Bs;
	}
}
