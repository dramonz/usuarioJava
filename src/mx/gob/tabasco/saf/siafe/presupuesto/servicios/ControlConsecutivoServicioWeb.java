package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.io.Serializable;
import java.net.URL;

import javax.xml.namespace.QName;

import mx.gob.tabasco.saf.siafe.ws.servicios.impl.ControlConsecutivoServicoSEI;
import mx.gob.tabasco.saf.siafe.ws.servicios.impl.ControlConsecutivosServicioService;

import org.springframework.stereotype.Service;

@Service
public class ControlConsecutivoServicioWeb implements Serializable {

	private static final long serialVersionUID = -4046650050632785401L;

	private static final QName SERVICE_NAME = new QName(
			"http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/",
			"ControlConsecutivosServicioService");

	public Long obtieneCVE(String nombreEntidad) {
		URL wsdlURL = ControlConsecutivosServicioService.WSDL_LOCATION;
		ControlConsecutivosServicioService ss = new ControlConsecutivosServicioService(
				wsdlURL, SERVICE_NAME);
		ControlConsecutivoServicoSEI port = ss
				.getControlConsecutivosServicioPort();

		return port.obtieneCVE(nombreEntidad);
	}
	
	public Long obtieneID(String nombreEntidad) {
		URL wsdlURL = ControlConsecutivosServicioService.WSDL_LOCATION;
		ControlConsecutivosServicioService ss = new ControlConsecutivosServicioService(
				wsdlURL, SERVICE_NAME);
		ControlConsecutivoServicoSEI port = ss
				.getControlConsecutivosServicioPort();

		return port.obtieneID(nombreEntidad);
	}

}
