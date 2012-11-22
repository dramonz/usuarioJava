package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


public class FechaUtils {
	
	protected final static Logger log = Logger.getLogger(FechaUtils.class);
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	private static DateFormat year       = new SimpleDateFormat("yyyy");
	private static DateFormat timeFormat = new SimpleDateFormat("HHmmss");
	private static DateFormat stringFecha = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Short converYearToShort(Date date){
		try {
			Short fecha = Short.parseShort(year.format(date));
			return fecha;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error("Error al cambiar la fecha: "+e);
			throw e;
		}
	}
	
	public static Long convertDatetoLong(Date date){
		try {
			Long fecha = Long.parseLong(dateFormat.format(date));
			
			return fecha;
		} catch (NumberFormatException e) {
			log.error("Error al cambiar la fecha: "+e);
			throw e;
		}
		
	}
	

	public static Long convertStringtoLong(String string){
		try {
			String[] fecha = string.split("/");

			if(fecha[1].equals("Ene")){
				fecha[1]="01";
			}else if(fecha[1].equals("Feb")){
				fecha[1] = "02";
			}else if(fecha[1].equals("Mar")){
				fecha[1]="03";
			}else if(fecha[1].equals("Abr")){
				fecha[1]="04";
			}else if(fecha[1].equals("May")){
				fecha[1]="05";
			}else if(fecha[1].equals("Jun")){
				fecha[1]="06";
			}else if(fecha[1].equals("Jul")){
				fecha[1]="07";
			}else if(fecha[1].equals("Ago")){
				fecha[1]="08";
			}else if(fecha[1].equals("Sep")){
				fecha[1]="09";
			}else if(fecha[1].equals("Oct")){
				fecha[1]="10";
			}else if(fecha[1].equals("Nov")){
				fecha[1]="11";
			}else if(fecha[1].equals("Dic")){
				fecha[1]="12";
			}

			
			String fechaCorrecta = fecha[2]+fecha[1]+fecha[0];
			Long fechaLong = new Long(fechaCorrecta);
			return fechaLong;
		} catch (NumberFormatException e) {
			log.error("Error al cambiar la fecha: "+e);
			throw e;
		}
	}
	
	public static Date convertLongToString(Long fecha) throws ParseException {
		try {
			return stringFecha.parse(fecha.toString());
		} catch (ParseException e) {
			log.error("Error al convertir la fecha de Long a Date: " + e);
			throw e;
		}
	}
	
	public static Long convertTimetoLong(Date date){
		try {
			Long hora = Long.parseLong(timeFormat.format(date));
			
			return hora;
		} catch (NumberFormatException e) {
			log.error("Error al dar formato la hora: "+e);
			throw e;
		}
		
	}
	 
	public static Date convertLongToDate(Long fecha) throws ParseException {
		try {
			return dateFormat.parse(fecha.toString());
		} catch (ParseException e) {
			log.error("Error al convertir la fecha de Long a Date: " + e);
			throw e;
		}
	}
	
	
	
	public static Date convertLongToTime(Long hora) throws ParseException {
		try {
			return timeFormat.parse(hora.toString());
		} catch (ParseException e) {
			log.error("Error al convertir la hora de Long a Date: " + e);
			throw e;
		}
	}
	
	public static String formatDate(Date fecha, String formato) {
		DateFormat formatoFecha = new SimpleDateFormat(formato);
		
		return formatoFecha.format(fecha);
	}
	
	public static Date convertLongToHour(Long horaLong) throws ParseException{
		
		try {
			
			return timeFormat.parse(horaLong.toString());
			
		} catch (ParseException e) {
			log.error("Error al dar formato la hora: "+e);
			throw e;
		}
	}
	
	

}
