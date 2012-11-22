package mx.gob.tabasco.saf.siafe.presupuesto.utilerias;

import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfiguracionWSUtil {

private static Properties PROPERTIES;
	
	private static Logger log = Logger.getLogger(ConfiguracionWSUtil.class);
	
	public static Properties getProperties() {
		if (null == PROPERTIES) {
			loadProperties();
		}
		
		return PROPERTIES;
	}
	
	private static void loadProperties() {
		try {
			PROPERTIES = new Properties();
			PROPERTIES.load(ConfiguracionWSUtil.class.getResourceAsStream("/ws.properties"));
		} catch (Exception e) {
			log.error("No se ha podido cargar ws.properties", e);
		}
	}
	
}
