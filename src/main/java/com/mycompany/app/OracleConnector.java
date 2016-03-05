package com.mycompany.app;
import java.sql.*;
public class OracleConnector {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:hospital/hospital@localhost:1521/XE";
    //  Database credentials
    static final String USER = "hospital";
    static final String PASS = "hospital";

    public Statement stmt = null;
    public Connection conn = null;

    public  OracleConnector (){
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.print("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("OK");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }//end main

    public Connection getConn() {
        return conn;
    }
}//end FirstExample