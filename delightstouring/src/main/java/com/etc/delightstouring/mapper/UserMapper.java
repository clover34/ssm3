package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 增：新增用户信息
     * @param users
     * @return
     */
    int addUser(Users users);

    /**
     * 删：根据id删除用户信息
     * @param uId
     * @return
     */
    int delUserById(String uId);

    /**
     * 改：根据用户id修改信息
     * @param users
     * @return
     */
    int updateUserById(Users users);

    /**
     * 查：根据用户名和密码查询用户信息（登录）
     * @param map
     * @return
     */
    Users findUserByNameAndPwd(Map<String, Object> map);

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
    List<Users> findUserLikeName(String username);

    /**
     * 查：根据用户名和用户名是否存在查询记录
     * @param map
     * @return
     */
    List<Users> findUsersLikeByNameAndExists(Map<String ,Object> map);

    /**
     * 查：查询总记录数
     * @return
     */
    int findCount();
}
