package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Newmessage;

import java.util.List;

public interface NewmessageMapper {
    /*新增留言*/
    int add(Newmessage newmessage);
    /*删除留言*/
    int delete(int uid);
    /*修改留言*/
    int update(Newmessage newmessage);
    /*查询总记录数*/
    int count(int uid);
    /*查询所有留言*/
    List<Newmessage> findAll();
    /*根据编号查找留言*/
    Newmessage findByPid(int uid);
}
