package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.ShopsInfo;

import java.util.List;
import java.util.Map;

/**
 * @interface ShopsInfo
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 14:08
 * @Version 1.0
 **/
public interface ShopsInfoMapper {
    /**
     * 增：新增店铺信息
     * @param shopsInfo
     * @return
     */
    int addShopsInfo(ShopsInfo shopsInfo);

    /**
     * 删：根据 编号 删除店铺信息
     * @param siId
     * @return
     */
    int delShopsInfoById(String siId);

    /**
     * 改：根据 编号 删除店铺信息
     * @param shopsInfo
     * @return
     */
    int updateShopsInfoById(ShopsInfo shopsInfo);

    /**
     * 查：根据编号查询店铺信息
     * @param siId
     * @return
     */
    ShopsInfo findShopsInfoById(String siId);

    /**
     * 查：根据名称查询店铺信息
     * @param siName
     * @return
     */
    ShopsInfo findShopsInfoByName(String siName);

    /**
     * 查：根据条件查询店铺信息(siName店铺名称，siDescribe店铺描述，siExists店铺是否下线，rId地区，pId省份)
     * @return
     */
    List<ShopsInfo> findShopsInfoByCondition(Map<String, Object> map);

    /**
     * 查：查询表总记录
     * @return
     */
    int findCount();
}
