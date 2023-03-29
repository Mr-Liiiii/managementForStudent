package mySQL.dao;

import User.User;
import User.Student;

import java.sql.SQLException;

public final class SchoolUtil extends sqlConnection{

    private SchoolUtil(){}
    static Student School = new Student();

    public static void InsertIdByStudent(int Id){

        //给一个user 将值插入表

        String sql = "INSERT into Student (user) VALUE ('"+Id+"')";
        try
        {
            stmt.executeUpdate(sql);
            //遍历处理结果
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
//    public static void InsertSchoolByStudent(Student student){
//
//        // 将传入得Student对象值插入表
//        String sql = "INSERT into user VALUES ('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getPower()+"')";
//        try
//        {
//            stmt.executeUpdate(sql);
//            //遍历处理结果
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        } finally {
//            if (conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (stmt!=null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (rs!=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }


}
