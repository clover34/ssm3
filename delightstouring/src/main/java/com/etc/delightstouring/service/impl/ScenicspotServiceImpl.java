package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Scenicspot;
import com.etc.delightstouring.mapper.ScenicspotMapper;
import com.etc.delightstouring.service.ScenicspotService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicspotServiceImpl implements ScenicspotService {

    @Autowired
    private ScenicspotMapper mapper;

    /*新增景点*/
    @Override
    public boolean add(Scenicspot scenicspot) {
        return mapper.add(scenicspot) > 0 ? true : false;
    }

    /*删除景点*/
    @Override
    public boolean delete(int ssId) {
        return mapper.delete(ssId) > 0 ? true : false;
    }

    /*修改景点*/
    @Override
    public boolean update(Scenicspot scenicspot) {

        return mapper.update(scenicspot) > 0 ? true : false;
    }
    /*查询总记录数*/
    @Override
    public int count(int ssId) {
        return mapper.count(ssId);
    }

    /**
     * 查：查询所有记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Scenicspot> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findAll();
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据省份查找景点*/
    @Override
    public PageInfo<Scenicspot> findByPid(int pId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findByPid(pId);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据地区查找景点*/
    @Override
    public PageInfo<Scenicspot> findByRid(int rId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findByRid(rId);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据景点名称查询景点*/
    @Override
    public PageInfo<Scenicspot> findByName(String ssName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findByName(ssName);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据景点描述查询景点*/
    @Override
    public PageInfo<Scenicspot> findByDescribe(String ssDescribe, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findByDescribe(ssDescribe);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }
}
