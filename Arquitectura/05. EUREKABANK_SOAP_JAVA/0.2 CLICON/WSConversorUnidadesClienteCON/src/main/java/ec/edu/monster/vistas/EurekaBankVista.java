/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vistas;

import ec.edu.monster.servicios.EurekaBankServicio;
import ec.edu.monster.ws.Movimiento;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class EurekaBankVista {

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            EurekaBankServicio service = new EurekaBankServicio();

            System.out.println(" __  __                         _                 ");
            System.out.println("|  \\/  |   ___    _ __    ___  | |_    ___   _ __ ");
            System.out.println("| |\\/| |  / _ \\  | '_ \\  / __| | __|  / _ \\ | '__|");
            System.out.println("| |  | | | (_) | | | | | \\__ \\ | |_  |  __/ | |   ");
            System.out.println("|_|  |_|  \\___/  |_| |_| |___/  \\__|  \\___| |_|   ");
            System.out.println("                                                  ");

            int opcion;
            do {
                System.out.println("Menu:");
                System.out.println("1. Traer Movimientos");
                System.out.println("2. Registrar Depósito");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1: {
                        System.out.print("Ingrese el número de cuenta: ");
                        String cuenta = scanner.next();
                        List<Movimiento> movimientos = service.traerMovimientos(cuenta);
                        // Mostrar los movimientos en una tabla
                        System.out.println("Cuenta | NroMov | Fecha       | Tipo  | Accion  | Importe");
                        System.out.println("-----------------------------------------------------------");
                        for (Movimiento movimiento : movimientos) {
                            System.out.printf("%-7s| %-7s| %-12s| %-6s| %-8s| %.2f%n",
                                    movimiento.getCuenta(),
                                    movimiento.getNromov(),
                                    movimiento.getFecha(),
                                    movimiento.getTipo(),
                                    movimiento.getAccion(),
                                    movimiento.getImporte());
                        }
                    }
                    case 2: {
                        System.out.print("Ingrese el número de cuenta: ");
                        String cuenta = scanner.next();
                        System.out.print("Ingrese el importe del depósito: ");
                        double importe = scanner.nextDouble();
                        int resultado = service.regDeposito(cuenta, importe);
                        // Hacer algo con el resultado, por ejemplo, imprimirlo
                        System.out.println("Depósito registrado con éxito. ");
                    }
                    case 3:
                        System.out.println("Saliendo...");
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                }
            } while (opcion != 3);
        }
    }
}
