package User;

import java.util.ArrayList;

public class Audit extends User{
    // getStudent()
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        // 从 Stu 表中拿到所有的学生，并以学生集合类的形式返回
        return students;
    }
    
    @Override
    public void frame() {
        System.out.println("欢迎来到审核员界面：");
        while(true) {
            System.out.println("请选择");
            System.out.println("1. 审批学生资质");
            System.out.println("2. 修改密码");
            System.out.println("else.退出");
            if(sc.nextInt() == 1) {
                checkStudent();
            }
            else if(sc.nextInt() == 2) {
                changePassword();
            }
            else break;
        }
        // 把这个更新完的学生直接塞进数据库
        // 调用更新接口
        // 接口（Student)
    }

    public void checkStudent() {
        ArrayList<Student> students = getStudents();
        System.out.println("请选择要审核的学生：");
        for(int i = 0; i < students.size(); i++) {
            System.out.println("第" + (i + 1) + "学生");
            System.out.println(students.get(i));
        }
        int id = sc.nextInt();
        Student s = students.get(id);
        System.out.println("请审批是否合格：1.合格，0.不合格");
        if(sc.nextInt() == 0) {
            int[] temp = s.getHave();
            temp[s.getSchoolID()]= 1;
        }
        else {
            s.setPass(true);
        }
        System.out.println("审批完成");
    }

    public Audit(int id, String username, String password, int power) {
        super(id, username, password, power);
    }

    public Audit(int power) {
        super(power);
    }

    public Audit() {
    }
}
