/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;

import ec.edu.monster.modelos.LongitudModelo;
import ec.edu.monster.servicios.ConversorLongitudServicio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author chris
 */
@WebService(serviceName = "WSConversorLongitud")
public class WSConversorLongitud {

    
    @WebMethod(operationName = "convertirLongitud")
    public double convertirLongitud(@WebParam(name = "valor") double valor,
            @WebParam(name = "unidadOrigen") String unidadOrigen,
            @WebParam(name = "unidadDestino") String unidadDestino) {

        ConversorLongitudServicio servicio = new ConversorLongitudServicio();
        LongitudModelo modelo = new LongitudModelo(valor, unidadOrigen, unidadDestino);
        double resultado = servicio.convertirLongitud(modelo);
        return resultado;
    }

}
