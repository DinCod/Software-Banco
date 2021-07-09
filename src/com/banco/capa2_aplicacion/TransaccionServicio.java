
package com.banco.capa2_aplicacion;
import com.banco.capa3_dominio.entidades.Tarjeta;
import com.banco.capa3_dominio.entidades.Transaccion;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.TarjetaDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.TransaccionDAOPostgre;



public class TransaccionServicio {
    
private GestorJDBC gestorJDBC;
private TransaccionDAOPostgre transaccionPostgre;
private TarjetaDAOPostgre tarjetePostgre;
        

public TransaccionServicio(){
gestorJDBC = new GestorDAOPostgre();    
transaccionPostgre = new TransaccionDAOPostgre(gestorJDBC);
tarjetePostgre = new TarjetaDAOPostgre (gestorJDBC);
}

public int realizarDeposito(Transaccion transaccion )throws Exception{
    
    gestorJDBC.abrirConexion();
    try {
    gestorJDBC.iniciarTransaccion();
    int realizar = transaccionPostgre.depositoDAO(transaccion);
    gestorJDBC.terminarTransaccion();
    return realizar ;
    }catch (Exception e) {
    gestorJDBC.cancelarTransaccion();
    throw e;
    }
}
public int realizarRetiro(Transaccion transaccion )throws Exception{
    
    gestorJDBC.abrirConexion();
    try {
    gestorJDBC.iniciarTransaccion();
    int retirar = transaccionPostgre.retiroDAO(transaccion);
    gestorJDBC.terminarTransaccion();
    return retirar ;
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
