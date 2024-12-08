/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controladores;

import ec.edu.monster.servicios.EurekaBankServicio;
import ec.edu.monster.ws.Movimiento;
import java.util.List;

/**
 *
 * @author MJPC_
 */
public class EurekaControl {
    public List<Movimiento> traerMovimientos(String cuenta){
        EurekaBankServicio service=new EurekaBankServicio();
       return service.traerMovimientos(cuenta);
           
    }
      public int regDeposito(String cuenta,double importe){
        EurekaBankServicio service=new EurekaBankServicio();
       return service.regDeposito(cuenta,importe);
           
    }
   
}
