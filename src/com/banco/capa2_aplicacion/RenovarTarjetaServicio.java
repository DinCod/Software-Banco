package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.TarjetaDAOPostgre;


public class RenovarTarjetaServicio {
 
    private GestorJDBC gestorJDBC;
    private TarjetaDAOPostgre tarjetaDAOPostgre;
    private TarjetaDAOPostgre tarjetePostgre;

public  RenovarTarjetaServicio(){
    gestorJDBC = new GestorDAOPostgre();
    tarjetaDAOPostgre = new TarjetaDAOPostgre(gestorJDBC);
    tarjetePostgre = new TarjetaDAOPostgre (gestorJDBC);
    }


public int renovarTarjeta(Tarjeta tarjeta)throws Exception{
    gestorJDBC.abrirConexion();
    try {
    gestorJDBC.iniciarTransaccion();
    int renovar = tarjetaDAOPostgre.renovarTarjetaDAO(tarjeta);
    gestorJDBC.terminarTransaccion();
    return renovar;
    }catch (Exception e) {
    gestorJDBC.cancelarTransaccion();
    throw e;
   }
  }    

public Tarjeta buscarTarjeta(int numeroTarjeta) throws Exception {
    gestorJDBC.abrirConexion();
    Tarjeta tarjeta = tarjetePostgre.buscarNumeroTarjetaDAO(numeroTarjeta);
    gestorJDBC.cerrarConexion();
    return tarjeta;
    }

}
 