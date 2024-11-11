/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.monster.wsconversorunidadesclientecon;

import ec.edu.monster.controladores.ConversorLongitudControlador;
import ec.edu.monster.controladores.LoginControlador;
import ec.edu.monster.modelos.ConversorLongitudModelo;
import ec.edu.monster.vistas.ConversorLongitudVista;
import ec.edu.monster.vistas.LoginVista;

/**
 *
 * @author chris
 */
public class WSConversorUnidadesClienteCON {

    public static void main(String[] args) {
        // Crear objetos para el inicio de sesión
        LoginVista loginVista = new LoginVista();
        LoginControlador loginControlador = new LoginControlador(loginVista);
        
        // Iniciar sesión
        loginControlador.iniciarSesion();
        
        // Crear objetos para la conversión
        ConversorLongitudModelo modelo = new ConversorLongitudModelo();
        ConversorLongitudVista vista = new ConversorLongitudVista();
        ConversorLongitudControlador controlador = new ConversorLongitudControlador(modelo, vista);
        
        // Iniciar la conversión
        controlador.iniciar();
    }
}