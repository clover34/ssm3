package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Scenicspot;

import java.util.List;
import java.util.Map;

public interface ScenicspotMapper {
    /**
     * 增：新增景点
     * @param scenicspot
     * @return
     */
    int addScenicspot(Scenicspot scenicspot);

    /**
     * 删：根据编号删除记录
     * @param ssId
     * @return
     */
    int delScenicspotById(String ssId);

    /**
     * 改：根据编号修改记录
     * @param scenicspot
     * @return
     */
    int updateScenicspotById(Scenicspot scenicspot);

    /**
     * 查：查询总记录数
     * @return
     */
    int findCount();

    /**
     * 查：查询所有景点
     * @return
     */
    List<Scenicspot> findAllScenicspot();

    /**
     * 查：根据省份查找景点
     * @param pId
     * @return
     */
    List<Scenicspot> findScenicspotByPid(Integer pId);

    /**
     * 查：根据地区查找景点
     * @param rId
     * @return
     */
    List<Scenicspot> findScenicspotByRid(Integer rId);

    /**
     * 查：根据名称查询景点
     * @param ssName
     * @return
     */
    Scenicspot findScenicspotByName(String  ssName);

    /**
     * 查询：根据编号查询景点信息
     * @param ssId
     * @return
     */
    Scenicspot findScenicspotById(String ssId);

    /**
     * 查：根据景点描述查询景点
     * @param ssDescribe
     * @return
     */
    List<Scenicspot> findScenicspotByDescribe(String ssDescribe);

    /**
     * 查：根据条件查询景点信息
     * @return
     */
    List<Scenicspot> findScenicspotByCondition(Map<String, Object> map);
}

