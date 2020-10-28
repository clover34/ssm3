package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.ShopsInfo;
import com.etc.delightstouring.mapper.ShopsInfoMapper;
import com.etc.delightstouring.service.ShopsInfoService;
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
 * @ClassName ShopsInfoServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 10:05
 * @Version 1.0
 **/
@Service
public class ShopsInfoServiceImpl implements ShopsInfoService {
    @Autowired
    private ShopsInfoMapper shopsInfoMapper;

    /**
     * 增：根据编号新增一条记录
     * @param shopsInfo
     * @return
     */
    @Override
    public boolean addShopsInfo(ShopsInfo shopsInfo) {
        if (findShopsInfoByName(shopsInfo.getSiName()) == null) {
            shopsInfo.setUUID(UUIDUtil.getUUID());
            shopsInfo.setSiId(CounterUtil.getCounterStr("si", findCount()));
            shopsInfo.setSiExists(1);
            return shopsInfoMapper.addShopsInfo(shopsInfo) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 删：根据编号删除记录
     * @param siId
     * @return
     */
    @Override
    public boolean delShopsInfoById(String siId) {
        return shopsInfoMapper.delShopsInfoById(siId) > 0 ? true : false;
    }

    /**
     * 改：根据编号修改记录
     * @param shopsInfo
     * @return
     */
    @Override
    public boolean updateShopsInfoById(ShopsInfo shopsInfo) {
        return shopsInfoMapper.updateShopsInfoById(shopsInfo) > 0 ? true : false;
    }

    /**
     * 查：根据编号查询记录
     * @param siId
     * @return
     */
    @Override
    public ShopsInfo findShopsInfoById(String siId) {
        return shopsInfoMapper.findShopsInfoById(siId);
    }

    /**
     * 查：根据名称查询记录
     * @param siName
     * @return
     */
    @Override
    public ShopsInfo findShopsInfoByName(String siName) {
        return shopsInfoMapper.findShopsInfoByName(siName);
    }

    /**
     * 查：根据条件查询记录
     * @param siName
     * @param siDescribe
     * @param siExists
     * @param rId
     * @param pId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ShopsInfo> findShopsInfoByCondition(String siName, String siDescribe,
                                                        Integer siExists, Integer rId, Integer pId,
                                                        Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("siName",siName);
        map.put("siDescribe",siDescribe);
        map.put("siExists",siExists);
        map.put("rId",rId);
        map.put("pId",pId);
        PageHelper.startPage(pageNum, pageSize);
        List<ShopsInfo> shopsInfos = shopsInfoMapper.findShopsInfoByCondition(map);
        return new PageInfo<ShopsInfo>(shopsInfos);
    }

    /**
     * 查：查询表总记录数
     * @return
     */
    @Override
    public int findCount() {
        return shopsInfoMapper.findCount();
    }
}
