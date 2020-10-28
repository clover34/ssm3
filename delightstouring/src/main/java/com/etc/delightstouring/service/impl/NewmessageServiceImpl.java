package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Newmessage;
import com.etc.delightstouring.mapper.NewmessageMapper;
import com.etc.delightstouring.service.NewmessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言
 */
@Service
public class NewmessageServiceImpl implements NewmessageService {
    @Autowired
    private NewmessageMapper mapper;

    /*新增留言*/
    @Override
    public boolean addNewmessage(Newmessage newmessage) {
        return mapper.addNewmessage(newmessage)>0?true:false;
    }

    /*删除留言*/
    @Override
    public boolean delNewmessageById(Integer nmId) {
        return mapper.delNewmessageById(nmId)>0?true:false;
    }

    /*修改留言*/
    @Override
    public boolean updateNewmessageById(Newmessage newmessage) {
        return mapper.updateNewmessageById(newmessage)>0?true:false;
    }

    /*查询总记录数*/
    @Override
    public int findCount() {
        return mapper.findCount();
    }

    /*查询所有留言*/
    @Override
    public PageInfo<Newmessage> findAllNewmessage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Newmessage> all = mapper.findAllNewmessage();
        PageInfo<Newmessage> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据编号查找留言*/
    @Override
    public Newmessage findNewmessageById(Integer nmId) {
        return mapper.findNewmessageById(nmId);
    }

    /**
     * 查：根据用户编号查询部分记录
     * @param uId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Newmessage> findNewmessageByUid(String uId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Newmessage> newmessages = mapper.findNewmessageByUid(uId);
        return new PageInfo<Newmessage>(newmessages);
    }
}
