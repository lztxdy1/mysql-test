package com.wang.lesson2;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JDBCUtils.getConnection();   //获取数据库连接
            st = conn.createStatement();        //创建执行sql的对象
            String sql = "delete from `user` where name = '小王'";
            int i = st.executeUpdate(sql);
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
