package com.wang.lesson3;

import com.wang.lesson2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JDBCUtils.getConnection();    //获取数据库连接
            //?代表占位符  与Statement的区别
            String sql = "insert into `user`(`id`, `username`,`age`, `password`) values (?,?,?,?)";
            st = conn.prepareStatement(sql);//预编译sql但不执行
            //手动输入sql参数
            st.setInt(1, 4);
            st.setString(2, "小李");
            st.setInt(3, 20);
            st.setString(4, "147258");
            //执行
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.release(conn, st, null);
        }
    }
}
