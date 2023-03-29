package User;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Func {
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String username;
    private String password;
    private int power;


    public User(int power) {
        this.power = power;
    }

    public User(int id, String username, String password, int power) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.power= power;
    }

    public User() {
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        User.sc = sc;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void changePassword() {
        Agency a = new Agency(this.getId(), this.getUsername(), this.getPassword(), this.getPower());
        System.out.println("请输入原密码：");
        String n = sc.next();
        System.out.println("请输入新密码");
        a.setPassword(sc.next());
        // 调用接口(新对象, 旧密码)
        // 如果匹配上
//        if(匹配上) {
//            this.setPassword(a.getPassword());
//        }
    }

    @Override
    public void frame() {

    }

    @Override
    public Student submit() {
        return null;
    }

    @Override
    public void see() {

    }

    @Override
    public Student update() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void seeAll(ArrayList<Student> students) {
        for(Student s : students) {
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", power=" + power +
                '}';
    }
}
