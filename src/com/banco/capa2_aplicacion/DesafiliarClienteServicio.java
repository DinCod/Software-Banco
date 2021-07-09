/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.ClienteDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import javax.xml.transform.Source;

/**
 *
 * @author Spider
 */
public class DesafiliarClienteServicio {
   private GestorJDBC gestorJDBC;
   private ClienteDAOPostgre clienteDAOPostgre; 

public  DesafiliarClienteServicio () {
   gestorJDBC = new GestorDAOPostgre();
   clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);

}
//método buscar cliente por dni
public Cliente buscarClienteDNI(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAOPostgre.buscarPorDniDAO(dni);
        gestorJDBC.cerrarConexion();
        return cliente;
        
    }
//método desafiliar cliente por dni buscado
public int   desafiliarCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        //validar regla de necogio 
        try {
        gestorJDBC.iniciarTransaccion();
        int registro = clienteDAOPostgre.desafiliarClienteDAO(cliente);
        gestorJDBC.terminarTransaccion();
        return registro;
        } catch (Exception e) {
        gestorJDBC.cancelarTransaccion();
        throw e;
        }
} 

}
