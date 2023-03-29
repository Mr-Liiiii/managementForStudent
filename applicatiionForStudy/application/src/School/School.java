package School;

import java.util.ArrayList;

public class School {
    private int schoolId;
    private String schoolName;
    private int TotalNum;
    private int currNum;
    private ArrayList<Integer> majors;

    public School() {
    }

    public School(int SchoolId, String SchoolName) {
        this.schoolId = SchoolId;
        this.schoolName = SchoolName;
        this.TotalNum = 100;
        this.currNum = 0;
        this.majors = new ArrayList<Integer>();
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(int totalNum) {
        this.TotalNum = totalNum;
    }

    public int getHaveName() {
        return currNum;
    }

    public void setHaveName(int haveName) {
        this.currNum = haveName;
    }

    public ArrayList<Integer> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Integer> majors) {
        this.majors = majors;
    }
}
