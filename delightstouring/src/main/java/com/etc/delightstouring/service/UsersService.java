package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Users;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UsersService {


    /**
     * 增：新增用户信息
     * @param users
     * @return
     */
    boolean addUser(Users users);

    /**
     * 删：根据id删除用户信息
     * @param uId
     * @return
     */
    boolean delUserById(String uId);

    /**
     * 改：根据用户id修改信息
     * @param users
     * @return
     */
    boolean updateUserById(Users users);

    /**
     * 查：根据用户名和密码查询用户信息（登录）
     * @param username
     * @param password
     * @return
     */
    Users findUserByNameAndPwd(String username, String password);

    /**
     * 查：根据手机号码查询用户信息
     * @param phone
     * @return
     */
    Users findUserByPhone(String phone);

    /**
     * 查：根据用户id查询
     * @param uId
     * @return
     */
    Users findUserById(String uId);

    /**
     * 查：根据用户名称查询
     * @param username
     * @return
     */
    Users findUserByName(String username);

    /**
     * 查：根据用户名称模糊查询
     * @param username
     * @return
     */
    PageInfo<Users> findUserLikeName(String username, Integer curPage, Integer pageSize);

    /**
     * 查：根据用户名和用户名是否存在查询记录
     * @param username
     * @param uExists
     * @param curPage
     * @param pageSize
     * @return
     */
    PageInfo<Users> findUsersLikeByNameAndExists(String username, Integer uExists, Integer pageNum, Integer pageSize);

    /**
     * 查：查询总记录数
     * @return
     */
    int findCount();
}
