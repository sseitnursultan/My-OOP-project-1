package com.company;

import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        ///////////// CONNECTION TO DATABASE ///////////////////////////

        String url = "jdbc:postgresql://localhost:5432/data";
        String username = "postgres";
        String password = "user";



        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to postgreSql");


            Statement statement = connection.createStatement();

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connecting to DataBase");
            e.printStackTrace();
        }







//        System.out.println("Welcome to out Bank"); //menu
//
//        System.out.println("A) Check the balance");
//        System.out.println("B) Withdraw cash");
//        System.out.println("C) Deposit cash");
//        System.out.println("D) Modify the PIN Code");
//
//
//        Scanner scan = new Scanner(System.in);
//
//
//


    }
}
