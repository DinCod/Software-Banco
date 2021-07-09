
package com.banco.capa4_persistencia.jdbc_postgre;

import com.banco.capa3_dominio.entidades.Usuario;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    GestorJDBC gestorJDBC;
    public UsuarioDAO (GestorJDBC gestorJDBC) {
    this.gestorJDBC = gestorJDBC;
    }
    
    public int registrarUsuarioDAO (Usuario usuario) throws SQLException {
        String sentenciaSQL = "insert into usuarios (email,contraseña) "
                + "values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getEmail());
        sentencia.setString(2, usuario.getContraseña());
        return sentencia.executeUpdate();
    }
    
       public Usuario VerificarEmail(String email) throws SQLException {
        Usuario usuario = null;
        ResultSet resultadoUsuario;
        String sentenciaSQL;
        sentenciaSQL = "select  idusuario , email , contraseña "
        + "from usuarios where email = '" + email + "'";
        resultadoUsuario = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultadoUsuario.next()) {
            usuario = new Usuario();
            usuario.setIdusuario(resultadoUsuario.getInt("idusuario"));
            usuario.setEmail(resultadoUsuario.getString("email"));
            usuario.setContraseña(resultadoUsuario.getString("contraseña"));
        }
        resultadoUsuario.close();
        return usuario;
    }
    
}
