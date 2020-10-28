package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.JoinInfo;
import net.sf.jsqlparser.statement.select.Join;

import java.util.List;
import java.util.Map;

/**
 * @interface JoinInfoMapper
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 14:00
 * @Version 1.0
 **/
public interface JoinInfoMapper {
    /**
     * 增：新增一条记录
     * @param joinInfo
     * @return
     */
    int addJoinInfo(JoinInfo joinInfo);

    /**
     * 删：根据编号删除加盟信息
     * @param UUID
     * @return
     */
    int delJoinInfoById(String UUID);

    /**
     * 改：根据编号修改加盟信息
     * @param joinInfo
     * @return
     */
    int updateJoinInfoById(JoinInfo joinInfo);
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
    List<JoinInfo> findJoinInfoBySId(Integer sId);
    // 模糊查询：根据店铺名称查询加盟信息
    // 根据省份查询加盟信息
    // 根据地区编号查询加盟信息

    /**
     * 查：根据添加查询申请加盟店铺信息
     * @param map
     * @return
     */
    List<JoinInfo> findJoinInfoByCondition(Map<String, Object> map);
    // String jiName,Integer pId, Integer rId
    /**
     * 查：查询所有记录
     * @return
     */
    int findCount();
}
