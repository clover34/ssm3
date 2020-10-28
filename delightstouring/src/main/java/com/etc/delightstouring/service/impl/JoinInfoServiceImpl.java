package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.JoinInfo;
import com.etc.delightstouring.mapper.JoinInfoMapper;
import com.etc.delightstouring.service.JoinInfoService;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JoinInfoServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 9:14
 * @Version 1.0
 **/
@Service
public class JoinInfoServiceImpl implements JoinInfoService {
    @Autowired
    private JoinInfoMapper joinInfoMapper;
    /**
     * 增：根据编号新增一条记录
     * @param joinInfo
     * @return
     */
    @Override
    public boolean addJoinInfo(JoinInfo joinInfo) {
        if (findJoinInfoByName(joinInfo.getJiName()) == null) {
            joinInfo.setUUID(UUIDUtil.getUUID());
            return joinInfoMapper.addJoinInfo(joinInfo) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 删：根据编号删除信息
     * @param UUID
     * @return
     */
    @Override
    public boolean delJoinInfoById(String UUID) {
        return joinInfoMapper.delJoinInfoById(UUID) > 0 ? true : false;
    }

    /**
     * 改：根据 UUID 修改记录
     * @param joinInfo
     * @return
     */
    @Override
    public boolean updateJoinInfoById(JoinInfo joinInfo) {
        return joinInfoMapper.updateJoinInfoById(joinInfo) > 0 ? true : false;
    }

    /**
     * 查：根据名称查询记录
     * @param jiName
     * @return
     */
    @Override
    public JoinInfo findJoinInfoByName(String jiName) {
        return joinInfoMapper.findJoinInfoByName(jiName);
    }

    /**
     * 查：根据 UUID 查询记录信息
     * @param UUID
     * @return
     */
    @Override
    public JoinInfo findJoinInfoByUUID(String UUID) {
        return joinInfoMapper.findJoinInfoByUUID(UUID);
    }

    /**
     * 查：根据状态查询记录信息
     * @param sId
     * @return
     */
    @Override
    public PageInfo<JoinInfo> findJoinInfoBySId(Integer sId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JoinInfo> joinInfos = joinInfoMapper.findJoinInfoBySId(sId);
        return new PageInfo<JoinInfo>(joinInfos);
    }

    /**
     * 查：根据条件查询记录信息
     * @param jiName
     * @param pId
     * @param rId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<JoinInfo> findJoinInfoByCondition(String jiName, Integer pId, Integer rId, Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("jiName",jiName);
        map.put("pId",pId);
        map.put("rId",rId);
        PageHelper.startPage(pageNum, pageSize);
        List<JoinInfo> joinInfos = joinInfoMapper.findJoinInfoByCondition(map);
        return new PageInfo<JoinInfo>(joinInfos);
    }

    /**
     * 查询 ：查询总记录数
     * @return
     */
    @Override
    public int findCount() {
        return joinInfoMapper.findCount();
    }
}
