/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Historial;
import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.HistorialTransaccionDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Spider
 */
public class HistorialTransaccionServicio {
    private GestorJDBC gestorJDBC;
    private HistorialTransaccionDAO historial;

    public HistorialTransaccionServicio() {
        gestorJDBC = new GestorDAOPostgre();
        historial = new  HistorialTransaccionDAO(gestorJDBC);
    }
    
   public Tarjeta buscarHistorialTransaccion(int numeroTarjeta) throws Exception {
    gestorJDBC.abrirConexion();
    Tarjeta tarjeta = historial.buscarHistorialTransaccion(numeroTarjeta);
    gestorJDBC.cerrarConexion();
    return tarjeta;
    }
 
   
}
