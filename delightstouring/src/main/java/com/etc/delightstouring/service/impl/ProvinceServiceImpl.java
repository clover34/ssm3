package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Province;
import com.etc.delightstouring.mapper.ProvinceMapper;
import com.etc.delightstouring.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProvinceServiceImpl
 * @Description TODO 省份
 * @Author Administrator
 * @Date 20/10/26 19:04
 * @Version 1.0
 **/
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    /**
     * 增：新增一条记录
     * @param province
     * @return
     */
    @Override
    public boolean addProvince(Province province) {
        if (provinceMapper.findProvinceByName(province.getpName()) == null) {
            return provinceMapper.addProvince(province) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 删：根据编号删除记录
     * @param pid
     * @return
     */
    @Override
    public boolean delProvinceById(Integer pid) {
        return provinceMapper.delProvinceById(pid) > 0 ? true : false;
    }

    /**
     * 改：根据编号修改记录
     * @param province
     * @return
     */
    @Override
    public boolean updateProvinceById(Province province) {
        return provinceMapper.updateProvinceById(province) > 0 ? true : false;
    }

    /**
     * 查：查询表总记录数
     * @return
     */
    @Override
    public int findCount() {
        return provinceMapper.findCount();
    }

    /**
     * 查：根据名称查找记录
     * @param name
     * @return
     */
    @Override
    public Province findProvinceByName(String name) {
        return provinceMapper.findProvinceByName(name);
    }

    /**
     * 查：根据编号查找记录
     * @param pid
     * @return
     */
    @Override
    public Province findProvinceById(Integer pid) {
        Province provinceById = provinceMapper.findProvinceById(pid);
        System.out.println("provinceById = " + provinceById);
        return provinceById;
    }

    /**
     * 查：查询所有记录
     * @return
     */
    @Override
    public List<Province> findAllProvince() {
        return provinceMapper.findAllProvince();
    }
}
