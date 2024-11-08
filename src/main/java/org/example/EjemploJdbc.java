package org.example;

import org.example.util.DataBaseConnection;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {



        try(Connection conn = DataBaseConnection.getIntace();
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos"))
            {
            while (resultado.next()){
                System.out.print(STR."\{resultado.getString("nombre")}, ");
                System.out.print(STR."\{resultado.getInt("id")}, ");
                System.out.print(STR."\{resultado.getInt("precio")},");
                System.out.println(STR."\{resultado.getDate("fecha_registro")}");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
