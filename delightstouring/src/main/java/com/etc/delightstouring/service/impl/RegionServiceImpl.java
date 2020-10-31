package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Region;
import com.etc.delightstouring.mapper.RegionMapper;
import com.etc.delightstouring.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RegionServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 9:08
 * @Version 1.0
 **/
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;

    /**
     * 增：新增一条记录
     * @param region
     * @return
     */
    @Override
    public boolean addRegion(Region region) {
        if (regionMapper.findRegionByName(region.getrName()) == null) {
            return regionMapper.addRegion(region) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 删：根据编号删除一条记录
     * @param rid
     * @return
     */
    @Override
    public boolean delRegionById(Integer rid) {
        return regionMapper.delRegionById(rid) > 0 ? true : false;
    }

    /**
     * 改：根据编号修改一条记录
     * @param region
     * @return
     */
    @Override
    public boolean updateRegionById(Region region) {
        return regionMapper.updateRegionById(region) > 0 ? true : false;
    }

    /**
     * 查：根据编号查询记录
     * @param rid
     * @return
     */
    @Override
    public Region findRegionById(Integer rid) {
        return regionMapper.findRegionById(rid);
    }

    /**
     * 查：根据名称查询记录
     * @param name
     * @return
     */
    @Override
    public Region findRegionByName(String name) {
        return regionMapper.findRegionByName(name);
    }

    /**
     * 查：查询所有记录
     * @return
     */
    @Override
    public List<Region> findAllRegion() {
        return regionMapper.findAllRegion();
    }

    /**
     * 查：根据省份编号查询记录
     * @param pid
     * @return
     */
    @Override
    public List<Region> findRegionByPid(Integer pid) {
        return regionMapper.findRegionByPid(pid);
    }

    /**
     * 查：查询总记录数
     * @return
     */
    @Override
    public int findCount() {
        return regionMapper.findCount();
    }
}
