package com.mycompany.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by dmitriy.martinov on 29.02.2016.
 */
public class OracleProtocol {
    private Connection jdbcTemplate;
    private UserData user;
    final static Logger logger = Logger.getLogger(OracleProtocol.class);

    public static int login(String userName, String password, Connection jdbcTemplate){

        try {
            logger.debug("LOGIN: " + userName);
            logger.debug("PASSWORD: " + password);
            //STEP 4: Execute a query
            logger.debug("Creating statement...");
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
            logger.debug("USER_ID: " + user_id);
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

    public static ArrayList<User> getUsers(Connection jdbcTemplate){
        try {
            String sql = "SELECT u.user_id,u.login,u.role_role_id,r.name " +
                         " FROM users u,roles r where u.role_role_id=r.role_id" +
                         " ORDER BY u.user_id";
            Statement stmt = jdbcTemplate.createStatement();
            logger.debug(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setLogin(rs.getString("login"));
                user.setRole(rs.getString("name"));
                user.setRoleId(rs.getInt("role_role_id"));
                users.add(user);
            }
            stmt.close();
            return users;
        }catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }
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
