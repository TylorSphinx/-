package net.derviol;

import java.sql.*;

public class MySqlConnect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/人事管理系统";

    static final String USER = "root";
    static final String PASS = "0000";

    public Connection Connect() {
        Connection con = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // 打开链接
            //System.out.println("连接数据库...");
            try {
                con = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
