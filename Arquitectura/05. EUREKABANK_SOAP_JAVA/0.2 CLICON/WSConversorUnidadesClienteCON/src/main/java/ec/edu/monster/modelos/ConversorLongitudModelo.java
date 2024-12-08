/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelos;

import ec.edu.monster.servicios.ConversorLongitudServicio;

/**
 *
 * @author chris
 */
public class ConversorLongitudModelo {
    private double valor;
    private String unidadOrigen;
    private String unidadDestino;
    private double resultado;
    private ConversorLongitudServicio servicio;

    public ConversorLongitudModelo() {
        servicio = new ConversorLongitudServicio();
    }

    public void convertir() {
        resultado = servicio.convertirLongitud(valor, unidadOrigen, unidadDestino);
    }

    // Getters y setters
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getUnidadOrigen() { return unidadOrigen; }
    public void setUnidadOrigen(String unidadOrigen) { this.unidadOrigen = unidadOrigen; }

    public String getUnidadDestino() { return unidadDestino; }
    public void setUnidadDestino(String unidadDestino) { this.unidadDestino = unidadDestino; }

    public double getResultado() { return resultado; }
}
