/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa4_persistencia.jdbc_postgre;

import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa3_dominio.entidades.Transaccion;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Spider
 */
public class TarjetaDAOPostgre {
    
    GestorJDBC gestorJDBC;

    public TarjetaDAOPostgre (GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
        //Query
        public int renovarTarjetaDAO (Tarjeta tarjeta ) throws SQLException {
        String sentenciaSQL ="update tarjeta set fechaexpiracion = ? where idtarjeta = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1,tarjeta.getFechaExpiracion());
        sentencia.setInt(2,tarjeta.getIdTarjeta());
        
        return sentencia.executeUpdate();
        }
        //query for add account /agregar tipo tarjeta 
        public int agregarTarjetaDAO (Tarjeta tarjeta)throws SQLException{
        String sentenciaSQL = "insert into tarjeta(idcliente,fechaapertura,fechaexpiracion,tipotarjeta,numerotarjeta,saldoinicial,saldoactual)"
        + " values(?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1,tarjeta.getCliente().getIdCliente());
        sentencia.setDate(2, tarjeta.getFechaApertura());
        sentencia.setDate(3, tarjeta.getFechaExpiracion());
        sentencia.setString(4, tarjeta.getTipoTarjeta());
        sentencia.setInt(5, tarjeta.getNumeroTarjeta());
        sentencia.setDouble(6, tarjeta.getSaldoInicial());
        sentencia.setDouble(7, tarjeta.getSaldoActual());
        return  sentencia.executeUpdate();
        }
        
    public Tarjeta buscarNumeroTarjetaDAO(int numeroTarjeta) throws SQLException {
        Tarjeta tarjeta = null;
        ResultSet resultadoCliente;
        String sentenciaSQL;
        sentenciaSQL = "select  idtarjeta , idcliente , fechaapertura , fechaexpiracion , tipotarjeta , numerotarjeta , saldoinicial "
        + "from tarjeta where numerotarjeta= '" + numeroTarjeta + "'";
        resultadoCliente = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoCliente.next()){            
           tarjeta = new Tarjeta();
           tarjeta.setIdTarjeta(resultadoCliente.getInt("idTarjeta"));
           //For Client
           Cliente cliente = new Cliente();
           cliente.setIdCliente(resultadoCliente.getInt("idCliente"));
           tarjeta.setFechaApertura(resultadoCliente.getDate("fechaapertura"));
           tarjeta.setFechaExpiracion(resultadoCliente.getDate("fechaexpiracion"));
           tarjeta.setTipoTarjeta(resultadoCliente.getString("tipotarjeta"));
           tarjeta.setNumeroTarjeta(resultadoCliente.getInt("numerotarjeta"));
           tarjeta.setSaldoInicial(resultadoCliente.getDouble("saldoinicial"));
         }        
        resultadoCliente.close();
        return tarjeta; 
    }    
    }
