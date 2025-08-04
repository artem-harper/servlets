package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final static String URL = "jdbc:postgresql://localhost:5432/flight_repository";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "";

    private ConnectionManager() {

    }

    static{
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
            throw new RuntimeException(e);
        }
    }

    public static Connection get()  {
        try {
            return DriverManager.getConnection(URL,
                    USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
