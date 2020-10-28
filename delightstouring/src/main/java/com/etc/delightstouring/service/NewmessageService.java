package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Newmessage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NewmessageService {
    /*新增留言*/
    boolean addNewmessage(Newmessage newmessage);
    /*删除留言*/
    boolean delNewmessageById(Integer nmid);
    /*修改留言*/
    boolean updateNewmessageById(Newmessage newmessage);
    /*查询总记录数*/
    int findCount();
    /*查询所有留言*/
    PageInfo<Newmessage> findAllNewmessage(Integer pageNum, Integer pageSize);

    /**
     * 查：根据编号查询留言
     * @param nmid
     * @return
     */
    Newmessage findNewmessageById(Integer nmid);

    /*根据用户编号查找留言*/
    PageInfo<Newmessage> findNewmessageByUid(String uid, Integer pageNum, Integer pageSize);
}
