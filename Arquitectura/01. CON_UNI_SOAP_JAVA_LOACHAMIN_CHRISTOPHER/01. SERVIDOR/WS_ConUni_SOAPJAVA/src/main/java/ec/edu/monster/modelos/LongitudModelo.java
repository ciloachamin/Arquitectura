/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelos;

/**
 *
 * @author chris
 */
public class LongitudModelo {

    private double valor;
    private String unidadOrigen;
    private String unidadDestino;

    // Constructor
    public LongitudModelo(double valor, String unidadOrigen, String unidadDestino) {
        this.valor = valor;
        this.unidadOrigen = unidadOrigen;
        this.unidadDestino = unidadDestino;
    }

    // Getters y Setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidadOrigen() {
        return unidadOrigen;
    }

    public void setUnidadOrigen(String unidadOrigen) {
        this.unidadOrigen = unidadOrigen;
    }

    public String getUnidadDestino() {
        return unidadDestino;
    }

    public void setUnidadDestino(String unidadDestino) {
        this.unidadDestino = unidadDestino;
    }
}
