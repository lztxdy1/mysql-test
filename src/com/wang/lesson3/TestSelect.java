package com.wang.lesson3;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();    //获取数据库连接
            String sql = "select * from `user` where `id` = ?";
            //预编译sql但不执行
            st = conn.prepareStatement(sql);
            //手动设置sql参数
            st.setInt(1, 3);
            //执行sql
            rs = st.executeQuery();
            while (rs.next()){
                System.out.println("username = " + rs.getObject("username"));
                System.out.println("age = " + rs.getObject("age"));
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
