package com.skilllync.empapp;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
    static Connection con;
    public static  Connection createDBConnection(){
        try {
            // first load the driver 
            Class.forName("com.mysql.jdbc.Driver");
            // next get the connection
            String url = "jdbc:mysql://localhost:3306/employeeDB?useSSL=false";
            String user = "root";
            String pwd = "root";
            con = DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
     
            e.printStackTrace();
        }
        return con;
    }
}
