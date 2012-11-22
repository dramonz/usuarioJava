package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeneradorContraseniaServicio {
	private final int DEFAULT_SIZE = 8;
	private Random rnd = new Random();
	private String DATA = "!$%&().?=/*+!$%&().?=/*+" + "234567892345678923456789"
			+ "abcdefghijkmnpqrstuvwxyz" + "ABCDEFGHJKLMNPQRSTUVWXYZ";

	String generarNueva() {
		return generarNueva(DEFAULT_SIZE);
	}

	String generarNueva(int size) {
		StringBuffer result = new StringBuffer();

		if (size != 0) {
			while (size > 0) {
				result.append(rnd.nextInt(DATA.length()));
				size--;
			}
		}
		return result.toString();
	}
}
