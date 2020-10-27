package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Scenicspot;
import com.github.pagehelper.PageInfo;

public interface ScenicspotService {
    /*新增景点*/
    boolean add(Scenicspot scenicspot);
    /*删除景点*/
    boolean delete(int ssId);
    /*修改景点*/
    boolean update(Scenicspot scenicspot);
    /*查询总记录数*/
    int count(int ssId);
    /*查询所有景点*/
    PageInfo<Scenicspot> findAll(int pageNum, int pageSize);
    /*根据省份查找景点*/
    PageInfo<Scenicspot> findByPid(int pId,int pageNum,int pageSize);
    /*根据地区查找景点*/
    PageInfo<Scenicspot> findByRid(int rId,int pageNum,int pageSize);
    /*根据景点查询景点*/
    PageInfo<Scenicspot> findByName(String  ssName, int pageNum, int pageSize);
    /*根据景点描述查询景点*/
    PageInfo<Scenicspot> findByDescribe(String ssDescribe,int pageNum,int pageSize);
}
