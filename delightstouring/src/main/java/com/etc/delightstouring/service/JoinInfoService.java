package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.JoinInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName JoinInfoService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 9:12
 * @Version 1.0
 **/
public interface JoinInfoService {
    /**
     * 增：新增一条记录
     * @param joinInfo
     * @return
     */
    boolean addJoinInfo(JoinInfo joinInfo);

    /**
     * 删：根据编号删除加盟信息
     * @param UUID
     * @return
     */
    boolean delJoinInfoById(String UUID);

    /**
     * 改：根据编号修改加盟信息
     * @param joinInfo
     * @return
     */
    boolean updateJoinInfoById(JoinInfo joinInfo);
    // 模糊查询：根据用户名查询用户信息
    // 根据时间查询记录加盟信息
    // 根据状态编号查询加盟信息

    /**
     * 查：根据名称查询店铺信息
     * @param jiName
     * @return
     */
    JoinInfo findJoinInfoByName(String jiName);

    /**
     * 查：根据 UUID 查询店铺信息
     * @param UUID
     * @return
     */
    JoinInfo findJoinInfoByUUID(String UUID);
    /**
     * 查：根据状态查询加盟店铺信息
     * @param sId
     * @return
     */
    PageInfo<JoinInfo> findJoinInfoBySId(Integer sId, Integer pageNum, Integer pageSize);
    // 模糊查询：根据店铺名称查询加盟信息
    // 根据省份查询加盟信息
    // 根据地区编号查询加盟信息

    /**
     * 查：根据添加查询申请加盟店铺信息
     * @param jiName
     * @param pId
     * @param rId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<JoinInfo> findJoinInfoByCondition(
            String jiName,Integer pId, Integer rId,
            Integer pageNum, Integer pageSize);

    /**
     * 查：查询所有记录
     * @return
     */
    int findCount();
}
