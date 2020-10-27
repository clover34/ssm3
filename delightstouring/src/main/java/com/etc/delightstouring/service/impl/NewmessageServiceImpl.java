package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Newmessage;
import com.etc.delightstouring.mapper.NewmessageMapper;
import com.etc.delightstouring.service.NewmessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewmessageServiceImpl implements NewmessageService {
    @Autowired
    private NewmessageMapper mapper;

    /*新增留言*/
    @Override
    public boolean add(Newmessage newmessage) {
        return mapper.add(newmessage)>0?true:false;
    }

    /*删除留言*/
    @Override
    public boolean delete(int uid) {
        return mapper.delete(uid)>0?true:false;
    }

    /*修改留言*/
    @Override
    public boolean update(Newmessage newmessage) {
        return mapper.update(newmessage)>0?true:false;
    }

    /*查询总记录数*/
    @Override
    public int count(int uid) {
        return mapper.count(uid);
    }

    /*查询所有留言*/
    @Override
    public PageInfo<Newmessage> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Newmessage> all = mapper.findAll();
        PageInfo<Newmessage> pageInfo=new PageInfo<>(all);
        return pageInfo;
    }

    /*根据编号查找留言*/
    @Override
    public Newmessage findByPid(int uid) {
        return mapper.findByPid(uid);
    }
}
