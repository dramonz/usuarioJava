package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.sql.presupuesto.usuarios;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades.ConsultasSQLXmlFile;

import org.xml.sax.SAXException;

public class UsuariosConsultasSQLXml {
	
	public String consultas_usuarios;
	public String unidades;
	public String consulta_mapa_peticiones;
	public String consulta_catalogo_peticiones;
	public String consulta_tree_permisos;
	public String consulta_tree_by_cve_usuario;
	public String consulta_unidades_pertenece_cveUsuario;
	public String consulta_unidades_cveUsuario;
	public String catalogo_dependencia;
	public String consulta_proyecto_pertenece_cveUsuario;
	public String consulta_proyecto_cveUsuario;
	
	public UsuariosConsultasSQLXml(){
		try {
			ConsultasSQLXmlFile xmlFile = new ConsultasSQLXmlFile("presupuesto/usuario/UsuarioConsultaSQL.xml");
			consultas_usuarios 							= xmlFile.getQueryByName("consultas_usuarios");
			unidades									= xmlFile.getQueryByName("unidades");
			consulta_mapa_peticiones					= xmlFile.getQueryByName("consulta_mapa_peticiones");
			consulta_catalogo_peticiones				= xmlFile.getQueryByName("consulta_catalogo_peticiones");
			consulta_tree_permisos						= xmlFile.getQueryByName("consulta_tree_permisos");
			consulta_tree_by_cve_usuario				= xmlFile.getQueryByName("consulta_tree_by_cve_usuario");
			consulta_unidades_pertenece_cveUsuario 		= xmlFile.getQueryByName("consulta_unidades_pertenece_cveUsuario");
			consulta_unidades_cveUsuario				= xmlFile.getQueryByName("consulta_unidades_cveUsuario");
			catalogo_dependencia						= xmlFile.getQueryByName("catalogo_dependencia");
			consulta_proyecto_cveUsuario				= xmlFile.getQueryByName("consulta_proyecto_cveUsuario");
			consulta_proyecto_pertenece_cveUsuario		= xmlFile.getQueryByName("consulta_proyecto_pertenece_cveUsuario");
			
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
