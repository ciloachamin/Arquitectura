/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.servicio.EurekaService;
import ec.edu.monster.ws.Movimiento;
import java.util.List;

/**
 *
 * @author leito
 */
public class EurekaController {

    
    public List<Movimiento> traerMovimientos(String cuenta) {
        EurekaService service = new EurekaService();
        return service.traerMovimientos(cuenta);
    }

    public int regDeposito(String cuenta, double importe) {
        EurekaService service = new EurekaService();
        return service.regDepósito(cuenta, importe);
    }
    
}

