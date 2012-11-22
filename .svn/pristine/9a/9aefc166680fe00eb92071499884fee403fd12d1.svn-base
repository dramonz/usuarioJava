package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;

import mx.gob.tabasco.saf.siafe.presupuesto.constantes.CargaMasivaPCtasConstantes;

public class TextoUtilerias {
	
	public static String convertStringUT(String variable){	
		if(variable==null)return null;
		variable = variable.replace("Ã¡", "á");
		variable = variable.replace("Ã©", "é");
		variable = variable.replace("Ã*", "í");
		variable = variable.replace("Ã³", "ó");
		variable = variable.replace("Ãº", "ú");
		variable = variable.replace("Ã", "Á");
		variable = variable.replace("Ã‰", "É");
		variable = variable.replace("Ã*", "Í");
		variable = variable.replace("Ã“", "Ó");
		variable = variable.replace("Ãš", "Ú");
		variable = variable.replace("Ã±", "ñ");
		variable = variable.replace("Ã‘", "Ñ");
		variable = variable.replace("Ã€", "À");		
		variable = variable.replace("Ã¤", "ä");
		variable = variable.replace("Ã¨", "è");
		variable = variable.replace("Ãª", "ê");
		variable = variable.replace("Ã¦", "æ");
		variable = variable.replace("Ã¶", "ö");
		variable = variable.replace("Ã¼", "ü");
		variable = variable.replace("Ã§", "ç");		
		return variable;
	}
	

	public static String implodeArray(String[] inputArray, String glueString) {
		if (inputArray.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(inputArray[0]);

			for (int i = 1; i < inputArray.length; i++) {
				if (!(inputArray[i] instanceof String)) {
					continue;
				}
				
				sb.append(glueString);
				sb.append(inputArray[i]);
			}

			return sb.toString();
		}

		return "";
	}
	
	/**
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean isNumeric(String cadena){
		try {
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/**
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean isDouble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static boolean mesValido(String mes){
		try {
			if(mes.equals(CargaMasivaPCtasConstantes.ENE))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.FEB))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.MAR))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.ABR))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.MAY))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.JUN))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.JUL))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.AGO))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.SEP))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.OCT))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.NOV))
				return true;
			else if(mes.equals(CargaMasivaPCtasConstantes.DIC))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static Byte obtieneMes(String mes){
		try {
			if(mes.equals(CargaMasivaPCtasConstantes.ENE))
				return CargaMasivaPCtasConstantes.ENERO;
			else if(mes.equals(CargaMasivaPCtasConstantes.FEB))
				return CargaMasivaPCtasConstantes.FEBRERO;
			else if(mes.equals(CargaMasivaPCtasConstantes.MAR))
				return CargaMasivaPCtasConstantes.MARZO;
			else if(mes.equals(CargaMasivaPCtasConstantes.ABR))
				return CargaMasivaPCtasConstantes.ABRIL;
			else if(mes.equals(CargaMasivaPCtasConstantes.MAY))
				return CargaMasivaPCtasConstantes.MAYO;
			else if(mes.equals(CargaMasivaPCtasConstantes.JUN))
				return CargaMasivaPCtasConstantes.JUNIO;
			else if(mes.equals(CargaMasivaPCtasConstantes.JUL))
				return CargaMasivaPCtasConstantes.JULIO;
			else if(mes.equals(CargaMasivaPCtasConstantes.AGO))
				return CargaMasivaPCtasConstantes.AGOSTO;
			else if(mes.equals(CargaMasivaPCtasConstantes.SEP))
				return CargaMasivaPCtasConstantes.SEPTIEMBRE;
			else if(mes.equals(CargaMasivaPCtasConstantes.OCT))
				return CargaMasivaPCtasConstantes.OCTUBRE;
			else if(mes.equals(CargaMasivaPCtasConstantes.NOV))
				return CargaMasivaPCtasConstantes.NOVIEMBRE;
			else if(mes.equals(CargaMasivaPCtasConstantes.DIC))
				return CargaMasivaPCtasConstantes.DICIEMBRE;
			else
				return (byte) 0;
		} catch (Exception e) {
			e.printStackTrace();
			return (byte) 0;
		}
		
		
	}
	
	
	
}
