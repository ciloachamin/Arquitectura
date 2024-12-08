/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ec.edu.monster.servicios.AuthService;
/**
 *
 * @author chris
 */
@WebService(serviceName = "WSLogin")
public class WSLogin {

    private final AuthService authService = new AuthService();

    @WebMethod(operationName = "login")
    public boolean login(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena) {
        // Verificar credenciales con AuthService
        return authService.authenticate(usuario, contrasena);
    }
}