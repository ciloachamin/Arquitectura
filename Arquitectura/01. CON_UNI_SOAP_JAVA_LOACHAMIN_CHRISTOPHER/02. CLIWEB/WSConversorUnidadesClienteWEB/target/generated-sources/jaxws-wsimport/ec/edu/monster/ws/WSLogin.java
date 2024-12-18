
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
@WebService(name = "WSLogin", targetNamespace = "http://ws.monster.edu.ec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSLogin {


    /**
     * 
     * @param usuario
     * @param contrasena
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://ws.monster.edu.ec/", className = "ec.edu.monster.ws.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://ws.monster.edu.ec/", className = "ec.edu.monster.ws.LoginResponse")
    public boolean login(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "contrasena", targetNamespace = "")
        String contrasena);

}
