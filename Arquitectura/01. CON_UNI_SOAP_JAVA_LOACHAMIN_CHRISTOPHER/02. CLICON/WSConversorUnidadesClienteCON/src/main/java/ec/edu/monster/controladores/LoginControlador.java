/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controladores;

/**
 *
 * @author chris
 */
import ec.edu.monster.servicios.LoginServicio;
import ec.edu.monster.vistas.LoginVista;

public class LoginControlador {

    private LoginVista vista;
    private boolean resultado;
    private LoginServicio servicio;

    public LoginControlador(LoginVista vista) {
        this.vista = vista;
    }

    public boolean autenticarUsuario(String usuario, String contraseña) {
        // Aquí deberías realizar la validación contra una base de datos o un sistema de autenticación
        // Para este ejemplo, validamos con un usuario y contraseña fijos:
         servicio = new LoginServicio();
        resultado = servicio.validarCredenciales(usuario,contraseña);
        return resultado;
    }

    public void iniciarSesion() {
        boolean autentificado = false;

        while (!autentificado) {
            String usuario = vista.obtenerUsuario();
            String contraseña = vista.obtenerContraseña();

            if (autenticarUsuario(usuario, contraseña)) {
                vista.mostrarMensaje("Inicio de sesión exitoso.");
                autentificado = true;
            } else {
                vista.mostrarMensaje("Credenciales incorrectas. Intenta nuevamente.");
            }
        }
    }
}
