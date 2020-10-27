package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Scenicspot;

import java.util.List;

public interface ScenicspotMapper {
    /*新增景点*/
    int add(Scenicspot scenicspot);
    /*删除景点*/
    int delete(int ssId);
    /*修改景点*/
    int update(Scenicspot scenicspot);
    /*查询总记录数*/
    int count(int ssId);
    /*查询所有景点*/
    List<Scenicspot> findAll();
    /*根据省份查找景点*/
    List<Scenicspot> findByPid(int pId);
    /*根据地区查找景点*/
    List<Scenicspot> findByRid(int rId);
    /*根据景点查询景点*/
    List<Scenicspot> findByName(String  ssName);
    /*根据景点描述查询景点*/
    List<Scenicspot> findByDescribe(String ssDescribe);
}
