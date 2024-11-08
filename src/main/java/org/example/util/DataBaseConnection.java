package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String username = "root";
    private static String password = "1234";
    private static Connection connection;

    public static Connection getIntace() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url, username,password);
        }
        return connection;
    }
}
