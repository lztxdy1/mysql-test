package com.wang.lesson3;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JDBCUtils.getConnection();   //获取数据库连接
            //？表示占位符
            String sql = "delete from `user` where `username` = ?";
            st = conn.prepareStatement(sql);       //预编译sql但不执行
            //手动设置参数
            st.setString(1, "小李");
            //执行sql
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(conn, st, null);
        }
    }
}
