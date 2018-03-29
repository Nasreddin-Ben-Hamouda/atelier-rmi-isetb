package com.dsi.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/BankJee","root","");

        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Classe not found");
        }catch(SQLException e) {
            System.out.println("probleme de connection a la base de donnes");
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }

}
