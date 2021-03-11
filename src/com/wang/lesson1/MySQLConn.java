package com.wang.lesson1;

import java.sql.*;

public class MySQLConn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、用户信息和url
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String name = "root";
        String password = "123456";
        //3、连接成功，数据库对象  connection代表数据库
        Connection connection = DriverManager.getConnection(url, name, password);
        //4、执行sql的对象   statement 执行sql的对象
        Statement statement = connection.createStatement();
        //5、执行sql的对象去执行sql，可能存在返回结果，查看返回结果
        String sql = "select * from `user`";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("age = " + resultSet.getObject("age"));
        }
        //6、关闭连接
        resultSet.close();
        statement.close();
        connection.close();


    }
}
