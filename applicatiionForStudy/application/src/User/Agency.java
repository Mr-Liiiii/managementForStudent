package User;

import mySQL.dao.StudentUtil;

import java.util.ArrayList;

public class Agency extends User {
    private ArrayList<Integer> students;

    public Agency(int id, String username, String password, int power) {
        super(id, username, password, power);
    }
    public Agency() {
        students = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Integer> students) {
        this.students = students;
    }
    @Override
    public void frame() {
        System.out.println("请选择：");
        System.out.println("0. 修改密码");
        System.out.println("1. 提交申请");
        System.out.println("2. 查看申请");
        System.out.println("3. 修改申请学校（专业）");
        System.out.println("4. 撤销申请");
        switch (sc.nextInt()) {
            case 0:
                changePassword();
                // 修改密码
            case 1:
                //提交
                // 把submit返回的对象给到下层数据库进行提交
                StudentUtil.insertStudentByStudent(submit());
                //把学生插入到学校的表中
                break;
            case 2:
                System.out.println("请选择查看方式");
                System.out.println("1. 查看所有学生");
                System.out.println("2. 查看已占位学生");
                System.out.println("3. 查看单个学生信息");
                if(sc.nextInt() == 1) {
                    ArrayList<Student> students = getStudentsByAgencyID();
                    seeAll(students);
                }
                else if(sc.nextInt() == 2) {
                    seePassedStudents();
                }
                else {
                    see();
                }
            case 3:
                // 修改对应申请表的专业和学校...
                update();
            case 4:
                //删除申请表
                // 同submit，用对象进行数据库修改
                delete();
                break;
        }
    }

    public Student submit() { // 提交
        Student s = new Student();
        s.setAgencyId(this.getId());
        // 键入信息
        System.out.println("学生姓名：");
        s.setName(sc.next());
        System.out.println("在读学校：");
        s.setSchool(sc.next());
        System.out.println("联系方式：");
        s.setEmail(sc.next());
        System.out.println("自荐材料路径：");
        s.setInfo(sc.next());
        System.out.println("成绩单扫描件路径：");
        s.setScore(sc.next());
        System.out.println("申请学校ID：");
        s.setSchoolID(sc.nextInt());
        int[] temp = s.getHave();//temp[x]=1表示学生已经申请过第x个学校
        temp[s.getSchoolID()]= 1;
        System.out.println("申请专业ID：");
        s.setMajorID(sc.nextInt());
        s.setRes(2);
        /**
         * 将包装好的Student对象交给数据库，存在Student表中
         */
        return s;
    }

    public ArrayList<Student> getStudentsByAgencyID() {
        // 传入当前Agency的 agencyid
        ArrayList<Student> students = new ArrayList<>();
        return students;
    }

    public void seePassedStudents() {
        ArrayList<Student> students = getStudentsByAgencyID();
        for(Student s : students) {
            if(s.getRes() == 3) {
                System.out.println(s.getName() + "同学已经通过所有审核， 目标院校为：" + s.getSchool() + "，专业代码为"
                        + s.getMajorID());
            }
        }
    }

    public void see() {
        System.out.println("请输入要查看的学会ID：");
        int id = sc.nextInt();
        // 调用接口拿到Student对象，直接输出展示
    }


    public Student getStudentByID(int id) {
        Student s = new Student();
        return s;
    }

    //boolean check(int id) {
      //  return
    //}

    public Student update() {
        System.out.println("请输入要修改的学生编号");
        int id = sc.nextInt();

        // 下层接口调用方法 拿id 返回Student
        Student s = getStudentByID(id); // 拿到下层返回学生
        System.out.println("请输入要修改的学校编号：");
        s.setSchoolID(sc.nextInt());
        System.out.println("请输入要修改的专业编号");
        s.setMajorID(sc.nextInt());
        if(s.getRes() == 3) {
            s.setRes(2);
        }
        return s;
    }

//    public void delete() {
//        // 键入编号表示要删哪个学生
//        System.out.println("请输入要修改的学生编号");
//        int id = sc.nextInt();
//        if(!check(id)) {
//            // id不合法
//            System.out.println("id不合法！");
//            return ;
//        }
//        // 下层找到对应id的申请表（学生）直接删除
//        // 调用删除接口
//    }

    public Agency(int p) {
        super(p);
    }

}
