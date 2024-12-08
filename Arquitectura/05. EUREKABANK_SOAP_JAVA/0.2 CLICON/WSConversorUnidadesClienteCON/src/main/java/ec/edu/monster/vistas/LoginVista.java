/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vistas;

/**
 *
 * @author chris
 */

import java.util.Scanner;

public class LoginVista {

    private Scanner scanner;

    public LoginVista() {
        scanner = new Scanner(System.in);
    }

    public String obtenerUsuario() {
        System.out.print("Ingresa tu nombre de usuario: ");
        return scanner.nextLine();
    }

    public String obtenerContraseña() {
        System.out.print("Ingresa tu contraseña: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
