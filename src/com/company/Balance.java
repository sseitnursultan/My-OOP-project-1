package com.company;

import java.sql.*;

public class Balance {
    ConnectDB db = new ConnectDB();

    public void checkBalance(String firstName) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM information WHERE first_name='"+firstName+"'" );

            try{
                if(rs.next()) {
                    System.out.println( "Your balance " + rs.getInt("balance")+"$");
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

