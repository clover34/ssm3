package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Admin;
import com.etc.delightstouring.mapper.AdminMapper;
import com.etc.delightstouring.service.AdminService;
import com.etc.delightstouring.utils.CounterUtil;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 新增
     * @param admin
     * @return
     */
    @Override
    public boolean addAdmin(Admin admin) {
        if(findAdminByName(admin.getaName()) == null){
            admin.setUUID(UUIDUtil.getUUID());// 设置 UUID
            admin.setaId(CounterUtil.getCounterStr("admin", findCount()));// 设置编号
            admin.setaExists(1);// 默认在职
            return adminMapper.addAdmin(admin)>0?true:false;
        }
        return false;
    }

    /**
     * 根据管理员编号删除
     * @param aId
     * @return
     */
    @Override
    public boolean delAdminById(String aId) {
        return adminMapper.delAdminById(aId)>0?true:false;
    }

    /**
     * 根据管理员编号修改
     * @param admin
     * @return
     */
    @Override
    public boolean updateAdminById(Admin admin) {
        return adminMapper.updateAdminById(admin)>0?true:false;
    }

    /**
     * 根据管理员编号查询信息
     * @param aId
     * @return
     */
    @Override
    public Admin findAdminById(String aId) {
        return adminMapper.findAdminById(aId);
    }

    /**
     * 根据姓名查找
     * @param aName
     * @return
     */
    @Override
    public Admin findAdminByName(String aName) {
        return adminMapper.findAdminByName(aName);
    }

    /**
     * 分页，根据名称模糊查询
     * @param aName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Admin> findAdminLikeName(String aName, String eExists, Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("aName", aName);
        map.put("eExists",eExists);
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = adminMapper.findAdminLikeName(map);
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 查：根据用户名和密码查询用户信息（登录）
     * @param aName
     * @param password
     * @return
     */
    @Override
    public Admin findAdminByNameAndPwd(String aName, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("aName", aName);
        map.put("password",password);
        return adminMapper.findAdminByNameAndPwd(map);
    }

    /**
     * 查询表总记录数
     * @return
     */
    @Override
    public int findCount() {
        return adminMapper.findCount();
    }
}
