package ec.edu.monster.controladores;

import java.util.concurrent.ExecutionException;

import ec.edu.monster.modelos.ConversorLongitudModelo;
import ec.edu.monster.servicios.ConversorLongitudServicio;

public class ConversorLongitudControlador {
    private final ConversorLongitudServicio conversorService;

    public ConversorLongitudControlador() {
        this.conversorService = new ConversorLongitudServicio();
    }

    public String convertirLongitud(double valor, String unidadOrigen, String unidadDestino) {
        ConversorLongitudModelo model = new ConversorLongitudModelo(valor, unidadOrigen, unidadDestino);
        try {
            return conversorService.convertirLongitud(model);
        } catch (ExecutionException | InterruptedException e) {
            return "Error al conectar con el servicio: " + e.getMessage();
        }
    }
}