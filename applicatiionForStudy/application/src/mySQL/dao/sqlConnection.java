package mySQL.dao;
import java.sql.*;
import java.sql.SQLException;

    public class sqlConnection
    {
        public static Connection conn;
        public static Statement stmt;

        public static ResultSet rs;


//这里是SqlConnection 类

        /*
         *java连接mysql数据库
         *1、加载驱动程序
         *2、数据库连接字符串"jdbc:mysql://localhost:3306/数据库名?"
         *3、数据库登录名
         *3、数据库登录密码
         */

        public static final String URL = "jdbc:mysql://43.143.171.251:3306/javaTest?autoReconnect=true";//数据库连接字符串，这里的deom为数据库名
        public static final String NAME = "root";//登录名
        public static final String PASSWORD = "javaTest123456";//密码

        static
        {

            try {
                conn = DriverManager.getConnection(URL,NAME,PASSWORD);
                stmt = conn.createStatement();
                System.out.println("获取数据库连接成功！");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
//                if (rs != null) {
//                    try {
//                        rs.close();
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                if (stmt != null) {
//                    try {
//                        stmt.close();
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
            }



            //数据库打开后就要关闭



        }


}

