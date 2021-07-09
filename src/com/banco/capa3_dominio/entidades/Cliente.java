package com.banco.capa3_dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String dni,apellido,nombre;
    
    //cambio aquí
    public List<Tarjeta> totalDeTarjetas;
    
    //construtor para agregar cliente <Form:RegistrarCliente>
    public Cliente(String dni, String apellido,String nombre) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    //cambio aquí
    public Cliente  (){
    totalDeTarjetas = new ArrayList();
    }
    
    //construtor para desafiliar cliente <Form:DesafiliarCliente>
    public Cliente (String dni){
        this.dni=dni;
    }
    /*public Cliente() {
    }*/
    
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + '}';
    }
    
    
    
    //cambio aquí
    public boolean tieneTotalDeTarjetas(){
        return (totalDeTarjetas.size()==2);
    }
    //cambio aquí
    public boolean estaHabilitadoParaTarjeta(){
        return !tieneTotalDeTarjetas();
    }
   
}
