/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;

import ec.edu.monster.modelos.Movimiento;
import ec.edu.monster.servicios.EurekaService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebResult;

/**
 *
 * @author chris
 */
@WebService(serviceName = "WSEureka")
public class WSEureka {

    private final EurekaService service = new EurekaService();

    /**
     * Web service operation
     *
     * @param cuenta
     * @return Retorna la lista de movimientos de una cuenta
     */
    @WebMethod(operationName = "traerMovimientos")
    public List<Movimiento> traerMovimientos(@WebParam(name = "cuenta") String cuenta) {
        List<Movimiento> lista;

        //proceso
        try {
            //recuperar moviemintos
            System.out.println("Error al recuperar movimientos: " + cuenta);
            lista = service.leerMovimiento(cuenta);
            System.out.println("Error al recuperar movimientos: " + lista);
        } catch (Exception e) {
            System.out.println("Error al recuperar movimientos: " + e.getMessage());
            e.printStackTrace(); // 
            //en caso de error, retorne una lista vacia
            lista = new ArrayList<>();
        }

        //retorno
        return lista;
    }

    /**
     * Web service operation
     *
     * @param cuenta
     * @param importe
     * @return Estado, 1 o -1
     */
    @WebMethod(operationName = "regDeposito")
    @WebResult(name = "estado")
    public int regDeposito(@WebParam(name = "cuenta") String cuenta, @WebParam(name = "importe") double importe) {
        int estado;

        //proceso
        String codEmp = "0001";
        try {
            EurekaService service = new EurekaService();
            service.registrarDeposito(cuenta, importe, codEmp);
            estado = 1;
        } catch (Exception e) {
            estado = -1;
        }

        //retorno
        return estado;
    }
}
