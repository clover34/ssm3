package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Newmessage;
import com.github.pagehelper.PageInfo;

public interface NewmessageService {
    /*新增留言*/
    boolean add(Newmessage newmessage);
    /*删除留言*/
    boolean delete(int uid);
    /*修改留言*/
    boolean update(Newmessage newmessage);
    /*查询总记录数*/
    int count(int uid);
    /*查询所有留言*/
    PageInfo<Newmessage> findAll(int pageNum,int pageSize);
    /*根据编号查找留言*/
    Newmessage findByPid(int uid);
}
