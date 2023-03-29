package service;

import User.Reply;
import User.User;
import mySQL.dao.ReplyUtil;

public final class replyService {

    private replyService(){
    }

    public static Reply getReplyByUser(User temp){
        return ReplyUtil.getReplyByUser(temp);
    }
}
