
package com.banco.capa4_persistencia.jdbc_postgre;
import com.banco.capa4_persistencia.jdbc.GestorJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class GestorDAOPostgre extends GestorJDBC {

    @Override
    public void abrirConexion() throws Exception {
        try {
            
            //principal
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/databaseUser";
            //String url = "jdbc:postgresql://localhost:5432/prueba";
            conexion = DriverManager.getConnection(url, "postgres", "12345678");
            }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en la conexion con la base de datos ");
            
            }
           }

    @Override
    public Connection getConexion() {
        return conexion;
    }
}
