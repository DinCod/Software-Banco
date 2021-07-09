/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@AUTOR: ARAUJOJHON
 */
package com.banco.capa1_presentacion;

import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import java.awt.Frame;
import javax.swing.JTextArea;

public class Principal {

   /*
   1: RENOVAR TARJETA. / NO OBTIENE EL ID----------------YA ESTÁ 
    
   2: OBTENER EL SALDO DE LA TARJETA SEGÚN  LA BASE DE DATOS.
   3: CLIENTE - TOTAL DE TARJETAS = 2.
   4: SI LA TARJETA ES VENCIDA EL CLIENTE NO PUEDE HACER RETIRO/DEPOSITO 
    
   5: HACER QUE EN LA BASE DE DATOS SE "SUME O RESTE" EL SALDO, SEGÚN LA TRANSACCION = RETIRO/DEPOSITO------- YA ESTÁ 
   6: OBTENER EL ID DE LA TARJETA ORIGEN PARA HACER  TRANSACCION = FORM:TRANSACCIONES---------- YA ESTÁ 
   */
   public static void main(String[] args) throws Exception {
        
        FormMenu formMenu = new FormMenu();
        formMenu.setVisible(true);
   
        GestorDAOPostgre  gestor = new GestorDAOPostgre();
        gestor.abrirConexion();
    }
   
   private void frame(){
       JTextArea txtResultado = new javax.swing.JTextArea();
 txtResultado.setVisible(true);
txtResultado.setEditable(false);

txtResultado.setColumns(20);

txtResultado.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N

txtResultado.setRows(5);

txtResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    
    }
   
}
