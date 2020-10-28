package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.ShopsInfo;
import com.github.pagehelper.PageInfo;


/**
 * @ClassName ShopsInfoService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 10:05
 * @Version 1.0
 **/
public interface ShopsInfoService {
    /**
     * 增：新增店铺信息
     * @param shopsInfo
     * @return
     */
    boolean addShopsInfo(ShopsInfo shopsInfo);

    /**
     * 删：根据 编号 删除店铺信息
     * @param siId
     * @return
     */
    boolean delShopsInfoById(String siId);

    /**
     * 改：根据 编号 删除店铺信息
     * @param shopsInfo
     * @return
     */
    boolean updateShopsInfoById(ShopsInfo shopsInfo);

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
    PageInfo<ShopsInfo> findShopsInfoByCondition(String siName, String siDescribe,
                                                 Integer siExists, Integer rId, Integer pId,
                                                 Integer pageNum, Integer pageSize);

    /**
     * 查：查询表总记录
     * @return
     */
    int findCount();
}
