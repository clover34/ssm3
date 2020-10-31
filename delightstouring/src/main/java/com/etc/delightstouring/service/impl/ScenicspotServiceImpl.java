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
        System.out.println("scenicspot = " + scenicspot);
        if (findScenicspotByName(scenicspot.getSsName()) == null) {
            scenicspot.setUUID(UUIDUtil.getUUID());
            scenicspot.setSsId(CounterUtil.getCounterStr("ss", findCount()));
            System.out.println("自动UUID后================scenicspot = " + scenicspot);
            boolean isOk = mapper.addScenicspot(scenicspot) > 0 ? true : false;
            System.out.println("准备返回结果");
            return isOk;
        }
        System.out.println("\"走我这条路线吗\" = " + "走我这条路线吗");
        return false;
    }

    /*删除景点*/
    @Override
    public boolean delScenicspotById(String ssId) {
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
    public Scenicspot findScenicspotByName(String ssName) {
        return mapper.findScenicspotByName(ssName);
    }

    /**
     * 查：根据编号查询景点信息
     * @param ssId
     * @return
     */
    @Override
    public Scenicspot findScenicspotById(String ssId) {
        return mapper.findScenicspotById(ssId);
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
    public PageInfo<Scenicspot> findScenicspotByCondition(Integer rId, Integer pId, String ssName, String ssDescribe,
                                                          Integer pageNum, Integer pageSize) {
        Map<String ,Object> map = new HashMap<>();
        map.put("rId",rId);
        map.put("ssName",ssName);
        map.put("ssDescribe",ssDescribe);
        map.put("pId",pId);
        PageHelper.startPage(pageNum, pageSize);
        List<Scenicspot> scenicspots = mapper.findScenicspotByCondition(map);
        return new PageInfo<Scenicspot>(scenicspots);
    }
}
