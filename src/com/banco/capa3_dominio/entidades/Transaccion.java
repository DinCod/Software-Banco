package com.banco.capa3_dominio.entidades;
import java.sql.Date;
import java.time.LocalDate;
public class Transaccion {
private int idtransaccion;
private Tarjeta tarjeta;
private String tipoTransaccion;
private Date fechaTransaccion;
private double monto;
private int tarjetaOrigen;
private int tarjetaDestino;

    @Override
    public String toString() {
        return "Transaccion{" + "idtransaccion=" + idtransaccion + ", tarjeta=" + tarjeta.getIdTarjeta() + ", tipoTransaccion=" + tipoTransaccion + ", monto=" + monto + ", tarjetaOrigen=" + tarjetaOrigen + '}';
    }



    //retiro
    public Transaccion(Tarjeta tarjeta, String tipoTransaccion, double monto, int tarjetaOrigen) {
        this.tarjeta = tarjeta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.tarjetaOrigen = tarjetaOrigen;
    }

    //deposito
    public Transaccion(Tarjeta tarjeta,String tipoTransaccion,double monto,int tarjetaOrigen, int tarjetaDestino) {
        this.tarjeta = tarjeta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.tarjetaOrigen = tarjetaOrigen;
        this.tarjetaDestino = tarjetaDestino;
    }
    
    
    
    
    
    
    public Transaccion() {
    }
    
    
    public void FechaTransaccion (Transaccion transaccion){
        fechaTransaccion= Date.valueOf(LocalDate.now());
    }
    
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getTarjetaOrigen() {
        return tarjetaOrigen;
    }

    public void setTarjetaOrigen(int tarjetaOrigen) {
        this.tarjetaOrigen = tarjetaOrigen;
    }

    public int getTarjetaDestino() {
        return tarjetaDestino;
    }

    public void setTarjetaDestino(int tarjetaDestino) {
        this.tarjetaDestino = tarjetaDestino;
    }
    
    


//hacer uso de estos métodos   
//cambio aquí    
//métodos 
  public void realizarDeposito(Tarjeta tarjeta){
      double saldo = tarjeta.getSaldoInicial();
      if(saldo>0){
      this.monto += saldo;
    }
  }  
    
  public void realizarRetiro (Tarjeta tarjeta){
      double saldo = tarjeta.getSaldoInicial();
      if(this.monto - saldo < 0){
      this.monto = 0;
      }else{
      this.monto -= saldo;
    }
  }
}
