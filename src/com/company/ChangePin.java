package com.company;

import java.sql.*;

public class ChangePin {


    ConnectDB db = new ConnectDB();

    public void changePin(String firstName,int pin) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM information WHERE first_name='"+firstName+"'");

            try{
                if(rs.next()) {
                    if(rs.getInt("pin")!=pin) {
                        String s = "UPDATE information SET pin=" + pin +
                                "WHERE first_name='"+firstName+"'";
                        st.executeUpdate(s);
                        System.out.println("pin changed successfully");
                    }
                    else {
                        System.out.println("Please enter a new pin");
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
