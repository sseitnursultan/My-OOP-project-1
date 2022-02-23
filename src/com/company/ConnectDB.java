package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/data", "postgres", "user");
            return con;
        }
        catch (SQLException e){
            System.out.println("Something went wrong");
            return null;
        }
    }
}