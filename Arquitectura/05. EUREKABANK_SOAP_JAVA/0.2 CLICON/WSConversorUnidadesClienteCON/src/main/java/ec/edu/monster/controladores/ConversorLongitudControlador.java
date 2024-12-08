/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controladores;

import ec.edu.monster.modelos.ConversorLongitudModelo;
import ec.edu.monster.vistas.ConversorLongitudVista;

/**
 *
 * @author chris
 */
public class ConversorLongitudControlador {

    private ConversorLongitudModelo modelo;
    private ConversorLongitudVista vista;

    public ConversorLongitudControlador(ConversorLongitudModelo modelo, ConversorLongitudVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            try {
                // Mostrar el menú de opciones
                vista.mostrarMensaje("Conversor de Longitud");
                vista.mostrarMensaje("Ingrese los valores para la conversión o presione 0 en cualquier momento para salir.");

                // Obtener datos de la vista
                double valor = vista.obtenerValor();

                if (valor == 0) {
                    continuar = false;
                    vista.mostrarMensaje("Saliendo de la aplicación...");
                    break;
                }

                String unidadOrigen = vista.obtenerUnidadOrigen();

                if (unidadOrigen.equals("0")) {
                    continuar = false;
                    vista.mostrarMensaje("Saliendo de la aplicación...");
                    break;
                }

                String unidadDestino = vista.obtenerUnidadDestino();

                if (unidadDestino.equals("0")) {
                    continuar = false;
                    vista.mostrarMensaje("Saliendo de la aplicación...");
                    break;
                }

                // Configurar el modelo con los datos ingresados
                modelo.setValor(valor);
                modelo.setUnidadOrigen(unidadOrigen);
                modelo.setUnidadDestino(unidadDestino);

                // Realizar la conversión
                modelo.convertir();

                // Mostrar resultado
                vista.mostrarResultado(modelo.getResultado());

            } catch (Exception e) {
                vista.mostrarMensaje("Error en la conversión: " + e.getMessage());
                vista.mostrarMensaje("Por favor, intente de nuevo.");
            }
        }
    }
}
