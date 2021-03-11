package com.wang.lesson2;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();    //获取数据库连接
            st = conn.createStatement();         //创建执行sql的对象
            String sql = "select * from `user`";
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println("name = " + rs.getObject("name"));
                System.out.println("age = " + rs.getObject("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.release(conn, st, rs);
        }
    }


}
