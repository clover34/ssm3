package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Scenicspot;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScenicspotService {
    /**
     * 增：新增景点
     * @param scenicspot
     * @return
     */
    boolean addScenicspot(Scenicspot scenicspot);

    /**
     * 删：根据编号删除记录
     * @param ssId
     * @return
     */
    boolean delScenicspotById(int ssId);

    /**
     * 改：根据编号修改记录
     * @param scenicspot
     * @return
     */
    boolean updateScenicspotById(Scenicspot scenicspot);

    /**
     * 查：查询总记录数
     * @param ssId
     * @return
     */
    int findCount();

    /**
     * 查：查询所有景点
     * @return
     */
    PageInfo<Scenicspot> findAllScenicspot(Integer pageNum, Integer pageSize);

    /**
     * 查：根据省份查找景点
     * @param pId
     * @return
     */
    PageInfo<Scenicspot> findScenicspotByPid(Integer pId, Integer pageNum, Integer pageSize);

    /**
     * 查：根据地区查找景点
     * @param rId
     * @return
     */
    PageInfo<Scenicspot> findScenicspotByRid(Integer rId, Integer pageNum, Integer pageSize);

    /**
     * 查：根据名称查询景点
     * @param ssName
     * @return
     */
    PageInfo<Scenicspot> findScenicspotByName(String  ssName, Integer pageNum, Integer pageSize);

    /**
     * 查：根据景点描述查询景点
     * @param ssDescribe
     * @return
     */
    PageInfo<Scenicspot> findScenicspotByDescribe(String ssDescribe, Integer pageNum, Integer pageSize);

    /**
     * 查：根据条件查询景点信息
     * @param rId
     * @param ssName
     * @param ssDescribe
     * @return
     */
    PageInfo<Scenicspot> findScenicspotByCondition(Integer rId, String  ssName,String ssDescribe, Integer pageNum, Integer pageSize);
}
