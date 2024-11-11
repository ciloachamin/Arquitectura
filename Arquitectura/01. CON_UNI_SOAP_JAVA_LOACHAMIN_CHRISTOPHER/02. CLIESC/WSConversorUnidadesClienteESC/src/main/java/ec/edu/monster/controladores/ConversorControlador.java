package ec.edu.monster.controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author chris
 */
import ec.edu.monster.servicios.ConversorLongitudServicio;
import ec.edu.monster.vistas.ConversorLongitudVista;
import javax.swing.JOptionPane;

public class ConversorControlador {

    private ConversorLongitudVista vista;
    private ConversorLongitudServicio servicio;

    public ConversorControlador(ConversorLongitudVista vista, ConversorLongitudServicio servicio) {
        this.vista = vista;
        this.servicio = servicio;
        initController();
    }

    private void initController() {
        // Asignamos el evento del botón "convertir" al controlador
        vista.getConvertirButton().addActionListener(e -> convertirLongitud());
    }

    private void convertirLongitud() {
        try {
            double valor = Double.parseDouble(vista.getValorField().getText());
            String unidadOrigen = vista.getUnidadOrigenBox().getSelectedItem().toString();
            String unidadDestino = vista.getUnidadDestinoBox().getSelectedItem().toString();

            // Llamamos al servicio para realizar la conversión
            double resultado = servicio.convertirLongitud(valor, unidadOrigen, unidadDestino);

            // Mostramos el resultado en la etiqueta de la vista
            vista.getResultadoLabel().setText("Resultado: " + resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error en la conversión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
