package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.ClienteDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.TarjetaDAOPostgre;
/**
 *
 * @author Spider
 */
public class AgregarTarjetaServicio {
    private GestorJDBC gestorJDBC;
    private ClienteDAOPostgre  clienteDAOPostgre;
    private TarjetaDAOPostgre tarjetaDebitoDAOPostgre;
    private TarjetaDAOPostgre tarjetaCreditoDAOPostgre;
public AgregarTarjetaServicio () {
    gestorJDBC = new GestorDAOPostgre();
    clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);
    tarjetaDebitoDAOPostgre = new TarjetaDAOPostgre(gestorJDBC);
    tarjetaCreditoDAOPostgre = new TarjetaDAOPostgre(gestorJDBC);
    
} 
//metodo    
public Cliente buscarClientePorDni(String dni) throws Exception {
    gestorJDBC.abrirConexion();
    Cliente cliente = clienteDAOPostgre.buscarPorDniDAO(dni);
    gestorJDBC.cerrarConexion();
    return cliente;
    }
//metodo   
public int  agregarTarjeta(Tarjeta tarjeta) throws Exception {
    Cliente cliente = tarjeta.getCliente();
    if(!cliente.estaHabilitadoParaTarjeta()){
    throw  new Exception("EL CLIENTE TIENE CANTIDAD MAXIMA DE TARJETAS");
    }
    gestorJDBC.abrirConexion();
    try{
    gestorJDBC.iniciarTransaccion();
    int registroTarjeta = tarjetaDebitoDAOPostgre.agregarTarjetaDAO(tarjeta);
    gestorJDBC.terminarTransaccion();
    return registroTarjeta;
    }catch (Exception e) {
    gestorJDBC.cancelarTransaccion();
    throw e;    
  }
 }
}
