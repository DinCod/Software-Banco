/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.capa2_aplicacion;

import com.banco.capa3_dominio.entidades.Usuario;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import com.banco.capa4_persistencia.jdbc_postgre.GestorDAOPostgre;
import com.banco.capa4_persistencia.jdbc_postgre.UsuarioDAO;



public class UsuarioServicio {
  private GestorJDBC gestorJDBC;
  private UsuarioDAO usuarioDAOPostgre;
  
  
  
  public UsuarioServicio(){
      gestorJDBC = new GestorDAOPostgre();
      usuarioDAOPostgre = new UsuarioDAO(gestorJDBC);
  }
  
  
  public int registrarUsuario  (Usuario usuario) throws Exception {
  gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registrar = usuarioDAOPostgre.registrarUsuarioDAO(usuario);
            gestorJDBC.terminarTransaccion();
            return registrar;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }
  
  public Usuario verificarUser (String email) throws Exception{
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAOPostgre.VerificarEmail(email);
        gestorJDBC.cerrarConexion();
        return usuario;
    }
  
  
}
