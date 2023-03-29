package Main;
import User.*;
import User.User;
import User.Agency;
import User.Audit;
import User.Reply;

import mySQL.dao.AgencyUtil;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int cnt = 1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

//        User temp = new User();
//        temp.setId(4);
//        temp.setUsername("fcca");
//        temp.setPassword("asasasasas");
//        temp.setPower(1);
//        UserUtil.InsertByUser(temp);
          ArrayList<Integer> temp = new ArrayList<Integer>();
          //temp = StudentUtil.getStudentIDByAgencyID(2);
//        for (int i = 0; i < temp.size(); i++) {
//            System.out.println(temp.get(i));
//        }
//        int []temp = new int[3]
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp[i]);
//
//        }
        //test();
    }
//    public void init() {
//        Major m1 = new Major("计算机科学与技术", 1);
//        Major m2 = new Major("信息安全", 2);
//        Major m3 = new Major("软件工程", 3);
//        Major m4 = new Major("信息管理与信息系统", 4);
//        Major m5 = new Major("质量管理工程", 5);
//        Major m6 = new Major("网络工程", 6);
//
//        School s1 = new School(1, "澳洲国立大学");
//        School s2 = new School(2, "悉尼大学");
//        School s3 = new School(3, "新南威尔士大学");
//
//        s1.getMajors().add(m1);
//        s1.getMajors().add(m2);
//
//        s2.getMajors().add(m3);
//        s2.getMajors().add(m4);
//        s3.getMajors().add(m5);
//        s3.getMajors().add(m6);
//    }

    public static void test() {
        while(true) {
            mainMenu();
            int inPut =  sc.nextInt();
            if(inPut == 1) {
                User tmp = logOn();
                userService.checkLogOn(tmp);//特判函数
                int user = tmp.getId();
                // 调用接口传入tmp 拿对象
                if(tmp.getPower() == 1) {
                   // 返回Agency的接口
                    agencyService.getAgencyById(user).frame();
                }
                else if(tmp.getPower() == 2) {
                    Audit a = new Audit(); // 返回Audit的接口
                    a.frame();
                }
                else {
                    Reply r = new Reply(); // 返回Reply的接口
                    r.frame();
                }
            }
            else if(inPut == 2) {
                while(true){                                                            //特判函数

                        User temp = register();
                        if (userService.checkRegister(temp)){
                            userService.InsertByUser(temp);                            // 以 User 的形式直接塞进数据库
                            userService.InsertIdByPower(temp.getId(),temp.getPower());// 放入对应职位的表
                            break;
                        }else{
                            System.out.println("😅Duplicate username ! please input again!!");
                        }
                }
                // 把对象传给后面
            }
            else {
                break;
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Welcome to administrator page!");
        System.out.println("Please select");
        System.out.println("1. Log on");//登录
        System.out.println("2. Register");//注册
        System.out.println("3. Exit");//退出
    }

    public static User logOn() {
        System.out.println("Enter your username");
        String username = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();
        System.out.println("Please select your status :");
        System.out.println("1. Agency"); // 代理专员
        System.out.println("2. Audit"); // 审查专员
        System.out.println("3. Reply"); // 批复专员
        int p = sc.nextInt();
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setPower(p);
        return u;
    }

    public static User  register() {
        System.out.println("Please Enter Your Username :");
        String un = sc.next();
        User u;
        String pwd;
        while (true) {
            System.out.println("Please Enter Your Password :");
            pwd = sc.next();
            System.out.println("Please confirm your password");
            String p2 = sc.next();
            if(pwd.equals(p2)) {
                break;
            }
            else {
                System.out.println("Please re-enter, because there are some differences between the two passwords !");
            }
        }
        System.out.println("Please select your status :");
        System.out.println("1. Agency"); // 代理专员
        System.out.println("2. Audit"); // 审查专员
        System.out.println("3. Reply"); // 批复专员
        switch (sc.nextInt()) {
            case 1:
                u = new Agency(cnt ++ , un, pwd, 1);
                return u;
            case 2:
                u = new Audit(cnt ++ , un, pwd, 2);
                return u;
            case 3:
                u = new Reply(cnt ++ , un, pwd, 3);
                return u;
        }
        return null;
    }

}
