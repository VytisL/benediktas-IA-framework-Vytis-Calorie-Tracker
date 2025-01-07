package com.benedict.minibank.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver(){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:bankas.db");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Connection connect() {
        String url = "jdbc:sqlite:bankas.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error occurred in connect method: "+e.getMessage());
        }
        return conn;
    }

    /*
    * Client section
    * */

    public ResultSet getClientData(String  pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"'AND Password='"+password+"';");
            System.out.println(resultSet);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return  resultSet;
    }

    /*
    * Admin section
    * */

    public ResultSet getAdminData(String  username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"'AND Password='"+password+"';");
            System.out.println(resultSet.toString());
        }catch(SQLException e){
            e.printStackTrace();
        }

        return  resultSet;
    }

    /*
     * Utility  methods
     * */


}
