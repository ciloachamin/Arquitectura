/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.servicio.EurekaService;
import ec.edu.monster.ws.Movimiento;
import java.util.List;

/**
 *
 * @author leito
 */
public class PruebaDepósito {

    public static void main(String[] args) {
        try {
            String cuenta = "00100001";
            EurekaService service = new EurekaService();
            List<Movimiento> lista = service.traerMovimientos(cuenta);
            for (Movimiento r : lista) {
                System.out.println(r.getNromov() + " - " + r.getAccion() + " - " + r.getImporte());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
