package com.jnshu.task1.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: TASK1
 * @description: 工厂类获取connection对象
 * @author: Mr.Chen
 * @create: 2018-11-06 15:30
 * @contact:938738637@qq.com
 **/
public class ConnectionFactionary {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Properties properties;
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            properties = new Properties();
            //获取jdbc.properties
            InputStream is = new FileInputStream("src/main/resource/jdbc.properties");
            //加载需要读取的文件
            properties.load(is);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()throws Exception {
        Class.forName(driver);
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst!=null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //测试是否获取到连接
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactionary.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
