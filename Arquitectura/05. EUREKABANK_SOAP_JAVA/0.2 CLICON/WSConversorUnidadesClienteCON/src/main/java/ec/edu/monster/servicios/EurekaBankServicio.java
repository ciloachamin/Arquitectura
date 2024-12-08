/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.servicios;

import ec.edu.monster.ws.Movimiento;

/**
 *
 * @author MJPC_
 */
public class EurekaBankServicio {

   /** public  int regDeposito(java.lang.String cuenta, double importe) {
        ec.edu.monster.ws.WSEureka_Service service = new ec.edu.monster.ws.WSEureka_Service();
        ec.edu.monster.ws.WSEureka port = service.getWSEurekaPort();
        return port.regDeposito(cuenta, importe);
     * @param cuenta}
     * @param importe
     * @return **/


    public int regDeposito(java.lang.String cuenta, double importe) {
        ec.edu.monster.ws.WSEureka_Service service = new ec.edu.monster.ws.WSEureka_Service();
        ec.edu.monster.ws.WSEureka port = service.getWSEurekaPort();
        return port.regDeposito(cuenta, importe);
    }
    

    public java.util.List<ec.edu.monster.ws.Movimiento> traerMovimientos(java.lang.String cuenta) {
        ec.edu.monster.ws.WSEureka_Service service = new ec.edu.monster.ws.WSEureka_Service();
        System.out.println(service);
        
        ec.edu.monster.ws.WSEureka port = service.getWSEurekaPort();
                System.out.println(port);
        java.util.List<ec.edu.monster.ws.Movimiento> result = port.traerMovimientos(cuenta);
        for (ec.edu.monster.ws.Movimiento r : result) {
            System.out.println(r.getNromov() + " - " + r.getAccion() + " - " + r.getImporte());
        }

        return result;
    }
    
}
