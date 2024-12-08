package ec.edu.monster.pruebas;

import ec.edu.monster.servicios.EurekaBankServicio;
import ec.edu.monster.ws.Movimiento;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author chris
 */
public class Prueba02 {

    public static void main(String[] args) {
        try {
            String cuenta = "00100001";
            EurekaBankServicio service = new EurekaBankServicio();
            List<Movimiento> lista = service.traerMovimientos(cuenta);
            System.out.println(lista);
            for (Movimiento r : lista) {
                System.out.println(r.getNromov() + " - " + r.getAccion() + " - " + r.getImporte());
            }

        } catch (Exception e) {
               System.out.println(e);
            e.printStackTrace();
        }
    }
}
