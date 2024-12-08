/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vistas;

import java.util.Scanner;

/**
 *
 * @author chris
 */
public class ConversorLongitudVista {

    private Scanner scanner;

    public ConversorLongitudVista() {
        scanner = new Scanner(System.in);
    }

    public double obtenerValor() {
        System.out.print("Ingresa el valor a convertir: ");
        return scanner.nextDouble();
    }

    public String obtenerUnidadOrigen() {
        System.out.print("Ingresa la unidad de origen (ej: metro): ");
        return scanner.next();
    }

    public String obtenerUnidadDestino() {
        System.out.print("Ingresa la unidad de destino (ej: kilometro): ");
        return scanner.next();
    }

    public void mostrarResultado(double resultado) {
        System.out.println("Resultado de la conversión: " + resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
