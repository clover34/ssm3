package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Newmessage;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

public interface NewmessageMapper {
    /*新增留言*/
    int addNewmessage(Newmessage newmessage);
    /*删除留言*/
    int delNewmessageById(Integer nmid);
    /*修改留言*/
    int updateNewmessageById(Newmessage newmessage);
    /*查询总记录数*/
    int findCount();
    /*查询所有留言*/
    List<Newmessage> findAllNewmessage();

    /**
     * 查：根据编号查询留言
     * @param nmid
     * @return
     */
    Newmessage findNewmessageById(Integer nmid);

    /*根据用户编号查找留言*/
    List<Newmessage> findNewmessageByUid(String uid);

    // List<Newmessage> findNewmessageByDate();
}
