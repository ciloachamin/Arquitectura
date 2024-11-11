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
        String validUsername = "admin";
        String validPassword = "123456";

        // Validar si las credenciales coinciden con los datos fijos
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
