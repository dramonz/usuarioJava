package mx.gob.tabasco.saf.siafe.presupuesto.controladores;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mx.gob.tabasco.saf.siafe.presupuesto.servicios.UsuarioServicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
	public class LoginControlador {
		
		@Resource
		UsuarioServicio usuarioServicio;
	
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView index(
				@RequestParam(value = "usuario",required = false)String usuario,
				@RequestParam(value = "pass",required = false)String pass,
				HttpServletRequest request) {
			HashMap<String, String> parametro = new HashMap<String, String>();
			parametro.put("usuario", usuario);
			parametro.put("pass", pass);
			
			return new ModelAndView("login/index",parametro);
		}
		/**
		 * @author danielramon
		 * Recibe el nombre del usuario para recuperar la contraseña
		 * @param String usuario
		 * @return success
		 * 
		 * **/
		@RequestMapping(value = "/recuperarcontrasenia", method = RequestMethod.POST)
		public @ResponseBody HashMap<String, Object> recuperarContrasenia(
				@RequestParam("usuario") String usuario 
				) {
			boolean result=true;
			HashMap<String, Object> response = new HashMap<String, Object>();
//			usuarioServicio.recuperarContrasenia(usuario);
			response.put("success",result);
			return response;
		}

			@RequestMapping(method = RequestMethod.POST)
			public ModelAndView indexPost(
					@RequestParam(value = "usuario", required = false) String usuario,
                               @RequestParam(value = "pass", required = false) String pass,HttpServletRequest request) {
				HashMap<String, String> parametro = new HashMap<String, String>();
               parametro.put("usuario", usuario);
               parametro.put("pass", pass);

               return new ModelAndView("login/index", parametro);

}
}

