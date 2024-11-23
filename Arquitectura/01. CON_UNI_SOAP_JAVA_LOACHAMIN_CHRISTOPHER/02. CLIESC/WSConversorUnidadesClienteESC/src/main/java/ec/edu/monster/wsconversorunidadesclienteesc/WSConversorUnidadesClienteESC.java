/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.monster.wsconversorunidadesclienteesc;

import ec.edu.monster.controladores.LoginControlador;
import ec.edu.monster.servicios.LoginServicio;
import ec.edu.monster.vistas.LoginVista;

/**
 *
 * @author chris
 */
public class WSConversorUnidadesClienteESC {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // Instanciar la vista
            LoginVista loginVista = new LoginVista();

            // Instanciar el servicio
            LoginServicio loginServicio = new LoginServicio();

            // Instanciar el controlador
            LoginControlador loginControlador = new LoginControlador(loginVista, loginServicio);

            // Mostrar la ventana de inicio de sesión
            loginVista.setVisible(true);

        });
    }
}
