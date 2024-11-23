/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

/**
 *
 * @author chris
 */
public class LoginServicio {

    // Método que valida las credenciales con datos fijos
    public boolean validarCredenciales(String username, String password) {
        // Datos fijos para el login
        ec.edu.monster.ws.WSLogin_Service service = new ec.edu.monster.ws.WSLogin_Service();
        ec.edu.monster.ws.WSLogin port = service.getWSLoginPort();
        boolean result = port.login(username, password);
        // Validar si las credenciales coinciden con los datos fijos
        return result;
    }
}
