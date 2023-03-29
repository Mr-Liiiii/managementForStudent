package service;

import User.Student;
import mySQL.dao.SchoolUtil;
import mySQL.dao.StudentUtil;

import java.util.ArrayList;

public final class schoolService {

    private schoolService(){}

    public static ArrayList<Student> getStudentBySchoolID(int SchoolID){
        return StudentUtil.getStudentBySchoolID(SchoolID);
    }

}
