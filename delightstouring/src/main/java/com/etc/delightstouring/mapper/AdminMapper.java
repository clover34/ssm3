package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Admin;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    /**
     * 新增管理员信息
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 根据管理员编号删除管理员信息
     * @param aId
     * @return
     */
    int delAdminById(String aId);

    /**
     * 根据管理员编号修改管理员信息
     * @param admin
     * @return
     */
    int updateAdminById(Admin admin);

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
     * 查：根据用户名和是否在职查询管理员信息
     * @param map
     * @return
     */
    List<Admin> findAdminLikeName(Map<String, Object> map);

    /**
     * 查：根据用户名和密码查询管理员信息（登录）
     * @param map
     * @return
     */
    Admin findAdminByNameAndPwd(Map<String, Object> map);

    /**
     * 查：查询表记录数
     * @return
     */
    int findCount();
}
