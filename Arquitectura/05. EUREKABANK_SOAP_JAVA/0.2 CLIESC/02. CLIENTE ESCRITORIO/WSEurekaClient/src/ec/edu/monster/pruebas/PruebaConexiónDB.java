package ec.edu.monster.pruebas;

import ec.edu.monster.db.AccesoDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author leito
 */
public class PruebaConexiónDB {
    
    public static void main(String[] args) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            if (cn != null && !cn.isClosed()) {
                System.out.println("Prueba de conexion exitosa");
            } else {
                System.out.println("No se pudo establecer la conexion");
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar conectar a la base de datos:");
            e.printStackTrace();
        } finally {
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.close();
                    System.out.println("Conexion cerrada exitosamente");
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion:");
                e.printStackTrace();
            }
        }
    }
}