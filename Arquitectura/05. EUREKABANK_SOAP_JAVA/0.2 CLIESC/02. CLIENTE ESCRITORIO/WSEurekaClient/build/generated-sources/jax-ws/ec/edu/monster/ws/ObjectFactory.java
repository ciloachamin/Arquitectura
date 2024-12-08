
package ec.edu.monster.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.monster.ws package. 
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

    private final static QName _Movimiento_QNAME = new QName("http://ws.monster.edu.ec/", "movimiento");
    private final static QName _RegDepósito_QNAME = new QName("http://ws.monster.edu.ec/", "regDep\u00f3sito");
    private final static QName _RegDepósitoResponse_QNAME = new QName("http://ws.monster.edu.ec/", "regDep\u00f3sitoResponse");
    private final static QName _TraerMovimientos_QNAME = new QName("http://ws.monster.edu.ec/", "traerMovimientos");
    private final static QName _TraerMovimientosResponse_QNAME = new QName("http://ws.monster.edu.ec/", "traerMovimientosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.monster.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movimiento }
     * 
     */
    public Movimiento createMovimiento() {
        return new Movimiento();
    }

    /**
     * Create an instance of {@link RegDepósito }
     * 
     */
    public RegDepósito createRegDepósito() {
        return new RegDepósito();
    }

    /**
     * Create an instance of {@link RegDepósitoResponse }
     * 
     */
    public RegDepósitoResponse createRegDepósitoResponse() {
        return new RegDepósitoResponse();
    }

    /**
     * Create an instance of {@link TraerMovimientos }
     * 
     */
    public TraerMovimientos createTraerMovimientos() {
        return new TraerMovimientos();
    }

    /**
     * Create an instance of {@link TraerMovimientosResponse }
     * 
     */
    public TraerMovimientosResponse createTraerMovimientosResponse() {
        return new TraerMovimientosResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movimiento }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Movimiento }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "movimiento")
    public JAXBElement<Movimiento> createMovimiento(Movimiento value) {
        return new JAXBElement<Movimiento>(_Movimiento_QNAME, Movimiento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegDepósito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegDepósito }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "regDep\u00f3sito")
    public JAXBElement<RegDepósito> createRegDepósito(RegDepósito value) {
        return new JAXBElement<RegDepósito>(_RegDepósito_QNAME, RegDepósito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegDepósitoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegDepósitoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "regDep\u00f3sitoResponse")
    public JAXBElement<RegDepósitoResponse> createRegDepósitoResponse(RegDepósitoResponse value) {
        return new JAXBElement<RegDepósitoResponse>(_RegDepósitoResponse_QNAME, RegDepósitoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerMovimientos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerMovimientos }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerMovimientos")
    public JAXBElement<TraerMovimientos> createTraerMovimientos(TraerMovimientos value) {
        return new JAXBElement<TraerMovimientos>(_TraerMovimientos_QNAME, TraerMovimientos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerMovimientosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerMovimientosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerMovimientosResponse")
    public JAXBElement<TraerMovimientosResponse> createTraerMovimientosResponse(TraerMovimientosResponse value) {
        return new JAXBElement<TraerMovimientosResponse>(_TraerMovimientosResponse_QNAME, TraerMovimientosResponse.class, null, value);
    }

}
