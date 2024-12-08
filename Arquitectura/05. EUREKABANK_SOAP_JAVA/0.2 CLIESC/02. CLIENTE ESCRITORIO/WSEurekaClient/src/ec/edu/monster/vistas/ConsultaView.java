/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vistas;

import ec.edu.monster.controlador.EurekaController;
import ec.edu.monster.servicio.EurekaService;
import ec.edu.monster.varios.Validar;
import ec.edu.monster.ws.Movimiento;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xabyc
 */
public class ConsultaView extends javax.swing.JFrame {

    Validar val = new Validar();
    public ConsultaView() {
        initComponents();
        val.validarNumeros(txtCuenta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reporte = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA DE MOVIMIENTOS");

        jLabel1.setText("CUENTA:");

        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CUENTA", "NROMOV", "FECHA", "TIPO", "ACCION", "IMPORTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reporte);

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnConsultar)
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //DATOS
//        String cuenta = txtCuenta.getText();
        
        //proceso
        //EurekaController control = new EurekaController();
//        List<Movimiento> lista = this.traerMovimientos(cuenta);
        
        //reporte
//        DefaultTableModel tabla = (DefaultTableModel) reporte.getModel();
//        
//        tabla.setRowCount(0);
//        for(Movimiento r : lista){
//            Object[] rowData = {
//                r.getCuenta(), r.getNromov(), r.getFecha(), r.getTipo(), r.getAccion(), r.getImporte()
//            };
//            tabla.addRow(rowData);
//        }
        
        try {
            //dato de la prueba
            String cuenta = txtCuenta.getText();
            
            //proceso
            EurekaService service =new EurekaService();
            List<ec.edu.monster.modelo.Movimiento> lista = service.leerMovimientos(cuenta);
            
            //reporte
            DefaultTableModel tabla = (DefaultTableModel) reporte.getModel();
            tabla.setRowCount(0);
            
            for(ec.edu.monster.modelo.Movimiento r : lista){
                Object[] rowData = {
                r.getCuenta(), r.getNromov(), r.getFecha(), r.getTipo(), r.getAccion(), r.getImporte()
                };
                tabla.addRow(rowData);
            }
//            for(ec.edu.monster.modelo.Movimiento r : lista){
//                System.out.println(r.getCuenta()+ " - " + r.getNromov()+ " - "+ r.getFecha()+ " - "+ r.getTipo()+ " - " + r.getAccion() + " - " + r.getImporte());
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reporte;
    private javax.swing.JTextField txtCuenta;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<ec.edu.monster.ws.Movimiento> traerMovimientos(java.lang.String cuenta) {
        ec.edu.monster.ws.WSEureka_Service service = new ec.edu.monster.ws.WSEureka_Service();
       ec.edu.monster.ws.WSEureka port = service.getWSEurekaPort();
        return port.traerMovimientos(cuenta);
    }
}
