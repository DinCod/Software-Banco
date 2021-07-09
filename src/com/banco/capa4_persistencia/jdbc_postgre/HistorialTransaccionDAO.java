/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa4_persistencia.jdbc_postgre;

import com.banco.capa3_dominio.entidades.Historial;
import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa3_dominio.entidades.Transaccion;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;


public class HistorialTransaccionDAO {
    
    
    GestorJDBC gestorJDBC;

    public HistorialTransaccionDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
   }
    
    
 public Tarjeta buscarHistorialTransaccion(int numeroTarjeta) throws SQLException {
        Tarjeta tarjeta = null;
        Transaccion transaccion = null;
        ResultSet resultadTarjeta;
        String sentenciaSQL;
        sentenciaSQL = "select  idtransaccion , tipotarjeta , numerotarjeta, saldoinicial , tipotransaccion, monto , saldoactual, fechatransaccion "
        + "from historialtransaccion where numerotarjeta= '" + numeroTarjeta + "'";
        resultadTarjeta = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadTarjeta.next()){            
           transaccion = new Transaccion();
           transaccion.setIdtransaccion(resultadTarjeta.getInt("idtransaccion"));
           //for tarjeta
           tarjeta = new Tarjeta();
           tarjeta.setTipoTarjeta(resultadTarjeta.getString("tipotarjeta"));
           tarjeta.setNumeroTarjeta(resultadTarjeta.getInt("numerotarjeta"));
           tarjeta.setSaldoInicial(resultadTarjeta.getDouble("saldoinicial"));
           //for transaccion
           transaccion.setTipoTransaccion(resultadTarjeta.getString("tipotransaccion"));
           transaccion.setMonto(resultadTarjeta.getDouble("monto"));
           tarjeta.setSaldoActual(resultadTarjeta.getDouble("saldoactual"));
           transaccion.setFechaTransaccion(resultadTarjeta.getDate("fechatransaccion"));
           //***************************************************************************
         }        
        resultadTarjeta.close();
        return tarjeta; 
    } 

 
 
  
 
 
 
 
 
 
 
 
 
}
