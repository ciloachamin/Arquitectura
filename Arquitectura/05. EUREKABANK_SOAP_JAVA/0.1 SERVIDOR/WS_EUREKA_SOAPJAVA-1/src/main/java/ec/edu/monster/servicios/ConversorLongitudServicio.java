/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

import ec.edu.monster.modelos.LongitudModelo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chris
 */
public class ConversorLongitudServicio {

    private static final Map<String, Double> UNIDADES = new HashMap<>();

    static {
        UNIDADES.put("metro", 1.0);
        UNIDADES.put("kilometro", 1000.0);
        UNIDADES.put("centimetro", 0.01);
        UNIDADES.put("milla", 1609.34);
    }

    public double convertirLongitud(LongitudModelo modelo) {
        try {
            String unidadOrigen = modelo.getUnidadOrigen();
            String unidadDestino = modelo.getUnidadDestino();

            // Validar unidades
            if (!UNIDADES.containsKey(unidadOrigen) || !UNIDADES.containsKey(unidadDestino)) {
                throw new IllegalArgumentException("Unidad no válida: " + unidadOrigen + " a " + unidadDestino);
            }

            // Conversión
            double valorEnMetros = modelo.getValor() * UNIDADES.get(unidadOrigen);
            return valorEnMetros / UNIDADES.get(unidadDestino);
        } catch (IllegalArgumentException e) {
            System.err.println("Error en conversión: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado durante la conversión de longitud", e);
        }
    }
}