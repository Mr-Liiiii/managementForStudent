package User;

import School.School;
import mySQL.dao.StudentUtil;

import java.util.ArrayList;


public class Reply extends User{
    private int studentid;
    private int schoolid;

    public ArrayList<Student> getStudentsBySchoolID() {
        // 通过当前Reply对象的schoolid返回students集合
        //通过schoolID返回对应Student表的集合
        ArrayList<Student> students =  StudentUtil.getStudentBySchoolID(schoolid) ;
        return students;
    }

    public Reply() {
    }

    @Override
    public void frame() {
        System.out.println("欢迎来到批复专员页面！");
        System.out.println("1. 查看学生申请表");
        ArrayList<Student> students = getStudentsBySchoolID();
        if(sc.nextInt() == 1) {
            /*
             * 调用接口查学生
             * 只要在Stu表中查schoolid等于当前 Reply对象的schoolid，并且pass为true的学生
             */
            for(Student s : students) {
                System.out.println(s);
            }
        }
        System.out.println("请选择要进行操作的学生");
        Student t = students.get(sc.nextInt());
        System.out.println("请确认是否修改该学生专业信息，或不进行修改，并对该学生所选专业进行占位");
        System.out.println("1. 进行修改");
        System.out.println("2. 确认占位");
        if(sc.nextInt() == 1) {
            System.out.println("请给出建议修改的专业ID");
            t.setMajorID(sc.nextInt());
        }
        else if(sc.nextInt() == 2) {
            System.out.println("请确认是否进行占位（输入1进行确认）");
            if(sc.nextInt() == 1) {
                t.setRes(3);
                t.setPass(true);
                /*
                 * 这里可以更改学生所申请学校和专业的人数
                 * 但是要求中说录取最终可以不考虑，那么这里也就当做锦上添花
                 */
            }
        }
        /*
         * 此时t就是已经更新好的学生对象，直接还给数据库即可
         */
    }

    @Override
    public void see() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Student update() {
        return null;
    }

    public Reply(int power) {
        super(power);
    }

    public Reply(int id, String username, String password, int power) {
        super(id, username, password, power);
    }

    public Reply(int id, String username, String password, int power, int studentid, int schoolid) {
        super(id, username, password, power);
        this.studentid = studentid;
        this.schoolid = schoolid;
    }

    public Reply(int studentid, int schoolid) {
        this.studentid = studentid;
        this.schoolid = schoolid;
    }


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }
}
