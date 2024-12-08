/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;

import ec.edu.monster.db.AccesoDB;
import ec.edu.monster.ws.WSEureka_Service;
import ec.edu.monster.ws.Movimiento;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
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

     

    public List<Movimiento> traerMovimientos(String cuenta) {
        WSEureka_Service service = new WSEureka_Service();
        QName portQName = new QName("http://ws.monster.edu.ec/", "WSEurekaPort");
        String req = "<traerMovimientos xmlns=\"http://ws.monster.edu.ec/\"><cuenta>" + cuenta + "</cuenta></traerMovimientos>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
            // Process the result to extract List<Movimiento>
            // Dummy return for example purposes
            return new ArrayList<>(); // Replace with actual parsing logic
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public List<ec.edu.monster.modelo.Movimiento> leerMovimientos(String cuenta){
        Connection cn = null;
        List<ec.edu.monster.modelo.Movimiento> lista = new ArrayList<ec.edu.monster.modelo.Movimiento>();
        String sql = "SELECT \n"
                + " m.chr_cuencodigo cuenta, \n"
                + " m.int_movinumero nromov, \n"
                + " m.dtt_movifecha fecha, \n"
                + " t.vch_tipodescripcion tipo, \n"
                + " t.vch_tipoaccion accion, \n"
                + " m.dec_moviimporte importe \n"
                + "FROM tipomovimiento t INNER JOIN movimiento m \n"
                + "ON t.chr_tipocodigo = m.chr_tipocodigo \n"
                + "WHERE m.chr_cuencodigo = ?";
        
        try{
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                ec.edu.monster.modelo.Movimiento rec = new ec.edu.monster.modelo.Movimiento();
                rec.setCuenta(rs.getString("cuenta"));
                rec.setNromov(rs.getInt("nromov"));
                rec.setFecha(rs.getDate("fecha"));
                rec.setTipo(rs.getString("tipo"));
                rec.setAccion(rs.getString("accion"));
                rec.setImporte(rs.getDouble("importe"));
                
                lista.add(rec);
            }
            rs.close();

            
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                cn.close();
            } catch(Exception e){
            }
        }
        return lista;
    }
    
     public void registrarDeposito(String cuenta, double importe, String codEmp){
        Connection cn = null;
        try{
            //obtener la conexion
            cn= AccesoDB.getConnection();
            //habilitar la transaccion
            cn.setAutoCommit(false);
            //paso 1: leer datos de la cuenta
            String sql = "select dec_cuensaldo, int_cuencontmov "
                    + "from cuenta "
                    + "where chr_cuencodigo = ? and vch_cuenestado = 'ACTIVO'"
                    + "for update ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            ResultSet rs =pstm.executeQuery();
            if(!rs.next()){
                throw new SQLException("ERROR, cuenta no existe, o no esta activa");
            }
            double saldo = rs.getDouble("dec_cuensaldo");
            int cont = rs.getInt("int_cuencontmov");
            rs.close();
            pstm.close();
            //paso 2: actualizar la cuenta
            saldo += importe;
            cont++;
            sql = "update cuenta "
                    + "set dec_cuensaldo = ?, "
                    + "int_cuencontmov = ? "
                    + "where chr_cuencodigo = ? and vch_cuenestado = 'ACTIVO'";
            pstm = cn.prepareStatement(sql);
            pstm.setDouble(1, saldo);
            pstm.setInt(2, cont);
            pstm.setString(3, cuenta);
            pstm.executeUpdate();
            pstm.close();
            //paso 3: Registrar movimientos
            sql = "insert into movimiento(chr_cuencodigo,"
                    + "int_movinumero,dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
                    + "dec_moviimporte) values(?,?,SYSDATE(),?,'003',?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            pstm.setInt(2, cont);
            pstm.setString(3, codEmp);
            pstm.setDouble(4, importe);
            pstm.executeUpdate();
            //Confirmar transaccion
            cn.commit();
        }catch(SQLException e){
            try {
                cn.rollback();
            } catch (Exception el) {
            }
            throw new RuntimeException(e.getMessage());
        }catch(Exception e){
            try {
                cn.rollback();
            } catch (Exception el) {
            }
            throw new RuntimeException("ERROR, en el proceso registrar deposito, intentelo mas tarde.");
        }finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    public static int regDepósito(java.lang.String cuenta, double importe) {
        ec.edu.monster.ws.WSEureka_Service service = new ec.edu.monster.ws.WSEureka_Service();
        ec.edu.monster.ws.WSEureka port = service.getWSEurekaPort();
        return port.regDepósito(cuenta, importe);
    }
}
