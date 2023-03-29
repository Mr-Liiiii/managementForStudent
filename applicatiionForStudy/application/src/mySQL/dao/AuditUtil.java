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
    public static Audit getAuditByUser(User user){
        //将对应student表全部学生信息装入集合返回对象
        audit.


        return
    }

}
