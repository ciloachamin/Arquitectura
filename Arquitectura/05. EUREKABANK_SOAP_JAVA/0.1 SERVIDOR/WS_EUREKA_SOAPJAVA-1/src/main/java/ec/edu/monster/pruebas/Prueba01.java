/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.modelos.LongitudModelo;
import ec.edu.monster.servicios.ConversorLongitudServicio;

/**
 *
 * @author chris
 */
public class Prueba01 {

    public static void main(String[] args) {

        double valor = 5;
        String unidadOrigen="metro";
        String unidadDestino="kilometro";

        ConversorLongitudServicio servicio = new ConversorLongitudServicio();
        LongitudModelo modelo =new LongitudModelo(valor, unidadOrigen, unidadDestino);
                System.out.println("modelo:" + modelo);
        double resultado = servicio.convertirLongitud(modelo);

        System.out.println("valor:" + valor);
        System.out.println("unidadOrigen:" + unidadOrigen);
        System.out.println("unidadDestino:" + unidadDestino);
        System.out.println("Resultado:" + resultado);
    }
}
