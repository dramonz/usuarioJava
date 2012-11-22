package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ConsultasSQLXmlFile {
	
	private static final String WEBINF = "WEB-INF";
	private static final String folderQuerys = "/sql-querys/";
	
	private final Logger log = Logger.getLogger(ConsultasSQLXmlFile.class);
	
	DocumentBuilderFactory docBuilderFactory;
	Document doc = null;
	
	public ConsultasSQLXmlFile(){
		
	}
	
	
	public ConsultasSQLXmlFile(String file_path) throws SAXException, IOException, ParserConfigurationException{
		docBuilderFactory = DocumentBuilderFactory.newInstance();
		
		
		//En algunos sistemas operativos los espacio los representa con %20 rompiendo la cadena del path
		String webinfopath = this.getWebInfPath().replace("%20", " ").replace("%23", "#");
		
		file_path = webinfopath + folderQuerys + file_path;
		
		log.debug(file_path);
		
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		doc = docBuilder.parse(new File( file_path ));
		
		doc.getDocumentElement().normalize();
		
		log.debug("El elemento raiz es: "+
				doc.getDocumentElement().getNodeName()
				);
	}
	
	
	
	public String getWebInfPath(){
		 
	    String filePath = "";
	 
	    URL url = (URL) ConsultasSQLXmlFile.class.getResource("ConsultasSQLXmlFile.class");
	    
	    String className = url.getFile();
	    
	 
	    filePath = className.substring(0,className.indexOf(WEBINF) + WEBINF.length());
	    return filePath;
	  }
	
	
	public String getQueryByName(String query_name){
		
		log.debug(query_name);
		
		
		
		NodeList listaquery = (NodeList) doc.getDocumentElement().getElementsByTagName(query_name);
		
		log.debug(listaquery.item(0).getTextContent());
		
		return	listaquery.item(0).getTextContent();
		
	}
}
