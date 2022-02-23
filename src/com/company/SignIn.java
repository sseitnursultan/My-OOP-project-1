package com.company;

import java.sql.*;
import java.util.Scanner;

public class SignIn {
    private int pin;
    private String firstName;



    Scanner scan = new Scanner(System.in);

    ConnectDB db = new ConnectDB();

    public void signIn(String firstName,int pin) {


        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM information WHERE first_name='" + firstName + "'");
            try{
                if (rs.next()) {
                    if (rs.getInt("pin") == pin) {
                        System.out.println("you have successfully signed in");

                    }
                    else{
                        System.out.println("you have incorrect pin");
                    }
                }
                else{
                    System.out.println("You have entered wrong name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}








