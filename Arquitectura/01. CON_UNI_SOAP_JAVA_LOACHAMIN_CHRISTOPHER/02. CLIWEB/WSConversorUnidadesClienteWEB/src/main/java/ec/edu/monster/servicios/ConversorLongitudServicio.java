/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

import ec.edu.monster.modelos.dtos.ConversionRequest;
import ec.edu.monster.modelos.dtos.ConversionResponse;

/**
 *
 * @author chris
 */
public class ConversorLongitudServicio {

    public ConversionResponse convertirLongitud(ConversionRequest request) {
        ec.edu.monster.ws.WSConversorLongitud_Service service = new ec.edu.monster.ws.WSConversorLongitud_Service();
        ec.edu.monster.ws.WSConversorLongitud port = service.getWSConversorLongitudPort();
        double result = port.convertirLongitud(request.getValor(), request.getUnidadOrigen(), request.getUnidadDestino());
        return new ConversionResponse(result);
    }
}
