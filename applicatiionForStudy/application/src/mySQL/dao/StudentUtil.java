package mySQL.dao;

import User.Student;

import java.sql.SQLException;
import java.util.ArrayList;

import static mySQL.dao.SchoolHaveUtil.getHaveByID;

public final class StudentUtil extends sqlConnection {
    private StudentUtil(){}

    static Student student = new Student();
    public static Student getStudentByID(int ID) {

        //给一个id 返回student对象
        String sql = "SELECT * FROM student Where studentID='" + ID + "'";
        try
        {
            rs = stmt.executeQuery(sql);
            //遍历处理结果
            while (rs.next())
            {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                Boolean pass;
                if(rs.getInt("pass")==0){
                    pass = true;
                }else{
                    pass = false;
                }
                String school = rs.getString("school");
                String email = rs.getString("email");
                String info = rs.getString("info");
                String score = rs.getString("score");
                int schoolID = rs.getInt("schoolID");
                int majorID = rs.getInt("MajorID");
                int res = rs.getInt("res");
                int AgencyId = rs.getInt("AgencyID");
                student.setSchoolID(studentID);
                student.setName(name);
                student.setPass(pass);
                student.setSchool(school);
                student.setEmail(email);
                student.setInfo(info);
                student.setScore(score);
                student.setSchoolID(schoolID);
                student.setMajorID(majorID);
                int[] temp = getHaveByID(schoolID);
                student.setHave(temp);
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
        return student;
    }
    public static ArrayList<Student> getStudentsAll(){
        //把student表中所有的stu对象以集合的方式返回
        ArrayList<Student> stu = new ArrayList<Student>();
        String sql = "select * from student left join schoolhave on student.studentId = schoolhave.schoolHaveID;";
        Student student  = new Student();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                Boolean pass;
                if(rs.getInt("pass")==0){
                    pass = false;
                }else{
                    pass = true;
                }
                String school = rs.getString("school");
                String email = rs.getString("email");
                String info = rs.getString("info");
                String score = rs.getString("score");
                int schoolID = rs.getInt("schoolID");
                int majorID = rs.getInt("MajorID");
                int res = rs.getInt("res");
                int AgencyId = rs.getInt("AgencyID");
                student.setSchoolID(studentID);
                student.setName(name);
                student.setPass(pass);
                student.setSchool(school);
                student.setEmail(email);
                student.setInfo(info);
                student.setScore(score);
                student.setSchoolID(schoolID);
                student.setMajorID(majorID);
                int[] temp = getHaveByID(schoolID);
                student.setHave(temp);
                stu.add(student);

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
        return stu;
        }
    }
    public static ArrayList<Integer> getStudentIDByAgencyID(int AgencyID)
    {
        //传入agencyID返回对应agencyID的studentID的集合
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        String sql = "select * from agency left join student on user = AgencyID where user ="+AgencyID+";";
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int studentID = rs.getInt("studentID");
                tempList.add(studentID);
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
        return tempList;
    }
    public static ArrayList<Student> getStudentByAgencyID(int AgencyID)
    {
        //传入agencyID返回对应agencyID的student对象集合
        ArrayList<Student> tempList = new ArrayList<Student>();
        String sql = "select * from student left join schoolhave on student.studentId = schoolhave.schoolHaveID where AgencyID = "+AgencyID+";";
        Student student  = new Student();
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                Boolean pass;
                if(rs.getInt("pass")==0){
                    pass = false;
                }else{
                    pass = true;
                }
                String school = rs.getString("school");
                String email = rs.getString("email");
                String info = rs.getString("info");
                String score = rs.getString("score");
                int schoolID = rs.getInt("schoolID");
                int majorID = rs.getInt("MajorID");
                int res = rs.getInt("res");
                int AgencyId = rs.getInt("AgencyID");
                student.setSchoolID(studentID);
                student.setName(name);
                student.setPass(pass);
                student.setSchool(school);
                student.setEmail(email);
                student.setInfo(info);
                student.setScore(score);
                student.setSchoolID(schoolID);
                student.setMajorID(majorID);
                int[] temp = getHaveByID(schoolID);
                student.setHave(temp);
                tempList.add(student);
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
        return tempList;
    }
    public static ArrayList<Student> getStudentBySchoolID(int SchoolID)
    {
        //传入SchoolID返回对应SchoolID的student对象集合
        ArrayList<Student> stus = new ArrayList<Student>();
        String sql =  "SELECT * FROM student WHERE schoolID = "+SchoolID+";";
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                Boolean pass;
                if(rs.getInt("pass")==0){
                    pass = false;
                }else{
                    pass = true;
                }
                String school = rs.getString("school");
                String email = rs.getString("email");
                String info = rs.getString("info");
                String score = rs.getString("score");
                int schoolID = rs.getInt("schoolID");
                int majorID = rs.getInt("MajorID");
                int res = rs.getInt("res");
                int AgencyId = rs.getInt("AgencyID");
                student.setSchoolID(studentID);
                student.setName(name);
                student.setPass(pass);
                student.setSchool(school);
                student.setEmail(email);
                student.setInfo(info);
                student.setScore(score);
                student.setSchoolID(schoolID);
                student.setMajorID(majorID);
                int[] temp = getHaveByID(schoolID);
                student.setHave(temp);
                stus.add(student);
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
        return stus;
    }

    public static boolean insertStudentByStudent(Student stu){
        //传入student对象将值插入表
        int pass;
        if (stu.isPass()){
            pass = 1;
        }else {
            pass = 0;
        }
        String sql ="INSERT INTO student values ("
                +stu.getStudentID()+","
                +stu.getName()+","
                +pass+","
                +stu.getSchool()+","
                +stu.getEmail()+","
                +stu.getInfo()+","
                +stu.getScore()+","
                +stu.getMajorID()+","
                +stu.getRes()+","
                +stu.getAgencyID()+
                ");";
        boolean result ;
        try {
            if(stmt.executeUpdate(sql)!=0)
                result = true;
            else
                result = false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static boolean deleteStudentByID(int ID){
        String sql ="DELETE FROM student where studentID = '"+ID+"';";
        boolean result ;
        try {
            if(stmt.executeUpdate(sql)!=0)
                result = true;
            else
                result = false;
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
        return result;
    }
}
