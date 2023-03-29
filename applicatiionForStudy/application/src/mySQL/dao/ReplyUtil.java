package mySQL.dao;

import User.*;

import java.sql.SQLException;

public final class ReplyUtil extends sqlConnection{
    //POWER == 3
    private ReplyUtil(){
    }
    static Reply reply = new Reply();


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
    public static Reply getReplyByUser(User temp)
    {

        //通过

        String sql ="select * from reply where user="+temp.getId()+";";
        try
        {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String userName = temp.getUsername();
                String passWord = "********";
                reply.setId(rs.getInt("user"));
                reply.setUsername(temp.getUsername());
                reply.setPassword(passWord);
                reply.setPower(temp.getPower());
                reply.setStudentid(rs.getInt("studentid"));
                reply.setSchoolid(rs.getInt("schoolid"));
            }

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
        return reply;
    }


}
