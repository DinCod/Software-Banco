
package com.banco.capa1_presentacion;

import com.banco.capa2_aplicacion.AgregarTarjetaServicio;
import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa3_dominio.entidades.Tarjeta;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Spider
 */
public class FormAgregarTarjeta extends javax.swing.JFrame {
    private Cliente cliente ;
    private Tarjeta tarjeta;
    
    public FormAgregarTarjeta() {
    initComponents();
    
    combTarjeta.addItem("        SELECCIONE");
    combTarjeta.addItem("     TARJETA CRÉDITO");
    combTarjeta.addItem("     TARJETA DÉBITO"); 
    }
    public void iniciar(){
      txtSaldo.setText("");
      txtDni.requestFocus();
      txtDni.setText("");
      txtNombre.setText("");
      txtNumero.setText("");
      cliente= null;
      tarjeta= null;
      combTarjeta.setSelectedIndex(0);
    }
    private void activarMonto(){
      if(cliente != null)
      txtSaldo.setEnabled(true);
      else
      txtSaldo.setEnabled(false);
    }
    
    private void activarBotonAgregarTarjeta(){
      if(!txtSaldo.getText().isEmpty()){
      btnAgregarTarjeta.setEnabled(true);
      }else{
      btnAgregarTarjeta.setEnabled(false);
    }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnAgregarTarjeta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        btnbuscarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        combTarjeta = new javax.swing.JComboBox<>();
        txtNumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("AGREGAR TARJETA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DNI  CLIENTE ");

        txtDni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        btnAgregarTarjeta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarTarjeta.setText("AGREGAR TARJETA");
        btnAgregarTarjeta.setEnabled(false);
        btnAgregarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTarjetaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("SALDO");

        txtSaldo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldo.setEnabled(false);
        txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoKeyTyped(evt);
            }
        });

        btnbuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscarCliente.setText("BUSCAR");
        btnbuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NOMBRE");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nº DE TARJETA");

        combTarjeta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTarjetaActionPerformed(evt);
            }
        });

        txtNumero.setEditable(false);
        txtNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cardpayment_tarjet_3771.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnAgregarTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(69, 69, 69)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(32, 32, 32)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                                    .addComponent(txtNombre))
                                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnbuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(36, 36, 36)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(combTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(combTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarClienteActionPerformed
      String dni = txtDni.getText();
      try{
      AgregarTarjetaServicio agregarTarjeta = new AgregarTarjetaServicio();
      cliente = agregarTarjeta.buscarClientePorDni(txtDni.getText().trim());
         if(cliente != null){
         txtNombre.setText(cliente.getNombre());
         activarMonto();
         }else{
         if(txtDni.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Ingrese el DNI");
         //iniciar();
         }else{
         JOptionPane.showMessageDialog(this, "EL CLIENTE NO EXISTE");
        // iniciar();
         }
         iniciar(); 
         }
       }catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
     } 
    }//GEN-LAST:event_btnbuscarClienteActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDni.getText().length() == 8 || 
           !patron_de_entrada.contains(String.valueOf(evt.getKeyChar())))
           evt.consume(); 
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtSaldo.getText().length() == 4 || 
           !patron_de_entrada.contains(String.valueOf(evt.getKeyChar())))
           evt.consume();
    }//GEN-LAST:event_txtSaldoKeyTyped

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        if(cliente != null){
            cliente = null;
            txtNombre.setText("");
            txtSaldo.setEnabled(false);
            txtSaldo.setText("");
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void combTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTarjetaActionPerformed
           String opciones = (String)combTarjeta.getSelectedItem();
           String numeroTarjeta = ""+((int) (Math.random()*(99999-10000))+100000);
           txtNumero.setText(numeroTarjeta);  
           if(opciones.equals("        SELECCIONE")){
           txtNumero.setText("");
           }   
    }//GEN-LAST:event_combTarjetaActionPerformed

    private void btnAgregarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTarjetaActionPerformed
        String tipoTarjeta = combTarjeta.getSelectedItem().toString();
        int numeroTarjeta= Integer.parseInt(txtNumero.getText());
        double monto = Double.parseDouble(txtSaldo.getText());
        tarjeta = new Tarjeta (tipoTarjeta,numeroTarjeta,monto,cliente);
        tarjeta.TarjetaApertura(tarjeta);
        tarjeta.getFechaExpiracion();
        int agregarTarjeta;
        try {
            AgregarTarjetaServicio  agregartarTarjetaServicio = new  AgregarTarjetaServicio();
            agregarTarjeta=agregartarTarjetaServicio.agregarTarjeta(tarjeta);
            if(agregarTarjeta==1){
            JOptionPane.showMessageDialog(null,"Tarjeta Agregada");
            System.out.println(tarjeta.toString());
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        iniciar();
        activarMonto();
        activarBotonAgregarTarjeta();  
         
    }//GEN-LAST:event_btnAgregarTarjetaActionPerformed

    private void txtSaldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoKeyReleased
        activarBotonAgregarTarjeta();
    }//GEN-LAST:event_txtSaldoKeyReleased

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        
    }//GEN-LAST:event_txtNumeroActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgregarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgregarTarjeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTarjeta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnbuscarCliente;
    private javax.swing.JComboBox<String> combTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
