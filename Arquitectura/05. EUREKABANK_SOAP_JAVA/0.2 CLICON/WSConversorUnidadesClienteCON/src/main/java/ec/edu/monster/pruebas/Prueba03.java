/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.servicios.EurekaBankServicio;

/**
 *
 * @author chris
 */
public class Prueba03 {

    public static void main(String[] args) {
        try {
            String cuenta = "00100001";
            double importe = 200;
            String codEmp = "0001";
            EurekaBankServicio service = new EurekaBankServicio();
            service.regDeposito(cuenta, importe);
            System.out.println("Proceso ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
