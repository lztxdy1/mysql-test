package com.wang.lesson2;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.*;

public class SQLAttack {
    public static void main(String[] args) {
        String username = " ' or '1 = 1";     //sql注入  可以使用PreparedStatement防止sql注入
        String password = " ' or '1 = 1";
        login(username, password);
        //login("张三","123123");
    }
    //登录注入
    private static void login(String username, String password){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();       //获取数据库连接
            st = conn.createStatement();            //创建执行sql的对象
            String sql = "select * from `user` where `username`='" + username + "' and `password` = '" + password + "'";
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println("id = " + rs.getObject("id"));
                System.out.println("username = " + rs.getObject("username"));
                System.out.println("password = " + rs.getObject("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.release(conn, st, rs);
        }
    }
}
