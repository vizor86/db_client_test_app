package com.mycompany.app;

import java.sql.*;

/**
 * Created by dmitriy.martinov on 29.02.2016.
 */
public class OracleProtocol {
    private Connection jdbcTemplate;

    public int login(String userName, String password){
        try {
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            Statement stmt = jdbcTemplate.createStatement();
            String sql = "begin auth_pkg.login(p_user_name => ?," +
                         "                     p_password  => ?," +
                         "                     p_user_id   => ?," +
                         "                     p_role_id   => ?); " +
                         "end;";
            CallableStatement callstmt = jdbcTemplate.prepareCall(sql);
            callstmt.setString(1, userName);
            callstmt.setString(2, password);
            callstmt.registerOutParameter(3, Types.INTEGER);
            callstmt.registerOutParameter(4, Types.INTEGER);
            callstmt.execute();

            int user_id = callstmt.getInt(3);
            int user_role = callstmt.getInt(4);
            System.out.println("USER_ID: " + user_id);
            stmt.close();
            return user_id;
        }catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return 0;
    }

    public OracleProtocol() {
        System.out.println("OracleProtocol constructor init");
        OracleConnector connector = new OracleConnector();
        jdbcTemplate = connector.getConn();
    }
}
