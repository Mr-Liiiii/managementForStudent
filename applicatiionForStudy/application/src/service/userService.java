package service;

import User.User;
import mySQL.dao.UserUtil;

public  final  class userService {

    public static User getUserId(int ID){
        //传入一个id 返回user对象
        return UserUtil.getUserById(ID);
    }
    public static String getUserPasswordById(int ID){
        return UserUtil.getUserPasswordById(ID);
    }
    public static boolean UpdatePasswordByUser(String newPassword,int Id){
        return UserUtil.UpdatePasswordByUser(newPassword,Id);
    }
    public static boolean InsertByUser(User use){
        //将一个user对象数据插入表
        return UserUtil.InsertByUser(use);
    }
    public static void InsertIdByPower(int ID,int Power){
        //通过power找到对应的表把id传入
        UserUtil.InsertIdByPower(ID,Power);
    }
    public static User checkLogOn(User temp){
        //进行特判判断账号密码是否正确正确返回对象
        return UserUtil.checkLogOn(temp);
    }
    public static boolean checkRegister(User temp){
        return UserUtil.checkRegister(temp);
    }

}
