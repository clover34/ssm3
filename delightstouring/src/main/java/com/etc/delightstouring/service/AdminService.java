package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AdminService {

    /**
     * 新增管理员信息
     * @param admin
     * @return
     */
    boolean addAdmin(Admin admin);

    /**
     * 根据管理员编号删除管理员信息
     * @param aId
     * @return
     */
    boolean delAdminById(String aId);

    /**
     * 根据管理员编号修改管理员信息
     * @param admin
     * @return
     */
    boolean updateAdminById(Admin admin);

    /**
     * 根据管理员编号查询信息
     * @param aId
     * @return
     */
    Admin findAdminById(String aId);

    /**
     * 查：根据名称查询记录
     * @param aName
     * @return
     */
    Admin findAdminByName(String aName);

    /**
     * 查：根据管理员姓名模糊查询
     * @param aName
     * @return
     */
    PageInfo<Admin> findAdminLikeName(String aName, String eExists, Integer pageNum, Integer pageSize);

    /**
     * 查：根据用户名和密码查询管理员信息（登录）
     * @param a_name
     * @param password
     * @return
     */
    Admin findAdminByNameAndPwd(String a_name, String password);

    /**
     * 查：查询表记录数
     * @return
     */
    int findCount();
}
