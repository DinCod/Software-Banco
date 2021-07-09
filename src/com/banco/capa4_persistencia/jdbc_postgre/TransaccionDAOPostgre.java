




package com.banco.capa4_persistencia.jdbc_postgre;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.banco.capa3_dominio.entidades.*;



public class TransaccionDAOPostgre {
   
    GestorJDBC gestorJDBC;
public TransaccionDAOPostgre (GestorJDBC gestorJDBC) {
    this.gestorJDBC = gestorJDBC;
    }    

//obtener el id de la tarjeta...........................................
public int depositoDAO (Transaccion transaccion)throws SQLException {
    String sentenciaSQL = "insert into transaccion(idtarjeta,tipotransaccion,fechatransaccion,monto,tarjetaorigen,tarjetadestino) "
                + " values(?,?,?,?,?,?)";
    PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
    sentencia.setInt(1, transaccion.getTarjeta().getIdTarjeta());
    sentencia.setString(2, transaccion.getTipoTransaccion());
    sentencia.setDate(3, transaccion.getFechaTransaccion());
    sentencia.setDouble(4, transaccion.getMonto());
    sentencia.setInt(5, transaccion.getTarjetaOrigen());
    sentencia.setInt(6, transaccion.getTarjetaDestino());
    return sentencia.executeUpdate();
}

public int retiroDAO (Transaccion transaccion)throws SQLException {
    String sentenciaSQL = "insert into transaccion(idtarjeta,tipotransaccion,fechatransaccion,monto,tarjetaorigen ) "
                + " values(?,?,?,?,?)";
    PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
    sentencia.setInt(1, transaccion.getTarjeta().getIdTarjeta());
    sentencia.setString(2, transaccion.getTipoTransaccion());
    sentencia.setDate(3, transaccion.getFechaTransaccion());
    sentencia.setDouble(4, transaccion.getMonto());
    sentencia.setInt(5, transaccion.getTarjetaOrigen());
    return sentencia.executeUpdate();
}



}
