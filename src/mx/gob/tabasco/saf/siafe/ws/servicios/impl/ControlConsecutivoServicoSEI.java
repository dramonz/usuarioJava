package mx.gob.tabasco.saf.siafe.ws.servicios.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-04-13T13:59:37.447-05:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", name = "ControlConsecutivoServicoSEI")
@XmlSeeAlso({ObjectFactory.class})
public interface ControlConsecutivoServicoSEI {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtieneID", targetNamespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", className = "mx.gob.tabasco.saf.siafe.ws.servicios.impl.ObtieneID")
    @WebMethod
    @ResponseWrapper(localName = "obtieneIDResponse", targetNamespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", className = "mx.gob.tabasco.saf.siafe.ws.servicios.impl.ObtieneIDResponse")
    public java.lang.Long obtieneID(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtieneCVE", targetNamespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", className = "mx.gob.tabasco.saf.siafe.ws.servicios.impl.ObtieneCVE")
    @WebMethod
    @ResponseWrapper(localName = "obtieneCVEResponse", targetNamespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", className = "mx.gob.tabasco.saf.siafe.ws.servicios.impl.ObtieneCVEResponse")
    public java.lang.Long obtieneCVE(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
