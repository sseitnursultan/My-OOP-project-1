package com.company;

import java.sql.*;

public class Deposit {
    ConnectDB db = new ConnectDB();

    public void deposit (String firstName,int summa) throws SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM information WHERE first_name='"+firstName+"'");

            try{
                if(rs.next()) {
                    if(summa>0) {
                        String s = "UPDATE information SET balance=balance + " + summa +
                                "WHERE first_name='"+firstName+"'";
                        st.executeUpdate(s);
                        System.out.println("you have put money");
                    }
                    else {
                        System.out.println("Wrong format");
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
