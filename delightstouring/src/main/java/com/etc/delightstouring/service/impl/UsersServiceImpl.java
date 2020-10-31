package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Users;
import com.etc.delightstouring.mapper.UserMapper;
import com.etc.delightstouring.service.UsersService;
import com.etc.delightstouring.utils.CounterUtil;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增
     * @param users
     * @return
     */
    @Override
    public boolean addUser(Users users) {
        if(userMapper.findUserByName(users.getUsername())==null){
            users.setUUID(UUIDUtil.getUUID());
            users.setuId(CounterUtil.getCounterStr("user", findCount()));
            users.setuExists(1);
            return userMapper.addUser(users) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 根据id删除用户信息
     * @param uId
     * @return
     */
    @Override
    public boolean delUserById(String uId) {
        return userMapper.delUserById(uId) > 0 ? true : false;
    }


    /**
     * 根据用户id修改信息
     * @param users
     * @return
     */
    @Override
    public boolean updateUserById(Users users) {
        return userMapper.updateUserById(users) > 0 ? true : false;
    }

    /**
     * 查：根据用户名和密码查询用户信息（登录）
     * @param username
     * @param password
     * @return
     */
    @Override
    public Users findUserByNameAndPwd(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password", password);
        return userMapper.findUserByNameAndPwd(map);
    }

    /**
     * 查：根据手机号查询用户信息
     * @param phone
     * @return
     */
    @Override
    public Users findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    /**
     * 根据用户id查询
     * @param uId
     * @return
     */
    @Override
    public Users findUserById(String uId) {
        return userMapper.findUserById(uId);
    }

    /**
     * 根据用户名称模糊查询,分页
     * @param username
     * @return
     */
    @Override
    public PageInfo<Users> findUserLikeName(String username, Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<Users> list = userMapper.findUserLikeName(username);
        PageInfo<Users> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 模糊分页查询：根据用户名和用户是否存在查询用户信息
     * @param username
     * @param uExists
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Users> findUsersLikeByNameAndExists(String username, Integer uExists, Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("uExists", uExists);
        PageHelper.startPage(pageNum, pageSize);
        List<Users> users = userMapper.findUsersLikeByNameAndExists(map);
        return new PageInfo<Users>(users);
    }

    /**
     * 根据用户名称查询
     * @param username
     * @return
     */
    @Override
    public Users findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    /**
     * 查询全部用户
     * @return
     */
    @Override
    public int findCount() {
        return userMapper.findCount();
    }
}
