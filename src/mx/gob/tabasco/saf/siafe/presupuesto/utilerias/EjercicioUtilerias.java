package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EjercicioUtilerias {

	private static final DateFormat formato = new SimpleDateFormat("yyyy");
	
	protected static Long ejercicioActual;
	
	protected static Long ejercicioSiguiente;
	
	public static Long getEjercicioActual() {
		if (null == ejercicioActual) {
			ejercicioActual = 2013L;//Long.parseLong(formato.format(new Date()));
		}
		
		return ejercicioActual;
	}
	
	public static Long getEjercicioSiguiente() {
		if (null == ejercicioSiguiente) {
			ejercicioSiguiente = getEjercicioActual() + 1L;
		}
		
		return ejercicioSiguiente;
	}
	
}
