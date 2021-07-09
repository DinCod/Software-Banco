
package com.banco.capa1_presentacion;

import com.banco.capa2_aplicacion.RenovarTarjetaServicio;
import com.banco.capa3_dominio.entidades.Tarjeta;
import java.awt.Color;
import javax.swing.JOptionPane;


public class FormRenovarTarjeta extends javax.swing.JFrame {

    private Tarjeta tarjeta; 
    
    public FormRenovarTarjeta() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
    }
    public void limpiar(){
        tarjeta= null;
        txtNumeroTarjeta.setText("");
        txtNumeroTarjeta.requestFocus();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRenovar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNumeroTarjeta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("RENOVAR TARJETA ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nº TARJETA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        btnRenovar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRenovar.setText("RENOVAR");
        btnRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRenovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 190, 30));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 90, -1));

        txtNumeroTarjeta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNumeroTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroTarjetaKeyTyped(evt);
            }
        });
        getContentPane().add(txtNumeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-Explorers.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarActionPerformed
    if(txtNumeroTarjeta.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Ingrese el Nº de la Tarjeta");
        
    }else{
        int numeroTarjeta= Integer.parseInt(txtNumeroTarjeta.getText());
        int renovar;
    try {
        RenovarTarjetaServicio renovarTarjetaServicio = new RenovarTarjetaServicio();
        tarjeta = renovarTarjetaServicio.buscarTarjeta(numeroTarjeta);
    if(tarjeta !=null){
        tarjeta.realizarRenovacionTarjeta();    
        renovar = renovarTarjetaServicio.renovarTarjeta(tarjeta);
        //JOptionPane.showMessageDialog(null,"si existe" + tarjeta.getTipoTarjeta() + "---" + tarjeta.getSaldo());
        JOptionPane.showMessageDialog(null,"La tarjeta fue Renovada" + "\n" 
            + tarjeta.getTipoTarjeta() + "\n" 
            + "La tarjeta vence el : "
            + tarjeta.getFechaExpiracion());    
        System.out.println(tarjeta.toString());
    }else{
        JOptionPane.showMessageDialog(null,"El Nº de la Tarjeta no existe");
    }
    limpiar();    
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
}

    }//GEN-LAST:event_btnRenovarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();  
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNumeroTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroTarjetaKeyTyped
       String patron_de_entrada = "0123456789";
       if (txtNumeroTarjeta.getText().length() == 6 || 
       !patron_de_entrada.contains(String.valueOf(evt.getKeyChar())))
       evt.consume();  
    }//GEN-LAST:event_txtNumeroTarjetaKeyTyped

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
            java.util.logging.Logger.getLogger(FormRenovarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRenovarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRenovarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRenovarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRenovarTarjeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRenovar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNumeroTarjeta;
    // End of variables declaration//GEN-END:variables
}
