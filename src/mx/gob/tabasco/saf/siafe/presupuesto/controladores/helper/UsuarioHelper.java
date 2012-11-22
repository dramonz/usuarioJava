package mx.gob.tabasco.saf.siafe.presupuesto.controladores.helper;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Roles;
import mx.gob.tabasco.saf.siafe.mapeo.modelo.Usuarios;
import mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B.UsuarioF2B;

public class UsuarioHelper {

	public static List<UsuarioF2B> convertListModelToListF2B(
			List<Usuarios> usuarios) {
		List<UsuarioF2B> usuariosF2B = new ArrayList<UsuarioF2B>();
		String roles = "";
		int endIndex;
		for (Usuarios usuario : usuarios) {
			UsuarioF2B usuarioF2B = new UsuarioF2B();
			usuarioF2B.setCve(usuario.getCve());
			usuarioF2B.setNombreCompleto(usuario.getEmpleados()
					.getNombreCompleto());
			usuarioF2B.setNombreUsuario(usuario.getNombreUsuario());
			for (Roles rol : usuario.getRoles()) {
				roles = roles + rol.getDescripcion() + ", ";
			}
			endIndex = roles.lastIndexOf(",");
			if(roles.length()!=0)
				usuarioF2B.setDescripcionRol(roles.substring(0, endIndex));
			else usuarioF2B.setDescripcionRol(roles);
			usuarioF2B.setActivo(usuario.getActivo());
			usuarioF2B.setCveEmpleado(usuario.getEmpleados().getCve());
			usuarioF2B.setFechaInicio(usuario.getFechaInicioVigencia());
			usuarioF2B.setFechaVencimiento(usuario.getFechaVencimientoVigencia());
			usuarioF2B.setContrasenia(usuario.getContrasenia());
			usuariosF2B.add(usuarioF2B);
		}
		return usuariosF2B;
	}

	public static UsuarioF2B convertModelToF2B(Usuarios usuario) {
		String roles = "";
		int endIndex;
		UsuarioF2B usuarioF2B = new UsuarioF2B();
		usuarioF2B.setCve(usuario.getCve());
		usuarioF2B
				.setNombreCompleto(usuario.getEmpleados().getNombreCompleto());
		usuarioF2B.setNombreUsuario(usuario.getNombreUsuario());
		for (Roles rol : usuario.getRoles()) {
			roles = roles + rol.getDescripcion() + ", ";
		}
		endIndex = roles.lastIndexOf(",");
		usuarioF2B.setDescripcionRol(roles.substring(0, endIndex));
		usuarioF2B.setActivo(usuario.getActivo());
		
		return usuarioF2B;
	}
}
