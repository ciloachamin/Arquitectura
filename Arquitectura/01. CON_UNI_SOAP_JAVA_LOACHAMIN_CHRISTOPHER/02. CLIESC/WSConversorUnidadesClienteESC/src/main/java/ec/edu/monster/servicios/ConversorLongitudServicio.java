/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

/**
 *
 * @author chris
 */
public class ConversorLongitudServicio {

    public double convertirLongitud(double valor, String unidadOrigen, String unidadDestino) {
        ec.edu.monster.ws.WSConversorLongitud_Service service = new ec.edu.monster.ws.WSConversorLongitud_Service();
        ec.edu.monster.ws.WSConversorLongitud port = service.getWSConversorLongitudPort();
        double result = port.convertirLongitud(valor, unidadOrigen, unidadDestino);
        System.out.println("Result = " + result);
        return result;
    }
}
