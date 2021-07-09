 
package com.banco.capa4_persistencia.jdbc_postgre;

import com.banco.capa3_dominio.entidades.Cliente;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ClienteDAOPostgre {
    GestorJDBC gestorJDBC;
    public ClienteDAOPostgre(GestorJDBC gestorJDBC) {
    this.gestorJDBC = gestorJDBC;
    }
    //Query 
    public int registrarClienteDAO (Cliente  cliente) throws SQLException {
        String sentenciaSQL = "insert into cliente (dni,apellido,nombre) "
                + "values(?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cliente.getDni());
        sentencia.setString(2, cliente.getApellido());
        sentencia.setString(3, cliente.getNombre());
        return sentencia.executeUpdate();
    }
    //Query
    public int desafiliarClienteDAO(Cliente cliente ) throws SQLException {
        String sentenciaSQL = "delete from cliente where idcliente = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, cliente.getIdCliente());
        return sentencia.executeUpdate();
    }
    //query
    public Cliente buscarPorDniDAO(String dni) throws SQLException {
        Cliente cliente = null;
        ResultSet resultadoCliente;
        String sentenciaSQL;
        sentenciaSQL = "select  idcliente , dni , apellido , nombre "
        + "from cliente where dni = '" + dni + "'";
        resultadoCliente = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoCliente.next()){            
           cliente = new Cliente();
           cliente.setIdCliente(resultadoCliente.getInt("idCliente"));
           cliente.setDni(resultadoCliente.getString("dni"));
           cliente.setApellido(resultadoCliente.getString("apellido"));
           cliente.setNombre(resultadoCliente.getString("nombre"));
        }        
        resultadoCliente.close();
        return cliente; 
    }
    //query
    public int elClienteExisteDAO (String dni)throws SQLException{
       
        ResultSet rs = null; 
        String sentenciaSQL= "SELECT COUNT(*) FROM cliente WHERE dni = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        try {
        sentencia.setString(1, dni);
        rs=sentencia.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 1 ; 
        
        } catch (Exception e) {
            
    }
        return 1;
    }
}
   

