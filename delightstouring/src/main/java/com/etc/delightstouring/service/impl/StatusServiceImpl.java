package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Status;
import com.etc.delightstouring.mapper.StatusMapper;
import com.etc.delightstouring.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StatusServiceImpl
 * @Description TODO 审核状态表
 * @Author Administrator
 * @Date 20/10/27 11:39
 * @Version 1.0
 **/
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusMapper statusMapper;

    /**
     * 增：新增一条记录
     * @param status
     * @return
     */
    @Override
    public boolean addStatus(Status status) {
        if (statusMapper.findStatusByName(status.getsName()) == null) {
            return statusMapper.addStatus(status) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 删：根据编号删除一条记录
     * @param sid
     * @return
     */
    @Override
    public boolean delStatusById(Integer sid) {
        return statusMapper.delStatusById(sid) > 0 ? true : false;
    }

    /**
     * 修改：根据编号修改记录
     * @param status
     * @return
     */
    @Override
    public boolean updateStatusById(Status status) {
        return statusMapper.updateStatusById(status) > 0 ? true : false;
    }

    /**
     * 查：查询所有记录
     * @return
     */
    @Override
    public List<Status> findAllStatus() {
        return statusMapper.findAllStatus();
    }

    /**
     * 查：根据编号查询一条记录
     * @param sid
     * @return
     */
    @Override
    public Status findStatusById(Integer sid) {
        return statusMapper.findStatusById(sid);
    }

    /**
     * 查：根据名称查询一条记录
     * @param sName
     * @return
     */
    @Override
    public Status findStatusByName(String sName) {
        return statusMapper.findStatusByName(sName);
    }

    /**
     * 查：查询总记录数
     * @return
     */
    @Override
    public int findCount() {
        return statusMapper.findCount();
    }
}
