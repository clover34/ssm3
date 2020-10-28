package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Scenicspot;
import com.etc.delightstouring.mapper.ScenicspotMapper;
import com.etc.delightstouring.service.ScenicspotService;
import com.etc.delightstouring.utils.CounterUtil;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 景点表
 */
@Service
public class ScenicspotServiceImpl implements ScenicspotService {

    @Autowired
    private ScenicspotMapper mapper;

    /*新增景点*/
    @Override
    public boolean addScenicspot(Scenicspot scenicspot) {
        if (mapper.findScenicspotByName(scenicspot.getSsName()) == null) {
            scenicspot.setUUID(UUIDUtil.getUUID());
            scenicspot.setSsId(CounterUtil.getCounterStr("ss", findCount()));
            return mapper.addScenicspot(scenicspot) > 0 ? true : false;
        }
        return false;
    }

    /*删除景点*/
    @Override
    public boolean delScenicspotById(int ssId) {
        return mapper.delScenicspotById(ssId) > 0 ? true : false;
    }

    /*修改景点*/
    @Override
    public boolean updateScenicspotById(Scenicspot scenicspot) {
        return mapper.updateScenicspotById(scenicspot) > 0 ? true : false;
    }
    /*查询总记录数*/
    @Override
    public int findCount() {
        return mapper.findCount();
    }

    /**
     * 查：查询所有记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Scenicspot> findAllScenicspot(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findAllScenicspot();
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据省份查找景点*/
    @Override
    public PageInfo<Scenicspot> findScenicspotByPid(Integer pId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findScenicspotByPid(pId);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据地区查找景点*/
    @Override
    public PageInfo<Scenicspot> findScenicspotByRid(Integer rId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findScenicspotByRid(rId);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据景点名称查询景点*/
    @Override
    public PageInfo<Scenicspot> findScenicspotByName(String ssName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findScenicspotByName(ssName);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /*根据景点描述查询景点*/
    @Override
    public PageInfo<Scenicspot> findScenicspotByDescribe(String ssDescribe, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> all = mapper.findScenicspotByDescribe(ssDescribe);
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    /**
     * 分页模糊查询：根据条件查询信息
     * @param rId
     * @param ssName
     * @param ssDescribe
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Scenicspot> findScenicspotByCondition(Integer rId, String ssName, String ssDescribe, Integer pageNum, Integer pageSize) {
        Map<String ,Object> map = new HashMap<>();
        map.put("rId",rId);
        map.put("ssName",ssName);
        map.put("ssDescribe",ssDescribe);
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> scenicspots = mapper.findScenicspotByCondition(map);
        return new PageInfo<Scenicspot>(scenicspots);
    }
}
