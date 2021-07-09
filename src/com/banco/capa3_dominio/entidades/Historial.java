/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa3_dominio.entidades;

public class Historial {
    
    
    private Tarjeta tarjeta;
    private Transaccion transaccion;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Historial(Tarjeta tarjeta, Transaccion transaccion) {
        this.tarjeta = tarjeta;
        this.transaccion = transaccion;
    }

    public Historial() {
    }

   
    
    
}
