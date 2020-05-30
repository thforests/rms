package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 用来连接数据库
 */
public class DBUtil {



    /**
     * 专门用来连接数据库
     * @return
     */
    public static Connection getConn(){
        Connection connection=null;
        //1.加载核心配置文件
        InputStream in= DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //2.解析InputStream对象输入流
        Properties properties=new Properties();
        try {
            properties.load(in);
            //3.解析数据
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String url=properties.getProperty("url");
            String driverClass=properties.getProperty("driverClass");
            //4.注册驱动
            Class.forName(driverClass);
            //5.连接数据库
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;//null
    }


    /**
     * 关闭数据
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void  closeDB(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (statement !=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (connection !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}