package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Region;

import java.util.List;

/**
 * @interface RegionService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 9:08
 * @Version 1.0
 **/
public interface RegionService {
    /**
     * 增：新增一条记录
     * @param region
     * @return
     */
    boolean addRegion(Region region);

    /**
     * 删：根据编号删除一条记录
     * @param rid
     * @return
     */
    boolean delRegionById(Integer rid);

    /**
     * 改：根据编号修改记录
     * @param region
     * @return
     */
    boolean updateRegionById(Region region);

    /**
     * 查：根据编号查询一条记录
     * @param rid
     * @return
     */
    Region findRegionById(Integer rid);

    /**
     * 查；根据名称查询一条记录
     * @param name
     * @return
     */
    Region findRegionByName(String name);

    /**
     * 查：查询所有记录
     * @return
     */
    List<Region> findAllRegion();

    /**
     * 查：根据 p_id 查询记录
     * @param pid
     * @return
     */
    List<Region> findRegionByPid(Integer pid);

    /**
     * 查：查询表记录数
     * @return
     */
    int findCount();
}
