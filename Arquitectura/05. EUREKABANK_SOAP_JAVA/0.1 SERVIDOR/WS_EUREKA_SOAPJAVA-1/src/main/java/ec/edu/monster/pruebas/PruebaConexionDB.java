/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.db.AccesoDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class PruebaConexionDB {
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Prueba de conexion exitosa");
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
