package com.banco.capa3_dominio.entidades;
import java.sql.Date;
import java.time.LocalDate;
public class Tarjeta {
    private int idTarjeta;
    private Cliente cliente ; 
    private Date fechaApertura ; 
    private Date fechaExpiracion;
    private String tipoTarjeta;
    private int numeroTarjeta;
    private double saldoInicial ;
    private double saldoActual;

    public double getSaldoActual() {
        return saldoActual=saldoInicial;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

  /*  @Override
    public String toString() {
        return "Tarjeta{" + "cliente=" + cliente.getIdCliente() + ", fechaApertura=" + fechaApertura + ", fechaExpiracion=" + fechaExpiracion + ", tipoTarjeta=" + tipoTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", saldo=" + saldo + '}';
    }*/

    @Override
    public String toString() {
        return "Tarjeta{" + "idTarjeta=" + idTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", numeroTarjeta=" + numeroTarjeta + '}';
    }

    public Tarjeta(int numeroTarjeta) {
    this.numeroTarjeta = numeroTarjeta;
    }

    public Tarjeta() {
    }
    //agregar tarjeta frm
    public Tarjeta(String tipoTarjeta,int numeroTarjeta, double saldo,Cliente cliente) {
        this.tipoTarjeta = tipoTarjeta;
        this.saldoInicial = saldo;
        this.cliente=cliente;
        this.numeroTarjeta=numeroTarjeta;
        
    }

    
    public void TarjetaApertura  (Tarjeta tarjeta){
    fechaApertura = Date.valueOf(LocalDate.now());
    asignarFechaExpiracion();
    }
    private  void asignarFechaExpiracion(){
    fechaExpiracion = Date.valueOf(LocalDate.now().plusDays(4));
    }

    
    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

   
    // realizar renovacion de tarjetaCredito metodo
    public void realizarRenovacionTarjeta(){
        fechaExpiracion = Date.valueOf(LocalDate.now().plusDays(20));
    }
}
