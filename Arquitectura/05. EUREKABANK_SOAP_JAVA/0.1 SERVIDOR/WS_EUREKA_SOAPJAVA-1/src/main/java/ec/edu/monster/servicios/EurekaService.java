/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

import ec.edu.monster.db.AccesoDB;
import ec.edu.monster.modelos.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leito
 */
public class EurekaService {

    public List<Movimiento> leerMovimiento(String cuenta) {
        Connection cn = null;
        List<Movimiento> lista = new ArrayList<Movimiento>();
        String sql = "SELECT \n"
                + " m.chr_cuencodigo cuenta, \n"
                + " m.int_movinumero nromov, \n"
                + " m.dtt_movifecha fecha, \n"
                + " t.vch_tipodescripcion tipo, \n"
                + " t.vch_tipoaccion accion, \n"
                + " m.dec_moviimporte importe \n"
                + "FROM tipomovimiento t INNER JOIN movimiento m \n"
                + "ON t.chr_tipocodigo = m.chr_tipocodigo \n"
                + "WHERE m.chr_cuencodigo = ? "
                + "order by 2";
        try {
            cn = AccesoDB.getConnection();

            System.out.println("Conexxion cn : " + cn);
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            ResultSet rs = pstm.executeQuery();

            System.out.println("Conexxion cn : " + rs);
            while (rs.next()) {
                Movimiento rec = new Movimiento();
                rec.setCuenta(rs.getString("cuenta"));
                rec.setNromov(rs.getInt("nromov"));
                rec.setFecha(rs.getDate("fecha"));
                rec.setTipo(rs.getString("tipo"));
                rec.setAccion(rs.getString("accion"));
                rec.setImporte(rs.getDouble("importe"));
                lista.add(rec);
                System.out.println("Conexxion cn : " + rec);
            }

            rs.close();
        } catch (SQLException e) {

            System.out.println("Conexxion cn : " + e);
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {

                System.out.println("Conexxion cn : " + e);

            }
        }
        return lista;

    }

    public void registrarDeposito(String cuenta, double importe, String codEmp) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String sql = "select dec_cuensaldo, int_cuencontmov "
                    + "from cuenta "
                    + "where chr_cuencodigo = ? and vch_cuenestado = 'ACTIVO'"
                    + " for update";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Error, cuenta no existe o no esta activa");
            }
            double saldo = rs.getDouble("dec_cuensaldo");
            int cont = rs.getInt("int_cuencontmov");
            rs.close();
            pstm.close();
            saldo += importe;
            cont++;
            sql = "update cuenta "
                    + "set dec_cuensaldo = ?, "
                    + "int_cuencontmov = ? "
                    + "where chr_cuencodigo = ? and vch_cuenestado='ACTIVO'";
            pstm = cn.prepareStatement(sql);
            pstm.setDouble(1, saldo);
            pstm.setInt(2, cont);
            pstm.setString(3, cuenta);
            pstm.executeUpdate();
            pstm.close();
            sql = "insert into movimiento(chr_cuencodigo,"
                    + "int_movinumero, dtt_movifecha, chr_emplcodigo, chr_tipocodigo,"
                    + "dec_moviimporte) values(?,?,SYSDATE(),?,'003',?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            pstm.setInt(2, cont);
            pstm.setString(3, codEmp);
            pstm.setDouble(4, importe);
            pstm.executeUpdate();
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso registrar deposito, intentelo de nuevo mas tarde");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {

            }
        }
    }

}
