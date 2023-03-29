package mySQL.dao;

import User.*;

import java.sql.SQLException;

public final class AuditUtil extends sqlConnection {
    //POWER = "2"
    private AuditUtil(){

    }

    static Audit audit = new Audit();
    public static void InsertIdByAudit(int Id){

        //将一个userid值插入表

        String sql = "INSERT into audit VALUES ('"+Id+"')";
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

    public static Audit getAuditByUser(User temp){          //传入user对象返回audit对象
        String sql = "select * from audit left join user on audit.user = user.user where audit.user = "+audit.getUsername()+";";
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int userId = rs.getInt("user");
                String userName = rs.getString("username");
                String passWord = "****************";
                int power = rs.getInt("power");
                audit.setId(userId);
                audit.setUsername(userName);
                audit.setPassword(passWord);
                audit.setPower(power);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (conn !=null){
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
        return audit;
    }
}
