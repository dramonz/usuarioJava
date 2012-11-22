
package mx.gob.tabasco.saf.siafe.ws.servicios.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.gob.tabasco.saf.siafe.ws.servicios.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtieneCVE_QNAME = new QName("http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", "obtieneCVE");
    private final static QName _ObtieneCVEResponse_QNAME = new QName("http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", "obtieneCVEResponse");
    private final static QName _ObtieneID_QNAME = new QName("http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", "obtieneID");
    private final static QName _ObtieneIDResponse_QNAME = new QName("http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", "obtieneIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.gob.tabasco.saf.siafe.ws.servicios.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtieneID }
     * 
     */
    public ObtieneID createObtieneID() {
        return new ObtieneID();
    }

    /**
     * Create an instance of {@link ObtieneIDResponse }
     * 
     */
    public ObtieneIDResponse createObtieneIDResponse() {
        return new ObtieneIDResponse();
    }

    /**
     * Create an instance of {@link ObtieneCVE }
     * 
     */
    public ObtieneCVE createObtieneCVE() {
        return new ObtieneCVE();
    }

    /**
     * Create an instance of {@link ObtieneCVEResponse }
     * 
     */
    public ObtieneCVEResponse createObtieneCVEResponse() {
        return new ObtieneCVEResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtieneCVE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", name = "obtieneCVE")
    public JAXBElement<ObtieneCVE> createObtieneCVE(ObtieneCVE value) {
        return new JAXBElement<ObtieneCVE>(_ObtieneCVE_QNAME, ObtieneCVE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtieneCVEResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", name = "obtieneCVEResponse")
    public JAXBElement<ObtieneCVEResponse> createObtieneCVEResponse(ObtieneCVEResponse value) {
        return new JAXBElement<ObtieneCVEResponse>(_ObtieneCVEResponse_QNAME, ObtieneCVEResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtieneID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", name = "obtieneID")
    public JAXBElement<ObtieneID> createObtieneID(ObtieneID value) {
        return new JAXBElement<ObtieneID>(_ObtieneID_QNAME, ObtieneID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtieneIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.servicios.ws.siafe.saf.tabasco.gob.mx/", name = "obtieneIDResponse")
    public JAXBElement<ObtieneIDResponse> createObtieneIDResponse(ObtieneIDResponse value) {
        return new JAXBElement<ObtieneIDResponse>(_ObtieneIDResponse_QNAME, ObtieneIDResponse.class, null, value);
    }

}
