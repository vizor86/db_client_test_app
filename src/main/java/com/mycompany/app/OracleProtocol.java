package com.mycompany.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitriy.martinov on 29.02.2016.
 */
public class OracleProtocol {
    private Connection jdbcTemplate;
    private UserData user;

    public static int login(String userName, String password, Connection jdbcTemplate){
        try {
            System.out.println("LOGIN: " + userName);
            System.out.println("PASSWORD: " + password);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
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
            callstmt.close();
/*
            sql = "SELECT rght_rght_id rights FROM role_rights WHERE role_id = ?";
            PreparedStatement pstmt = jdbcTemplate.prepareStatement(sql);
            pstmt.setInt(1,user_role);

            ResultSet rs = pstmt.executeQuery();
            int i = 0;
            ArrayList<Integer> rights = new ArrayList<Integer>();
            while (rs.next()) {
                rights.add(rs.getInt("rights"));
                i++;
            }
            pstmt.close();

            user = new UserData(user_id,userName,user_role,rights);
*/
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

    public UserData getUser() {
        return user;
    }
}
