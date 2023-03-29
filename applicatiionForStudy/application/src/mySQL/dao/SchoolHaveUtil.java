package mySQL.dao;

import java.sql.SQLException;

public final class SchoolHaveUtil extends sqlConnection{

    private SchoolHaveUtil(){
    }
    public static int[] getHaveByID(int Id) {
        //传入一个ID对应schoolHaveId记录以数组形式返回
        String sql ="SELECT * FROM schoolhave WHERE schoolHaveID='"+Id+"';";
        int []temp = new int[3];
        try {
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                for(int i = 1;i<4;i++){
                    if (((rs.getInt("School"+i))==0))
                        temp[i-1]= 0;
                    else if ((rs.getInt("School"+i)==1))
                        temp[i-1]= 1;
                    else {
                        System.out.println("学校数据有误");
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }


    public static boolean checkHaveByID(int ID) {
        //传入一个ID找到对应表中的记录检查有没有记录
        String sql ="SELECT * FROM schoolhave WHERE schoolHaveID='"+ID+"';";
        Boolean result=false;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int schoolHaveID = rs.getInt("schoolHaveID");
                result =  schoolHaveID==ID;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static void setHaveByArray(int ID,int[] schoolHave) {
        //传入id 和schoolhave数组判断时否存在数据存在先删除再插入 否则直接插入数据
        if (checkHaveByID(ID)){
            String sql1= "delete from schoolhave where schoolHaveID="+ID+ ";";
            String sql2 = "insert into schoolhave values (" +ID+","+schoolHave[0]+"," +schoolHave[1]+"," +schoolHave[2]+");";
            try {
                stmt.executeQuery(sql1);
                stmt.executeQuery(sql2);
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
            }
        }else{
            String sql = "insert into schoolhave values (" +ID+","+schoolHave[0]+"," +schoolHave[1]+"," +schoolHave[2]+");";
            try {
                stmt.executeQuery(sql);
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
            }

        }










    }




}


