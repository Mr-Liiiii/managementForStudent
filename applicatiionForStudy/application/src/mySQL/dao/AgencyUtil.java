package mySQL.dao;
 
import User.*;
import User.Agency;

import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public final class AgencyUtil extends sqlConnection{
     private  AgencyUtil(){}
    //"1"
    static Agency agency = new Agency();
    public static void InsertIdByAgency(int ID){
        //将userid记录传入表中
        String sql = "INSERT into agency VALUES ('"+ID+"')";
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
    public static void InsertByUser(User user){//给一个对象 将对应记录插入表
        String sql = "INSERT into agency ('user')VALUES ('"+user.getId()+"')";
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
    public static Agency getAgencyById(int AgencyID) {
        //传入一个AgencyID返回对应Agency对象
        String sql = "select * from user left join agency on user.user = agency.user where user.user = "+AgencyID+";";
        try
        {
            rs = stmt.executeQuery(sql);
            //遍历处理结果
            while (rs.next())
            {
                int user = rs.getInt("user.user");
                String username = rs.getString("username");
                String password = "**********";
                int power = rs.getInt("power");
                agency.setUsername(username);
                agency.setPassword(password);
                agency.setPower(power);
                agency.setStudents(StudentUtil.getStudentIDByAgencyID(AgencyID));
                agency.setId(user);
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
        return agency;
    }
}
