package service;

import User.Audit;
import User.*;
import mySQL.dao.*;

public final class auditService {
    public static Audit getAuditByUser(User temp){ ////传入user对象返回audit对象
        return AuditUtil.getAuditByUser(temp);
    }




}
