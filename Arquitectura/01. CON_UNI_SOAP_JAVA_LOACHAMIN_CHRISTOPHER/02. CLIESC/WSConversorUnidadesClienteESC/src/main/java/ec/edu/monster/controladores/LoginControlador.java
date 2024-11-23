/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author chris
 */
package ec.edu.monster.controladores;

import ec.edu.monster.servicios.ConversorLongitudServicio;
import ec.edu.monster.servicios.LoginServicio;
import ec.edu.monster.vistas.ConversorLongitudVista;
import ec.edu.monster.vistas.LoginVista;
import javax.swing.JOptionPane;

/**
 * Controlador para manejar la lógica del inicio de sesión.
 */
public class LoginControlador {

    private final LoginVista loginVista;
    private final LoginServicio loginServicio;

    /**
     * Constructor del controlador.
     *
     * @param loginVista Vista del login.
     * @param loginServicio Servicio para validar credenciales.
     */
    public LoginControlador(LoginVista loginVista, LoginServicio loginServicio) {
        this.loginVista = loginVista;
        this.loginServicio = loginServicio;
        initListeners();
    }

    /**
     * Inicializa los listeners de los botones de la vista.
     */
    private void initListeners() {
        loginVista.getBtnLogin().addActionListener(e -> handleLogin());
    }

    /**
     * Maneja la acción de inicio de sesión.
     */
    private void handleLogin() {
        // Obtener las credenciales ingresadas
        String username = loginVista.getTxtUser().getText();
        String password = new String(loginVista.getTxtPassword().getPassword());

        // Validar credenciales usando el servicio
        boolean isValid = loginServicio.validarCredenciales(username, password);

        if (isValid) {
            // Si las credenciales son válidas, mostrar éxito y abrir nueva ventana
            JOptionPane.showMessageDialog(loginVista, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Abrir nueva ventana (ajusta esto según tu aplicación)
            // Por ejemplo: ConversorLongitudVista
            // ConversorLongitudVista conversorUnidadesVista = new ConversorLongitudVista();
            // conversorUnidadesVista.setVisible(true);
            // Abre la ventana principal (por ejemplo, `ConversorLongitudVista`)
            ConversorLongitudVista conversorUnidadesVista = new ConversorLongitudVista();
            ConversorLongitudServicio servicio = new ConversorLongitudServicio();
            ConversorControlador controlador = new ConversorControlador(conversorUnidadesVista, servicio);
            conversorUnidadesVista.setVisible(true);

            // Cierra la ventana de inicio de sesión
            loginVista.dispose();

            // Cerrar ventana actual
            loginVista.dispose();
        } else {
            // Si las credenciales son incorrectas, mostrar error
            JOptionPane.showMessageDialog(loginVista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
