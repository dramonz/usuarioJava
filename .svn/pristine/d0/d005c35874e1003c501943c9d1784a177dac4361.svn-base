package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.sql.catalogos;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultasSQLXmlFile;

@Repository
public class CombosDataSQLXml {

	public String unidades;
	public String roles;
	public String empleados;
	
	public CombosDataSQLXml(){
		this.load();
	}
	
	
	
	public void load() {
		
		try {
			
			ConsultasSQLXmlFile xml = new ConsultasSQLXmlFile("catalogos/combosData.xml");
			
			
			this.unidades 			= xml.getQueryByName("unidades");
			this.roles 				= xml.getQueryByName("roles");
			this.empleados			=xml.getQueryByName("empleados");
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
}
