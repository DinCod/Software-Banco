package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.ClienteDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;

public class RegistrarClienteServicio {

    private GestorJDBC gestorJDBC;
    private ClienteDAOPostgre clienteDAOPostgre;

    public RegistrarClienteServicio() {
        gestorJDBC = new GestorDAOPostgre();
        clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);
    }
//metodo
    public int registrarCliente(Cliente cliente) throws Exception {

        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registrar = clienteDAOPostgre.registrarClienteDAO(cliente);
            gestorJDBC.terminarTransaccion();
            return registrar;
        }catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }
//metodo
    public int clienteExiste(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        int verificar = clienteDAOPostgre.elClienteExisteDAO(dni);
        gestorJDBC.cancelarTransaccion();
        return verificar;
    }
}
