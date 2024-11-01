package org.example;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String contrasena = "1234";

        try(Connection conn = DriverManager.getConnection(url,username,contrasena);
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos"))
            {
            while (resultado.next()){
                System.out.print(resultado.getString("nombre")+", ");
                System.out.print(resultado.getInt("id")+", ");
                System.out.print(resultado.getInt("precio")+",");
                System.out.println(resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
