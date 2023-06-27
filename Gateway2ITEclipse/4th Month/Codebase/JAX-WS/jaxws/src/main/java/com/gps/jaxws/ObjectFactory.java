
package com.gps.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gps.jaxws package. 
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

    private final static QName _BookServiceResponse_QNAME = new QName("http://jaxws.gps.com/bookService/", "BookServiceResponse");
    private final static QName _BookServiceRequest_QNAME = new QName("http://jaxws.gps.com/bookService/", "BookServiceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gps.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookServiceRequestType }
     * 
     */
    public BookServiceRequestType createBookServiceRequestType() {
        return new BookServiceRequestType();
    }

    /**
     * Create an instance of {@link BookServiceResponseType }
     * 
     */
    public BookServiceResponseType createBookServiceResponseType() {
        return new BookServiceResponseType();
    }

    /**
     * Create an instance of {@link BookType }
     * 
     */
    public BookType createBookType() {
        return new BookType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookServiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.gps.com/bookService/", name = "BookServiceResponse")
    public JAXBElement<BookServiceResponseType> createBookServiceResponse(BookServiceResponseType value) {
        return new JAXBElement<BookServiceResponseType>(_BookServiceResponse_QNAME, BookServiceResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookServiceRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.gps.com/bookService/", name = "BookServiceRequest")
    public JAXBElement<BookServiceRequestType> createBookServiceRequest(BookServiceRequestType value) {
        return new JAXBElement<BookServiceRequestType>(_BookServiceRequest_QNAME, BookServiceRequestType.class, null, value);
    }

}
