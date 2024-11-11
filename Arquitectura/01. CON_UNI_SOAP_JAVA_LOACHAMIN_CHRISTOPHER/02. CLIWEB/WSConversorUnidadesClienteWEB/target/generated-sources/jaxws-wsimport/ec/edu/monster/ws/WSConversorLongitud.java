
package ec.edu.monster.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "WSConversorLongitud", targetNamespace = "http://ws.monster.edu.ec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSConversorLongitud {


    /**
     * 
     * @param unidadDestino
     * @param unidadOrigen
     * @param valor
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "convertirLongitud", targetNamespace = "http://ws.monster.edu.ec/", className = "ec.edu.monster.ws.ConvertirLongitud")
    @ResponseWrapper(localName = "convertirLongitudResponse", targetNamespace = "http://ws.monster.edu.ec/", className = "ec.edu.monster.ws.ConvertirLongitudResponse")
    public double convertirLongitud(
        @WebParam(name = "valor", targetNamespace = "")
        double valor,
        @WebParam(name = "unidadOrigen", targetNamespace = "")
        String unidadOrigen,
        @WebParam(name = "unidadDestino", targetNamespace = "")
        String unidadDestino);

}