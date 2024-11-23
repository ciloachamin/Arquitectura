/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

/**
 *
 * @author chris
 */

import ec.edu.monster.ws.WSLogin;

public class PruebaLogin {

    public static void main(String[] args) {
        String usuario = "MONSTER";
        String contrasena = "MONSTER9";

        WSLogin servicioLogin = new WSLogin();
        boolean resultado = servicioLogin.login(usuario, contrasena);

        if (resultado) {
            System.out.println("Login exitoso: Bienvenido " + usuario);
        } else {
            System.out.println("Login fallido: Usuario o contraseña incorrectos.");
        }
    }
}

