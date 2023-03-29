package service;

import User.*;
import mySQL.dao.AgencyUtil;

public final class agencyService {
    public static void InsertIdByAgency(int ID){
        //将userid记录传入表中
        AgencyUtil.InsertIdByAgency(ID);
    }

    public static void InsertByUser(User user){
        //给一个对象 将对应记录插入表
        AgencyUtil.InsertByUser(user);
    }
    public static Agency getAgencyById(int AgencyID) {
        //传入一个AgencyID返回对应Agency对象
        return  AgencyUtil.getAgencyById(AgencyID);
    }

}
