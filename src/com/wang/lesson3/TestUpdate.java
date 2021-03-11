package com.wang.lesson3;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JDBCUtils.getConnection();   //获取数据库连接
            String sql = "update `user` set `password` = ? where id = ?";
            //预编译sql但不执行
            st = conn.prepareStatement(sql);
            //手动设置参数
            st.setString(1, "a123123");
            st.setInt(2, 2);
            //执行sql
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, st, null);
        }
    }
}
