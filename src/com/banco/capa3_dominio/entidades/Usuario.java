
package com.banco.capa3_dominio.entidades;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class Usuario {
    
    private int idusuario;
    private String email;
    private String contraseña;

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    

}
