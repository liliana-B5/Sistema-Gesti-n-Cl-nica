/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    public static String url = "jdbc:mysql://localhost:3306/dawa";
    public static String usuario = "root";
    public static String clave = "*******";
    public static String clase = "com.mysql.jdbc.Driver";
    PreparedStatement ps = null;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion establecida..");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }

     public ResultSet ejecutarConsulta(String sql) throws SQLException {
        Statement stmt = conectar().createStatement();
        return stmt.executeQuery(sql);
    }
     
    public ResultSet ejecutarConsulta(String sql, Object[] params) throws SQLException {
        ps = conectar().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeQuery();
    }

    public int ejecutarActualizacionP(String sql, Object[] params) throws SQLException {
        ps = conectar().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        int r = ps.executeUpdate();
        return r;
    }

    public void desconectar() throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (conectar() != null && !conectar().isClosed()) {
            conectar().close();
        }
    }
}