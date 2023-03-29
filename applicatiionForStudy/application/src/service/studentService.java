package service;

import User.Student;
import mySQL.dao.StudentUtil;

import java.util.ArrayList;

public class studentService {
    public ArrayList<Student> getStudentsAll(){
        //1.查询student表中所有学生记录以集合的形式返回
        return StudentUtil.getStudentsAll();
    }
    public boolean deleteStudentByID(int ID){
        //2.传入studentID删除对应记录返回布尔值
        return StudentUtil.deleteStudentByID(ID);
    }
    public boolean insertStudentByStudent(Student stu){
        //3.传入student对象将值插入表
        return StudentUtil.insertStudentByStudent(stu);
    }
    public Student getStudentByID(int ID){
        //4.传入studentID返回对象
        return StudentUtil.getStudentByID(ID);
    }
}
