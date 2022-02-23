package com.company;

import java.sql.*;


public class WithdrawCash {
    ConnectDB db = new ConnectDB();

    public void withdrawCash (String firstName,int summa) throws SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM information WHERE first_name='"+firstName+"'");

            try{
                if(rs.next()) {
                    if(rs.getInt("Balance") >= summa) {
                        String s = "UPDATE information SET balance=balance - " + summa +
                                "WHERE first_name='"+firstName+"'";
                        st.executeUpdate(s);
                    }
                    else {
                        System.out.println("Dont enough money");
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
