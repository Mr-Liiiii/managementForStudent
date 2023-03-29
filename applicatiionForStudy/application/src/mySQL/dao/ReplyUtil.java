package mySQL.dao;

import User.User;

import java.sql.SQLException;

public final class ReplyUtil extends sqlConnection{
    //POWER == 3
    private ReplyUtil(){
    }
    static User Reply = new User();


    public static void InsertIdByReply(int Id){

        //将一个userid值插入表

        String sql = "INSERT into Reply (user) VALUE ('"+Id+"')";
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





}
