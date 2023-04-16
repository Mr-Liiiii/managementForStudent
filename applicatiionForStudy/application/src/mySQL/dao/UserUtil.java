package mySQL.dao;
import User.User;

import java.sql.*;

public final class UserUtil extends mySQL.dao.sqlConnection {
    public static void scWhileExecUserGet(String sql) throws SQLException {
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
    }
    //POWER == "0"
    private UserUtil(){
    }
    static User user  = new User();
    public static boolean InsertByUser(User user){
        //将一个user对象插入表
        @SuppressWarnings("SqlResolve")
        String sql = "INSERT into user VALUES ('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getPower()+"')";
        boolean result;
        try
        {
            result = stmt.executeUpdate(sql) != 0;

            //遍历处理结果
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static boolean UpdatePasswordByUser(String newPassword,int Id){
        //将一个user对象插入表
        @SuppressWarnings("SqlResolve")
        String sql = "UPDATE user set `password` ="+newPassword+" WHERE `user` ="+Id;
        boolean result;
        try
        {
            result = stmt.executeUpdate(sql) != 0;
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static void InsertIdByPower(int Id,int Power){
        //通过power将找到对应的表传入对应的user
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
            scWhileExecUserGet(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return user;
    }
    public static String getUserPasswordById(int ID) {

        //给一个id 返回user对象
        String sql = "SELECT * FROM user Where user='" + ID + "'";
        String oldPassword = "";
        try
        {
            rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()) {
                oldPassword = rs.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oldPassword;
    }

    public static User checkLogOn(User temp)
    {
        //进行特判判断账号密码是否正确正确返回对象
        String sql = "SELECT * FROM user Where username='" + temp.getUsername() + "'";
        try {
            scWhileExecUserGet(sql);
            if (temp.getUsername().equals(user.getUsername()))
                {
                    if (temp.getPassword().equals(user.getPassword()))
                    {
                            if (temp.getPower()==user.getPower())
                            {

                                temp = user;
                            }else {

                            System.out.println("用户名密码错误！");
                            temp = null;
                            }
                    }
                        else{

                            System.out.println("用户名密码错误！");
                            temp = null;
                            }
                }else{
                        System.out.println("用户名密码错误！");
                        temp = null;
                     }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
    public static boolean checkRegister(User temp)
    {
        String sql = "SELECT * FROM user Where username='" + temp.getUsername() + "'";
        try {
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
