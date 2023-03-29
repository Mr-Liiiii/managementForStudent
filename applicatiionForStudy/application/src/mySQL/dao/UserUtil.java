package mySQL.dao;
import User.User;
import com.sun.source.tree.SwitchTree;

import java.sql.*;

public final class UserUtil extends mySQL.dao.sqlConnection {
    //POWER == "0"
    private UserUtil(){
    }
    static User user  = new User();
    public static boolean InsertByUser(User user){
        //将一个user对象插入表
        String sql = "INSERT into user VALUES ('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getPower()+"')";
        boolean result;
        try
        {
            if(stmt.executeUpdate(sql)!=0)
                result = true;
            else
                result = false;

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
        }
        return result;
    }
    public static void InsertIdByPower(int Id,int Power){
        switch (Power){
            case 1:     //agency
            AgencyUtil.InsertIdByAgency(Id);
                break;
            case 2:     //audit
            AuditUtil.InsertIdByAudit(Id);
                break;
            case 3:     //reply
            ReplyUtil.InsertIdByReply(Id);
                break;
            //case 4:     //student
            //StudentUtil.InsertIdByStudent(Id);
                //break;
//            case 5:     //school
//
//                break;
//            case 6:     //major

                //break;
            default:
                break;

        }





    }
    public static User getUserById(int ID) {

        //给一个id 返回user对象
        String sql = "SELECT * FROM user Where user='" + ID + "'";
        try
        {
            rs = stmt.executeQuery(sql);
            //遍历处理结果
            while (rs.next())
            {
                int userId = rs.getInt("user");
                String userName = rs.getString("username");
                String passWord = rs.getString("password");
                int power = rs.getInt("power");
                user.setId(userId);
                user.setUsername(userName);
                user.setPassword(passWord);
                user.setPower(power);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
    return user;
    }

    public static void checkLogOn(User temp)
    {
        //进行特判判断账号密码是否正确正确返回对象

        String sql = "SELECT * FROM user Where username='" + user.getUsername() + "'";
        try {
            rs = stmt.executeQuery(sql);
            //遍历处理结果
            while (rs.next())
            {
                int userId = rs.getInt("user");
                String userName = rs.getString("username");
                String passWord = rs.getString("password");
                int power = rs.getInt("power");
                user.setId(userId);
                user.setUsername(userName);
                user.setPassword(passWord);
                user.setPower(power);
            }
            if (temp.getUsername().equals(user.getUsername()))
                {
                    if (temp.getPassword().equals(user.getPassword()))
                    {

                            if (temp.getPower()==user.getPower())
                            {
                                temp = user;
                            }else {

                            System.out.println("用户名密码错误！");
                            }
                    }
                        else{

                            System.out.println("用户名密码错误！");
                            }
                }else{
                        System.out.println("用户名密码错误！");
                     }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
