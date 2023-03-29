package User;

import java.util.Objects;

public class Student {
    private int studentID;
    private String name;
    private boolean pass;
    private String school;
    private String email;
    private String info;
    private String score;
    private int schoolID;
    private int MajorID;
    private int [] have = new int[3]; //存了schoolID
    private int res; // 1.未申请  2.申请中  3.占位  4.录取
    private int AgencyID;

    public Student() {
        this.res = 1;
    }

    public Student(Student u) {
        this.name = u.name;
        this.studentID = u.getStudentID();
        this.pass = u.pass;
        this.schoolID = u.schoolID;
        this.school = u.school;
        this.score = u.score;
        this.info = u.info;
        this.have = u.have;
        this.email = u.email;
        this.MajorID = u.MajorID;
    }

    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(int studentID, boolean pass, String school, String email, String info, String score, int schoolid, int majorid) {
        this.studentID = studentID;
        this.pass = pass;
        this.school = school;
        this.email = email;
        this.info = info;
        this.score = score;
        this.schoolID = schoolid;
        this.MajorID = majorid;
        this.have = new int[3];
        this.res = 1;
    }

    public int getAgencyID() {
        return AgencyID;
    }

    public void setAgencyId(int agencyId) {
        this.AgencyID = agencyId;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolId) {
        this.schoolID = schoolId;
    }

    public int getMajorID() {
        return MajorID;
    }

    public void setMajorID(int majorId) {
        this.MajorID = majorId;
    }

    public int[] getHave() {
        return have;
    }

    public void setHave(int []have) {
        this.have = have;
}

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int x : have) {
            sb.append(x).append(" ");
        }
        return  "姓名：" + name
                +"\n学生id：" + studentID
                +"\n是否通过" + (pass ? "是" : "否")
                +"\n就读学校：" + school
                +"\n联系方式：" + email
                +"\n自荐材料路径：" + info
                +"\n成绩单扫描件路径：" + score
                +"\n申请学校id：" + schoolID
                +"\n申请专业id：" + MajorID
                +"\n申请结果：" + res
                +"\n负责代理人编号：" + AgencyID
                +"\n已申请过学校id：" + sb;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && pass == student.pass && schoolID == student.schoolID && MajorID == student.MajorID && res == student.res && AgencyID == student.AgencyID && Objects.equals(name, student.name) && Objects.equals(school, student.school) && Objects.equals(email, student.email) && Objects.equals(info, student.info) && Objects.equals(score, student.score) && Objects.equals(have, student.have);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, pass, school, email, info, score, schoolID, MajorID, have, res, AgencyID);
    }
}
